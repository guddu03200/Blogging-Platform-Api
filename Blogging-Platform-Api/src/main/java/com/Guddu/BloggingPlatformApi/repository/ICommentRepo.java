package com.Guddu.BloggingPlatformApi.repository;

import com.Guddu.BloggingPlatformApi.model.Comment;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Long> {
}
