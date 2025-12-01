package com.shivam.projects.lovable_clone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
     @Id
     BigInteger id;
     String passwordHash;
     String email;
     String name;
     String avatarUrl;
     Instant createdAt;
     Instant updatedAt;
     Instant deletedAt;  //soft delete
}
