package com.shivam.projects.lovable_clone.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@AllArgsConstructor
public class Project {

    Long id;
    User owner;
    String name;
    Boolean isPublic;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;
}
