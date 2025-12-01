package com.shivam.projects.lovable_clone.entity;

import com.shivam.projects.lovable_clone.enumm.PreviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {

    Long id;

    Project project;

    String nameSpacce;
    String podName;
    String previewUrl;
    Instant createdAt;
    Instant startedAt;
    Instant terminatedAt;

    PreviewStatus previewStatus;
}
