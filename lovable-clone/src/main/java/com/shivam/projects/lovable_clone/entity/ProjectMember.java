package com.shivam.projects.lovable_clone.entity;

import com.shivam.projects.lovable_clone.enumm.ProjectRole;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class ProjectMember {
    ProjectMemberId projectMemberId;
    Project project;
    User user;
    ProjectRole role;
    User invitedBy;
    Instant invitedAt;
}
