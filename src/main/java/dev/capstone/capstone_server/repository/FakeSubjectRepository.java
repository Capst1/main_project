package dev.capstone.capstone_server.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import dev.capstone.capstone_server.domain.Subject;

@Profile("test")
@Repository
public class FakeSubjectRepository implements SubjectRepository {
	@Override
	public List<Subject> findAll() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return List.of(new Subject("fake subject"));
	}

	@Override
	public Optional<Subject> findById(Long id) {
		return Optional.of(new Subject("fake subject"));
	}
}
