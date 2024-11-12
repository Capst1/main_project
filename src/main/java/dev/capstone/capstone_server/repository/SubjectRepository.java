package dev.capstone.capstone_server.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;

import dev.capstone.capstone_server.domain.Subject;

public interface SubjectRepository {
	List<Subject> findAll();

	@Cacheable(value = "subjectCacheStore", key = "#id")
	Optional<Subject> findById(Long id);
}
