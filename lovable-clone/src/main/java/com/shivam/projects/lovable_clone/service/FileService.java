package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.project.FileContentResponse;
import com.shivam.projects.lovable_clone.dto.auth.project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
