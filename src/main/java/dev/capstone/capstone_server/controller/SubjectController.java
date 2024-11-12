package dev.capstone.capstone_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.capstone.capstone_server.controller.dto.SubjectResponse;
import dev.capstone.capstone_server.service.SubjectService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
	private final SubjectService subjectService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SubjectResponse> getSubject(@NotNull @PathVariable final Long id) {
		SubjectResponse subject = subjectService.getSubjectById(id);
		return ResponseEntity.ok(subject);
	}
}
