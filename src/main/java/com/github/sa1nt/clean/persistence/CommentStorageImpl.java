package com.github.sa1nt.clean.persistence;

import com.github.sa1nt.clean.domain.Comment;
import com.github.sa1nt.clean.domain.CommentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentStorageImpl implements CommentStorage {

    private static final String COMMENTS = "comments";

    private final MongoOperations mongoOperations;

    @Autowired
    public CommentStorageImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Optional<Comment> getComment(String id) {
        return Optional.ofNullable(this.mongoOperations.findById(id, Comment.class, COMMENTS));
    }

    @Override
    public Comment saveComment(Comment comment) {
        return this.mongoOperations.save(comment, COMMENTS);
    }
}
