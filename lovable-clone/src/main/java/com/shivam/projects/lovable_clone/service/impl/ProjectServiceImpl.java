package com.shivam.projects.lovable_clone.service.impl;

import com.shivam.projects.lovable_clone.Mapper.ProjectMapper;
import com.shivam.projects.lovable_clone.dto.auth.project.ProjectRequest;
import com.shivam.projects.lovable_clone.dto.auth.project.ProjectResponse;
import com.shivam.projects.lovable_clone.dto.auth.project.ProjectSummaryResponse;
import com.shivam.projects.lovable_clone.entity.Project;
import com.shivam.projects.lovable_clone.entity.ProjectMember;
import com.shivam.projects.lovable_clone.entity.ProjectMemberId;
import com.shivam.projects.lovable_clone.entity.User;
import com.shivam.projects.lovable_clone.enumm.ProjectRole;
import com.shivam.projects.lovable_clone.error.ResourceNotFoundException;
import com.shivam.projects.lovable_clone.repository.ProjectMemberRepository;
import com.shivam.projects.lovable_clone.repository.ProjectRepository;
import com.shivam.projects.lovable_clone.repository.UserRepository;
import com.shivam.projects.lovable_clone.service.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User",userId.toString()));
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

        return projectMapper.toProjectResponse(project);
    }
    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }
    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = projectRepository.findAccessibleProjectById(id,userId).orElseThrow(() -> new ResourceNotFoundException("Project",id.toString()));
        return projectMapper.toProjectResponse(project);
    }
    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest projectRequest, Long userId) {
        Project project = projectRepository.findAccessibleProjectById(id,userId).orElseThrow();
        project.setName(projectRequest.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }
    @Override
    public void softDelete(Long id, Long userId) {
      Project project = projectRepository.findAccessibleProjectById(id,userId).orElseThrow();

  //    if(!project.getOwner().getId().equals(userId)){ throw new RuntimeException("You are not allowed to delete"); }
      project.setDeletedAt(Instant.now());
      projectRepository.save(project);

    }
}
