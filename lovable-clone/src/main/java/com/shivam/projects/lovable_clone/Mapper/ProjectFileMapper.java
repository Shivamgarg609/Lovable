package com.shivam.projects.lovable_clone.Mapper;

import com.shivam.projects.lovable_clone.dto.auth.project.FileNode;
import com.shivam.projects.lovable_clone.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.io.File;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);
}
