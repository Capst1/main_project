package dev.capstone.capstone_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.capstone.capstone_server.domain.Subject;

public interface JpaSubjectRepository extends SubjectRepository, JpaRepository<Subject, Long> {
	List<Subject> findAll();
}
