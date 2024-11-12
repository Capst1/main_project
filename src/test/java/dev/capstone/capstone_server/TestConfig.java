package dev.capstone.capstone_server;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import dev.capstone.capstone_server.repository.FakeSubjectRepository;
import dev.capstone.capstone_server.repository.SubjectRepository;

@TestConfiguration
public class TestConfig {
	@Bean
	public SubjectRepository subjectRepository() {
		return new FakeSubjectRepository();
	}
}
