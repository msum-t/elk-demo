package com.elk.demo.elasticsearchdemo;

import com.elk.demo.elasticsearchdemo.model.User;
import com.elk.demo.elasticsearchdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RestController
public class ElasticSearchDemoApplication {




    private UserRepository userRepository;

	private ElasticsearchOperations operations;

	public ElasticSearchDemoApplication(UserRepository userRepository, ElasticsearchOperations operations) {
		this.userRepository = userRepository;
		this.operations = operations;
	}

	@PostConstruct
	public void insertDataSample() {
		operations.indexOps(User.class).refresh();

		userRepository.save(new User(1,"sumit","abc","hyd"));
	}

	@PostMapping("/saveUser")
	public Integer save(@RequestBody List<User> users){
		userRepository.saveAll(users);
		return users.size();
	}

	@GetMapping("/getAll")
	public Iterable<User> findAll(){
		return userRepository.findAll();
	}

	public static void main(String[] args) {
        SpringApplication.run(ElasticSearchDemoApplication.class, args);
    }

}
