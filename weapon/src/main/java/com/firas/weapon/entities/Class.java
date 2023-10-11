package com.firas.weapon.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClass;
	private String nomClass;
	private String descClass;
	
	@OneToMany(mappedBy= "classe")
	@JsonIgnore
	private List<Weapon> weapons;


	
	
	/*public Class(Long idClass, String nomClass, String descClass, List<Weapon> weapons) {
		super();
		
		this.nomClass = nomClass;
		this.descClass = descClass;
		this.weapons = weapons;
	}
	public Class() {
		super();
	}
	public Long getIdClass() {
		return idClass;
	}
	public void setIdClass(Long idClass) {
		this.idClass = idClass;
	}
	public String getNomClass() {
		return nomClass;
	}
	public void setNomClass(String nomClass) {
		this.nomClass = nomClass;
	}
	public String getDescClass() {
		return descClass;
	}
	public void setDescClass(String descClass) {
		this.descClass = descClass;
	}
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	
	*/
}
