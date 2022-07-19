package com.diary.nightmaremonsters.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TB_MONSTER_PROFILE")
public class Monster extends Land implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name="NAME", nullable = false, unique = true, length = 50)
	private String name;
	
	@Column(name="TYPE", nullable = false, unique = false, length = 30)
	private String type;
	
	@Column(name="DESCRIPTION", nullable = false, unique = false, length = 1000)
	private String description; 
	
	@Column(name="FEATURES", nullable = false, unique = false, length = 70)
	private String[] features; 
	
	@Column(name="DIET", nullable = false, unique = false, length = 30)
	private String[] diet;
	
	@Column(name="DANGER_SCORE", nullable = false, unique = false, length = 30)
	private Integer dangerScore;
	
	@Column(name="WEAKNESS", nullable = false, unique = false, length = 70)
	private String weakness;
	
}
