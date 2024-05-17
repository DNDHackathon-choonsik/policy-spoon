package com.example.policyspoon.boundedContext.comment.controller;

import com.example.policyspoon.boundedContext.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/review/{reviewId}/comments")
public class CommentController {

    private final CommentService commentService;
}
