package com.ivasi.ecar.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty
    private String id;
    @JsonProperty
    private String title;
    @JsonProperty
    @Column(columnDefinition = "VARCHAR (2048)")
    private String content;

    public Comment(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
