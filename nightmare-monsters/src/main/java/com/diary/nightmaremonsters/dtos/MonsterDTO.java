package com.diary.nightmaremonsters.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonsterDTO {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String type;
	
	@NotBlank
	private String description; 
	
	@NotNull
	private String[] features; 
	
	@NotNull
	private String[] diet;
	
	@NotBlank
	private String weakness;
	
}
