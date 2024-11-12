package dev.capstone.capstone_server.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.capstone.capstone_server.domain.Subject;

public record SubjectResponse(
	Long id,
	String name
) {

	@JsonCreator
	public SubjectResponse(
		@JsonProperty("id") Long id,
		@JsonProperty("name") String name
	) {
		this.id = id;
		this.name = name;
	}

	public static SubjectResponse from(Subject subject) {
		return new SubjectResponse(subject.getId(), subject.getName());
	}
}
