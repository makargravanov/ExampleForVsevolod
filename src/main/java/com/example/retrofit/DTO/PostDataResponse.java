package com.example.retrofit.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDataResponse extends DefaultDTO {
    String name;
    String job;
    String id;
    String createdAt;
}
