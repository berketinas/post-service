package com.berketinas.sm.postservice.service;

import com.berketinas.sm.postservice.domain.Post;
import com.berketinas.sm.postservice.dto.IPostDTO;
import com.berketinas.sm.postservice.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    private final PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public List<IPostDTO> getAllPosts(UUID user) {
        List<IPostDTO> allPosts = repo.findDtoByUser(user);
        return allPosts;
    }

    public IPostDTO getPost(UUID id) {
        IPostDTO post = repo.findDtoById(id);
        return post;
    }

    public void update(UUID user, Post post) {
        Post newPost = new Post(post.getId(), user, post.getTitle(), post.getBody());
        repo.save(newPost);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
