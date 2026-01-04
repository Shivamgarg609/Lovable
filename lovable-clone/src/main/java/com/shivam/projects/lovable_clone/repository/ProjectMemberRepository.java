package com.shivam.projects.lovable_clone.repository;

import com.shivam.projects.lovable_clone.entity.ProjectMember;
import com.shivam.projects.lovable_clone.entity.ProjectMemberId;
import com.shivam.projects.lovable_clone.enumm.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

    @Query(""" 
           Select pm.projectRole FROM ProjectMember pm 
           WHERE pm.id.projectId =  :projectId AND pm.id.userId = :userId
           """)
    Optional<ProjectRole> findRoleByProjectIdAndUserId(@Param("userId") Long userId,@Param("projectId") Long projectId);
}
