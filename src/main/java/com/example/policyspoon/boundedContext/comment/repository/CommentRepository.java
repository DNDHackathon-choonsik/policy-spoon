package com.example.policyspoon.boundedContext.comment.repository;

import com.example.policyspoon.boundedContext.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
