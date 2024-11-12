package dev.capstone.capstone_server.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {

	// @Bean
	// public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
	// 	ObjectMapper objectMapper = new ObjectMapper();
	// 	objectMapper.findAndRegisterModules(); // 모듈 등록으로 JSON 변환 기능 확장
	//
	// 	RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
	// 		.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
	// 		.serializeValuesWith(
	// 			RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
	// 		.entryTtl(Duration.ofMinutes(3L));
	//
	// 	return RedisCacheManager.builder(connectionFactory)
	// 		.cacheDefaults(redisCacheConfiguration)
	// 		.build();
	// }
}
