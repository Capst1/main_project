package dev.capstone.capstone_server.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.capstone.capstone_server.controller.dto.SubjectResponse;
import dev.capstone.capstone_server.domain.Subject;
import dev.capstone.capstone_server.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class SubjectService {
	private final SubjectRepository subjectRepository;

	public List<SubjectResponse> getAllSubjects() {
		return subjectRepository.findAll().stream().map(SubjectResponse::from).toList();
	}

	public SubjectResponse getSubjectById(Long id) {
		Subject subject = subjectRepository.findById(id).orElseThrow(RuntimeException::new);
		return SubjectResponse.from(subject);
	}
}
