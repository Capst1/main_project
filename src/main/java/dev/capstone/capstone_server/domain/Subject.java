package dev.capstone.capstone_server.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Subject implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(unique = true, nullable = false)
	String name;

	protected Subject() {
	}

	public Subject(String name) {
		this.name = name;
	}

	public Subject(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
