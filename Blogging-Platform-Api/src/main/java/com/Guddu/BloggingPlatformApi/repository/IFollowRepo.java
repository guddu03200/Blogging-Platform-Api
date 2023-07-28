package com.Guddu.BloggingPlatformApi.repository;

import com.Guddu.BloggingPlatformApi.model.Follow;
import com.Guddu.BloggingPlatformApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFollowRepo extends JpaRepository<Follow, Long> {
    List<Follow> findByCurrentUserAndFollower(User followBlogger, User follower);
}
