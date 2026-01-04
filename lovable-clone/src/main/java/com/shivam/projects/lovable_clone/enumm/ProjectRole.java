package com.shivam.projects.lovable_clone.enumm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.shivam.projects.lovable_clone.enumm.ProjectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    OWNER(Set.of(ProjectPermission.EDIT, VIEW,ProjectPermission.MANAGE_MEMBERS,ProjectPermission.DELETE,VIEW_MEMBERS)),
    EDITOR(VIEW,DELETE,EDIT),
    VIEWER(VIEW,VIEW_MEMBERS);

    ProjectRole(ProjectPermission... permissions){
        this.permissions = Set.of(permissions);
    }

    private final Set<ProjectPermission> permissions;
}
