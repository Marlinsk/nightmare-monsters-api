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
public class Monster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name="MONSTER_NAME", nullable = false, unique = true, length = 70)
	private String name;
	
	@Column(name="TYPE", nullable = false, unique = false, length = 70)
	private String type;
	
	@Column(name="DESCRIPTION", nullable = false, unique = false, length = 1000)
	private String description; 
	
	@Column(name="FEATURES", nullable = false, unique = false, length = 70)
	private String[] features; 
	
	@Column(name="DIET", nullable = false, unique = false, length = 70)
	private String[] diet;
	
	@Column(name="WEAKNESS", nullable = false, unique = false, length = 70)
	private String weakness;
	
}
