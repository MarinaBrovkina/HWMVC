package org.example.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.example.model.Post;
import org.example.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    public static final String APPLICATION_JSON = "application/json";
    private final PostService service;
    final Gson gson = new Gson();

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public void all(HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var data = service.all();
        response.getWriter().print(gson.toJson(data));
    }

    @GetMapping("/{id}")
    public void getById(@PathVariable long id, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var post = service.getById(id);
        response.getWriter().print(gson.toJson(post));
    }

    @PostMapping
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var post = gson.fromJson(request.getReader(), Post.class);
        final var data = service.save(post);
        response.getWriter().print(gson.toJson(data));
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id, HttpServletResponse response) {
        service.removeById(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}