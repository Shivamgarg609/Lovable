package com.shivam.projects.lovable_clone.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectMemberId {

    Long userId;
    Long projectId;
}
