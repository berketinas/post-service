package com.berketinas.sm.postservice.controller;

import com.berketinas.sm.postservice.domain.Post;
import com.berketinas.sm.postservice.dto.IPostDTO;
import com.berketinas.sm.postservice.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PostController {
    private final PostService service;

    PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String test() {
        return "hello";
    }

    @GetMapping("/index")
    public List<IPostDTO> getAllPosts(@RequestHeader UUID user) {
        return service.getAllPosts(user);
    }

    @GetMapping("/show")
    public IPostDTO getPost(@RequestParam UUID id) {
        return service.getPost(id);
    }

    @PostMapping("/new")
    public void update(@RequestHeader UUID user, @RequestBody Post post) {
        service.update(user, post);
    }

    @DeleteMapping("/")
    public void delete(@RequestParam UUID id) {
        service.delete(id);
    }
}
