package com.emrealkan.restapiforkotlin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private Long isbnNumber;
    private String name;
    private Long categoryId;
}
