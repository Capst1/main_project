package dev.capstone.capstone_server.repository;

import java.util.List;
import java.util.Optional;

import dev.capstone.capstone_server.domain.Subject;

public interface SubjectRepository {
	List<Subject> findAll();

	Optional<Subject> findById(Long id);
}
