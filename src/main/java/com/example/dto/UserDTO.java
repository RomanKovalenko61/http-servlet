package com.example.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDTO {

    Long id;
    String mail;
}