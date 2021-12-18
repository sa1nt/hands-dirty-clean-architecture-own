package com.github.sa1nt.clean.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentStorage commentStorage;

    @Autowired
    public CommentService(CommentStorage commentStorage) {
        this.commentStorage = commentStorage;
    }

    public Comment getComment(String id) {
        return commentStorage.getComment(id)
                .orElseThrow(() -> new RuntimeException(String.format("Comment id %s not found", id)));
    }

    public Comment createOrUpdate(Comment comment) {
        if (comment.body().length() > 128) {
            throw new RuntimeException(String.format("Comment %s body length too large", comment.id()));
        }

        return commentStorage.saveComment(comment);
    }
}
