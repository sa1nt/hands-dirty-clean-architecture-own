package com.github.sa1nt.clean.unit;

import com.github.sa1nt.clean.domain.Comment;
import com.github.sa1nt.clean.domain.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommentServiceTest {
    private CommentService commentService;

    @BeforeEach
    void setUp() {
        this.commentService = new CommentService(new FakeCommentStorageImpl());
    }

    @Test
    void test_getNonExisting() {
        String commentId = "non existing";
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> this.commentService.getComment(commentId)
        );

        assertEquals("Comment id " + commentId + " not found", exception.getMessage());
    }

    @Test
    void test_createAndGetComment() {
        String testBody = "test";
        var c = new Comment(null, testBody);

        Comment createdComment = this.commentService.createOrUpdate(c);
        assertEquals(testBody, createdComment.body());

        Comment fetchedComment = this.commentService.getComment(createdComment.id());
        assertEquals(fetchedComment, createdComment);
    }
}
