package com.emrealkan.restapiforkotlin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String userName;
    private String role;
    private String email;
    private String profileImgUrl;
}
