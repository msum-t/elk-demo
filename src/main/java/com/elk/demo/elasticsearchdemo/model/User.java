package com.elk.demo.elasticsearchdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Document(indexName = "docker-cluster",createIndex = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String zipcode;
    private String address;


}
