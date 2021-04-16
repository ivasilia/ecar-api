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
        if (this.commentsRepo.count() == 0) {
            Comment comment1 = new Comment("Ostavka!.....",
                    "A knave; a rascal; an eater of broken meats; a\n" +
                            "base, proud, shallow, beggarly, three-suited,\n" +
                            "hundred-pound, filthy, worsted-stocking knave; a\n" +
                            "lily-livered, action-taking knave, a whoreson,\n" +
                            "glass-gazing, super-serviceable finical rogue;\n" +
                            "one-trunk-inheriting slave; one that wouldst be a\n" +
                            "bawd, in way of good service, and art nothing but\n" +
                            "the composition of a knave, beggar, coward, pandar,\n" +
                            "and the son and heir of a mongrel bitch: one whom I\n" +
                            "will beat into clamorous whining, if thou deniest\n" +
                            "the least syllable of thy addition.");
            Comment comment2 = new Comment("Dostavka!.....",
                    "Yet better thus, and known to be contemn'd,\n" +
                            "Than still contemn'd and flatter'd. To be worst,\n" +
                            "The lowest and most dejected thing of fortune,\n" +
                            "Stands still in esperance, lives not in fear:\n" +
                            "The lamentable change is from the best;\n" +
                            "The worst returns to laughter. Welcome, then,\n" +
                            "Thou unsubstantial air that I embrace!\n" +
                            "The wretch that thou hast blown unto the worst\n" +
                            "Owes nothing to thy blasts. But who comes here?");
            Comment comment3 = new Comment("Podstavka!.....", "Lorem ostavka, ipsum ostavka...");
            Comment comment4 = new Comment("Pristavka!.....", "Lorem ostavka, ipsum ostavka...");
            Comment comment5 = new Comment("Buy me a coffee!.....", "Lorem ostavka, ipsum ostavka...");
            Comment comment6 = new Comment("Buy me a cake!.....", "Lorem ostavka, ipsum ostavka...");

            this.commentsRepo.saveAll(List.of(
                    comment1, comment2, comment3, comment4, comment5, comment6
            ));
        }
    }
}
