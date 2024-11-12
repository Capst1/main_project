package dev.capstone.capstone_server;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import dev.capstone.capstone_server.repository.FakeSubjectRepository;
import dev.capstone.capstone_server.repository.SubjectRepository;

@EnableCaching
@TestConfiguration
public class TestConfig {
	@Bean
	public SubjectRepository subjectRepository() {
		return new FakeSubjectRepository();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
}
