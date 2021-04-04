package com.ivasi.ecar.users.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties({"authorities", "accountNonExpired", "accountNonLocked", "credentialsNonExpired", "enabled"})
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NonNull
    @Length(min = 4, max = 45, message = "Username must contain between 4 and 45 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @NonNull
    @NotNull
    @Length(min = 4, max = 255, message = "Password must contain minimum 4 characters")
    private String password;

    @NonNull
    @Email(message = "Enter valid email address!")
    private String email;

    @Length(min = 1, message = "Enter valid first name!")
    private String firstName;

    @Length(min = 1, message = "Enter valid last name!")
    private String lastName;

    @OneToOne(mappedBy = "user")
    private Driver driver;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<AuthorityEntity> authorities = new ArrayList<>();

    private LocalDateTime registeredOn = LocalDateTime.now();
    private LocalDateTime lastVisit;
    private boolean active = false;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
    private String Address;

    @Column(columnDefinition = "VARCHAR(45) DEFAULT NULL")
    private String phoneNr;

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
