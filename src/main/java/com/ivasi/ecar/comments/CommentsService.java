package com.ivasi.ecar.comments;

import java.util.Collection;

public interface CommentsService {
    Collection<Comment> getAll();

    void initializeComments();
}
