package dev.capstone.capstone_server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;

import dev.capstone.capstone_server.service.SubjectService;

@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
public class SubjectServiceCacheTest {

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@BeforeEach
	public void clearCache() {
		// Redis 캐시 초기화
		redisTemplate.getConnectionFactory().getConnection().flushDb();
	}

	@Test
	@DisplayName("레디스 캐싱 테스트")
	public void testCacheable() {
		// 첫 번째 호출: 캐시되지 않은 상태이므로 3초 지연 발생
		long start = System.currentTimeMillis();
		subjectService.getSubjectById(2019100000L);
		long firstCallDuration = System.currentTimeMillis() - start;

		// 두 번째 호출: 캐시된 결과 반환이므로 지연 없음
		start = System.currentTimeMillis();
		subjectService.getSubjectById(2019100000L);
		long secondCallDuration = System.currentTimeMillis() - start;
		assertTrue(firstCallDuration > 3000);
		assertTrue(secondCallDuration < 100); // 캐시된 응답은 바로 반환
	}
}
