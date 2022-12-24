package com.elk.demo.elasticsearchdemo.repo;

import com.elk.demo.elasticsearchdemo.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Integer> {
}
