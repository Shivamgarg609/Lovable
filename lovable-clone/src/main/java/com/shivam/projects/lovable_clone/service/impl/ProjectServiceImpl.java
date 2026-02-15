package com.shivam.projects.lovable_clone.service.impl;

import com.shivam.projects.lovable_clone.Mapper.ProjectMapper;
import com.shivam.projects.lovable_clone.dto.auth.project.*;
import com.shivam.projects.lovable_clone.entity.*;
import com.shivam.projects.lovable_clone.enumm.ProjectRole;
import com.shivam.projects.lovable_clone.error.BadRequestException;
import com.shivam.projects.lovable_clone.error.ResourceNotFoundException;
import com.shivam.projects.lovable_clone.repository.ProjectMemberRepository;
import com.shivam.projects.lovable_clone.repository.ProjectRepository;
import com.shivam.projects.lovable_clone.repository.UserRepository;
import com.shivam.projects.lovable_clone.security.AuthUtil;
import com.shivam.projects.lovable_clone.service.ProjectService;
import com.shivam.projects.lovable_clone.service.ProjectTemplateService;
import com.shivam.projects.lovable_clone.service.SubscriptionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    AuthUtil authUtil;
    SubscriptionService subscriptionService;
    ProjectTemplateService projectTemplateService;
    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {

        if(subscriptionService.canCreateNewProject()){
            throw new BadRequestException("User cannot create a new Project with current plan. Upgrade plan now");
        }
        Long userId = authUtil.getCurrentUserId();
        User owner = userRepository.getReferenceById(userId);


        Project project = Project.builder().name(projectRequest.name()).isPublic(false).build();
        project = projectRepository.save(project);
        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(),owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);
        projectTemplateService.initializeProjectFromTemplate(project.getId());
        return projectMapper.toProjectResponse(project);
    }
    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        var projectsWithRoles = projectRepository.findAllAccessibleByUser(userId);
        return projectsWithRoles.stream()
                .map(p -> projectMapper.toProjectSummaryResponse(p.getProject(), p.getRole()))
                .toList();
    }
    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectSummaryResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        var projectWithRole = projectRepository.findAccessibleProjectByIdWithRole(projectId, userId)
                .orElseThrow(() -> new BadRequestException("Project Not Found"));

        return projectMapper.toProjectSummaryResponse(projectWithRole.getProject(), projectWithRole.getRole());
    }
    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest projectRequest) {
        Long userId = authUtil.getCurrentUserId();
        Project project = projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
        project.setName(projectRequest.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }
    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
      Project project = projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
      //    if(!project.getOwner().getId().equals(userId)){ throw new RuntimeException("You are not allowed to delete"); }
      project.setDeletedAt(Instant.now());
      projectRepository.save(project);

    }
}
