package com.github.sa1nt.clean.unit;

import com.github.sa1nt.clean.domain.Comment;
import com.github.sa1nt.clean.domain.CommentStorage;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakeCommentStorageImpl implements CommentStorage {
    private final Map<String, Comment> storage = new HashMap<>();

    @Override
    public Optional<Comment> getComment(String id) {
        return Optional.ofNullable(this.storage.get(id));
    }

    @Override
    public Comment saveComment(Comment comment) {
        Comment preparedComment = new Comment(
                comment.id() == null ? ObjectId.get().toString() : comment.id(),
                comment.body()
        );

        String id = preparedComment.id();
        this.storage.put(id, preparedComment);
        return this.storage.get(id);
    }
}
