package com.projectjee.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeedto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
