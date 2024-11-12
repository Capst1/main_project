package dev.capstone.capstone_server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.ActiveProfiles;

import dev.capstone.capstone_server.service.SubjectService;

@EnableCaching
@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
public class SubjectServiceCacheTest {

	@Autowired
	private SubjectService subjectService;

	@Test
	public void testCacheable() {
		// 첫 번째 호출: 캐시되지 않은 상태이므로 3초 지연 발생
		long start = System.currentTimeMillis();
		subjectService.getAllSubjects();
		long firstCallDuration = System.currentTimeMillis() - start;

		// 두 번째 호출: 캐시된 결과 반환이므로 지연 없음
		start = System.currentTimeMillis();
		subjectService.getAllSubjects();
		long secondCallDuration = System.currentTimeMillis() - start;
		System.out.println(secondCallDuration);
		assertTrue(firstCallDuration > 3000);
		assertTrue(secondCallDuration < 200); // 캐시된 응답은 바로 반환
	}
}
