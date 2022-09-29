package com.emrealkan.restapiforkotlin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookResponse {

  private Long id;
  private Long isbnNumber;
  private String name;
  private String categoryName;
  private Long categoryId;

}
