package com.example.policyspoon.boundedContext.photo.dto;

import com.example.policyspoon.boundedContext.photo.entity.Photo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoResponse {
    private Long id;
    private String path;
    private String originName;


    public static PhotoResponse of(Photo photo) {
        return PhotoResponse.builder()
                .id(photo.getId())
                .path(photo.getPath())
                .originName(photo.getName())
                .build();
    }

    public static List<PhotoResponse> of(List<Photo> photos) {
        return photos.stream()
                .map(PhotoResponse::of)
                .collect(Collectors.toList());
    }
}
