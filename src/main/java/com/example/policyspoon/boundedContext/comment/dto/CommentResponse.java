package com.example.policyspoon.boundedContext.comment.dto;

import com.example.policyspoon.boundedContext.comment.entity.Comment;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CommentResponse {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String writer;
    private String content;

    public static CommentResponse of(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .createdDate(comment.getCreatedDate())
                .lastModifiedDate(comment.getLastModifiedDate())
                //.writer(comment.getWriter().getNickname())
                .content(comment.getContent())
                .build();
    }

    public static List<CommentResponse> of(List<Comment> comments) {
        return comments.stream()
                .map(CommentResponse::of)
                .toList();
    }
}
