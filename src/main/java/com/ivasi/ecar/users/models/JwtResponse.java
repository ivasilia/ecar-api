package com.ivasi.ecar.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    @NonNull
    @NotNull
    private String jwt;

    @NonNull
    @NotNull
    private UserEntity user;
}
