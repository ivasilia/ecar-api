package com.ivasi.ecar.users.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "passengers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty
    private String id;
    @JsonProperty
    @NonNull
    private String name;
    @JsonProperty
    private String imageUrl;
    @JsonProperty
    private LocalDateTime registrationDate;
    @JsonProperty
    @Column(columnDefinition = "integer default 0")
    private double bonusPoints;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @ManyToMany(mappedBy = "passengers")
    private Set<Driver> drivers;

    public Passenger(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
