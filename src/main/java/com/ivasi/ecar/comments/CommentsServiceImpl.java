package com.ivasi.ecar.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    private final CommentsRepo commentsRepo;

    @Autowired
    public CommentsServiceImpl(CommentsRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    @Override
    public Collection<Comment> getAll() {
        return this.commentsRepo.findAll();
    }

    @Override
    public void initializeComments() {
        Comment comment1 = new Comment("Ostavka!.....", "Lorem ostavka, ipsum ostavka...");
        Comment comment2 = new Comment("Dostavka!.....", "Lorem ostavka, ipsum ostavka...");
        Comment comment3 = new Comment("Podstavka!.....", "Lorem ostavka, ipsum ostavka...");
        Comment comment4 = new Comment("Pristavka!.....", "Lorem ostavka, ipsum ostavka...");
        Comment comment5 = new Comment("Buy me a coffee!.....", "Lorem ostavka, ipsum ostavka...");
        Comment comment6 = new Comment("Buy me a cake!.....", "Lorem ostavka, ipsum ostavka...");

        this.commentsRepo.saveAll(List.of(
                comment1, comment2, comment3, comment4, comment5, comment6
        ));
    }
}
