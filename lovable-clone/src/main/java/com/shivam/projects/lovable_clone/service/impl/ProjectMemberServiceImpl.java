package com.shivam.projects.lovable_clone.service.impl;

import com.shivam.projects.lovable_clone.Mapper.ProjectMemberMapper;
import com.shivam.projects.lovable_clone.dto.auth.member.InviteMemberRequest;
import com.shivam.projects.lovable_clone.dto.auth.member.MemberResponse;
import com.shivam.projects.lovable_clone.dto.auth.member.UpdateMemberRoleRequest;
import com.shivam.projects.lovable_clone.entity.Project;
import com.shivam.projects.lovable_clone.entity.ProjectMember;
import com.shivam.projects.lovable_clone.entity.ProjectMemberId;
import com.shivam.projects.lovable_clone.entity.User;
import com.shivam.projects.lovable_clone.repository.ProjectMemberRepository;
import com.shivam.projects.lovable_clone.repository.ProjectRepository;
import com.shivam.projects.lovable_clone.repository.UserRepository;
import com.shivam.projects.lovable_clone.service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
       Project project = getAccessibleProject(projectId,userId);
       return projectMemberRepository.findByIdProjectId(projectId)
               .stream()
               .map(projectMemberMapper::toProjectMemberResponseFromMember)
               .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProject(projectId,userId);

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if (invitee.getId().equals(userId)) throw new RuntimeException("Cannot invite yourself");

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,invitee.getId());

        if(projectMemberRepository.existsById(projectMemberId)) throw new RuntimeException("Cannot invite again");

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.projectRole())
                .invitedAt(Instant.now())
                .build();

        return null;
    }

    @Override
    public MemberResponse updateMember(Long projectId, Long memberId, UpdateMemberRoleRequest inviteMemberRequest,Long userId) {
        Project project = getAccessibleProject(projectId,userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(inviteMemberRequest.projectRole());
        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProject(projectId,userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)) throw new RuntimeException("Cannot invite again");

        projectMemberRepository.deleteById(projectMemberId);
    }

    public Project getAccessibleProject(Long projectId, Long userId){
      Project project =  projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
      return project;
    }
}
