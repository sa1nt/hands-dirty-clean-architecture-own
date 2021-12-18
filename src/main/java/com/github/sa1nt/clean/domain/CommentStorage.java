package com.github.sa1nt.clean.domain;

import java.util.Optional;

public interface CommentStorage {
    Optional<Comment> getComment(String id);
    Comment saveComment(Comment comment);
}
