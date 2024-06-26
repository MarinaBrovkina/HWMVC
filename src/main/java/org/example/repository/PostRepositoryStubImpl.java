package org.example.repository;

import org.springframework.stereotype.Repository;
import org.example.model.Post;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryStubImpl implements PostRepository {
    public List<Post> all() {
        return Collections.emptyList();
    }

    public Optional<Post> getById(long id) {
        return Optional.empty();
    }

    public Post save(Post post) {
        return post;
    }

    public void removeById(long id) {
    }
}