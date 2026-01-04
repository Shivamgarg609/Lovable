package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.project.ProjectRequest;
import com.shivam.projects.lovable_clone.dto.auth.project.ProjectResponse;
import com.shivam.projects.lovable_clone.dto.auth.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getUserProjectById(Long id);

    ProjectResponse createProject(ProjectRequest projectRequest);

    ProjectResponse updateProject(Long id, ProjectRequest projectRequest);

    void softDelete(Long id);
}
