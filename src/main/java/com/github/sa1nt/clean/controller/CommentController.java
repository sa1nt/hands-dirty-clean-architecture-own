package com.github.sa1nt.clean.controller;

import com.github.sa1nt.clean.domain.Comment;
import com.github.sa1nt.clean.domain.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable String id) {
        return this.commentService.getComment(id);
    }

    @PostMapping
    public Comment createOrUpdateComment(@RequestBody Comment comment) {
        return this.commentService.createOrUpdate(comment);
    }
}
