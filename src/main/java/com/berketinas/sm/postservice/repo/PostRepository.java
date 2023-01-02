package com.berketinas.sm.postservice.repo;

import com.berketinas.sm.postservice.domain.Post;
import com.berketinas.sm.postservice.dto.IPostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    @Query(value = "SELECT CONCAT(users.given_name, ' ', users.family_name) AS user, posts.title AS title, posts.body AS body " +
            "FROM users, posts " +
            "WHERE users.id = :user AND posts.user_id = :user",
        nativeQuery = true)
    List<IPostDTO> findDtoByUser(@Param("user") UUID user);

    @Query(value = "SELECT CONCAT(users.given_name, ' ', users.family_name) AS user, posts.title AS title, posts.body AS body " +
            "FROM users, posts " +
            "WHERE posts.id = :id AND users.id = (SELECT user_id FROM posts WHERE id = :id)",
        nativeQuery = true)
    IPostDTO findDtoById(@Param("id") UUID id);
}
