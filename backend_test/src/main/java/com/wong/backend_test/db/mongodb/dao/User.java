package com.wong.backend_test.db.mongodb.dao;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private Integer age;
    private String name;
}
