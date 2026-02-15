package com.shivam.projects.lovable_clone.dto.auth.project;

import java.time.Instant;

public record FileNode(String path) {

@Override

    public String toString(){
    return  path;
}
}
