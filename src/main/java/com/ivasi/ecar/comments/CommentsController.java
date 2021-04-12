package com.ivasi.ecar.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController()
@RequestMapping("/comments")
@CrossOrigin
public class CommentsController {
    private final CommentsRepo commentsRepo;

    @Autowired
    public CommentsController(CommentsRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    @GetMapping("/all")
    public Collection<Comment> getAll() {
        return this.commentsRepo.findAll();
    }
}
