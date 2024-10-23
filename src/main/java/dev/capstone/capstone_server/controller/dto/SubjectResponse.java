package dev.capstone.capstone_server.controller.dto;

import dev.capstone.capstone_server.domain.Subject;

public record SubjectResponse(
	Long id,
	String name
) {
	public static SubjectResponse from(Subject subject) {
		return new SubjectResponse(subject.getId(), subject.getName());
	}
}
