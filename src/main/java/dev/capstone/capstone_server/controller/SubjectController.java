package dev.capstone.capstone_server.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.capstone.capstone_server.controller.dto.SubjectResponse;
import dev.capstone.capstone_server.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sugang")
public class SubjectController {
	private final SubjectRepository subjectRepository;

	@GetMapping(value = "/all")
	public ResponseEntity<List<SubjectResponse>> getAllSugang() {
		List<SubjectResponse> subjects = subjectRepository.findAll().stream().map(SubjectResponse::from).toList();
		return ResponseEntity.ok(subjects);
	}
}
