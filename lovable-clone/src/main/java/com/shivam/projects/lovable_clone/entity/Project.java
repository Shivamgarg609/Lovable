package com.shivam.projects.lovable_clone.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "projects",
indexes = {
        @Index(name = "idx_projects_updated_at_desc",columnList = "updated_at DESC, deleted_at"),
        @Index(name = "idx_projects_deleted_at_desc",columnList = "deleted_at , updated_at DESC"),
        @Index(name = "idx_project_deleted_at", columnList = "deleted_at")
})
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @ManyToOne
//    @JoinColumn(name = "owner_id", nullable = false)
//    User owner;

    @Column(nullable = false)
     String name;

    Boolean isPublic=false;

    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt;

    public String getName() {
        return name;
    }

}


//SELECT * FROM TABLE WHERE user_id = "hh" AND status = "CC"

// So from above query we understand that to select the order of index we use field which filter out most of the records
// in first filteration. This is the use of index to filter out the data results with use of combo of fields or single
// field as per out project database and functionality.