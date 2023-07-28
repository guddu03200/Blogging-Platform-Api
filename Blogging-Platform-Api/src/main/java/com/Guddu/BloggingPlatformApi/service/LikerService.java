package com.Guddu.BloggingPlatformApi.service;


import com.Guddu.BloggingPlatformApi.model.Like;
import com.Guddu.BloggingPlatformApi.model.Post;
import com.Guddu.BloggingPlatformApi.model.User;
import com.Guddu.BloggingPlatformApi.repository.ILikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikerService {

    @Autowired
    ILikeRepo likeRepo;

    public boolean isLikeAllowedOnThisPost(Post blogPost, User liker) {
        List<Like> likeList = likeRepo.findByPostAndLiker(blogPost, liker);
            return likeList != null && likeList.isEmpty();

    }

    public String addLike(Like like) {
        likeRepo.save(like);
        return "Blog post liked successfully";
    }

    public Integer getLikeCountForPost(Post validPost) {
        return likeRepo.findByPost(validPost).size();
    }

    public Like findById(Long likeId) {
        return likeRepo.findById(likeId).orElse(null);
    }
}
