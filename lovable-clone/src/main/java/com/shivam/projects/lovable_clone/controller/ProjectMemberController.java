package com.shivam.projects.lovable_clone.controller;

import com.shivam.projects.lovable_clone.dto.auth.member.InviteMemberRequest;
import com.shivam.projects.lovable_clone.dto.auth.member.MemberResponse;
import com.shivam.projects.lovable_clone.dto.auth.member.UpdateMemberRoleRequest;
import com.shivam.projects.lovable_clone.entity.ProjectMember;
import com.shivam.projects.lovable_clone.service.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/members")
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class ProjectMemberController {

     ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId) {

        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId, @RequestBody @Valid InviteMemberRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.inviteMember(projectId, request));

    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long projectId, @PathVariable Long memberId, @RequestBody @Valid UpdateMemberRoleRequest inviteMemberRequest,@PathVariable Long userId) {
        return ResponseEntity.ok(projectMemberService.updateMember(projectId, memberId,inviteMemberRequest));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable Long projectId, @PathVariable Long memberId){

        projectMemberService.removeProjectMember(projectId,memberId);
        return  ResponseEntity.noContent().build();
    }
}
