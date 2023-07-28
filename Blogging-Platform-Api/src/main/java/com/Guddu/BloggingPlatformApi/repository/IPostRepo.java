package com.Guddu.BloggingPlatformApi.repository;

import com.Guddu.BloggingPlatformApi.model.Enums.PostType;
import com.Guddu.BloggingPlatformApi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepo extends JpaRepository<Post, Long> {

}
