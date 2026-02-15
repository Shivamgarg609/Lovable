package com.shivam.projects.lovable_clone.controller;

import com.shivam.projects.lovable_clone.dto.auth.project.FileContentResponse;
import com.shivam.projects.lovable_clone.dto.auth.project.FileNode;
import com.shivam.projects.lovable_clone.dto.auth.project.FileTreeResponse;
import com.shivam.projects.lovable_clone.service.ProjectFileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class FileController {
     ProjectFileService projectFileService;
    @GetMapping  // if url is /api/projects/{projectId}/files then this getMapping will execute else the other one with big path
    public ResponseEntity<FileTreeResponse> getFileTree(@PathVariable Long projectId){
        return ResponseEntity.ok(projectFileService.getFileTree(projectId));
    }

    @GetMapping("/{*path}") // /src/hooks/get-user-hooks.jsx
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId, @RequestParam String path){
        Long userId = 1L;
        return ResponseEntity.ok(projectFileService.getFileContent(projectId, path ));
    }
}
