package com.Guddu.BloggingPlatformApi.repository;

import com.Guddu.BloggingPlatformApi.model.Like;
import com.Guddu.BloggingPlatformApi.model.Post;
import com.Guddu.BloggingPlatformApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILikeRepo extends JpaRepository<Like, Long> {
    List<Like> findByPostAndLiker(Post blogPost, User liker);

    List<Like> findByPost(Post validPost);
}
