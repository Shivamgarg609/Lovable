package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.project.ProjectRequest;
import com.shivam.projects.lovable_clone.dto.auth.project.ProjectResponse;
import com.shivam.projects.lovable_clone.dto.auth.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest projectRequest, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest projectRequest, Long userId);

    void softDelete(Long id, Long userId);
}
