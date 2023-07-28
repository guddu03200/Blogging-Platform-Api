package com.Guddu.BloggingPlatformApi.service;


import com.Guddu.BloggingPlatformApi.model.Comment;
import com.Guddu.BloggingPlatformApi.model.User;
import com.Guddu.BloggingPlatformApi.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public String addComment(Comment comment) {
        comment.setCommentCreationTimeStamp(LocalDateTime.now());
        commentRepo.save(comment);

        return "Comment added";
    }

    public Comment findComment(Long commentId) {
        return commentRepo.findById(commentId).orElse(null);
    }

    public void deleteComment(Comment comment) {
        commentRepo.delete(comment);
    }

    public Comment findCommentById(Long commentId) {
        return commentRepo.findById(commentId).orElse(null);
    }

    public boolean rightCommenter(Comment comment, User commenter) {
        return comment.getCommenter().equals(commenter);
    }

    public String updateComment(Comment comment, String updatedCommentBody) {
        comment.setCommentBody(updatedCommentBody);
        commentRepo.save(comment);

        return "Comment updated";
    }
}
