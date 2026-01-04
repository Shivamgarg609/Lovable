package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.member.InviteMemberRequest;
import com.shivam.projects.lovable_clone.dto.auth.member.MemberResponse;
import com.shivam.projects.lovable_clone.dto.auth.member.UpdateMemberRoleRequest;
import com.shivam.projects.lovable_clone.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMember(Long projectId, Long memberId, UpdateMemberRoleRequest inviteMemberRequest);

    void removeProjectMember(Long projectId, Long memberId);
}
