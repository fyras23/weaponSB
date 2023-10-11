package com.firas.weapon.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
public class Weapon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idWp;
	private String nomWp;
	private Double prixWp;
	private Date dateWp;
	@ManyToOne
	private Class classe;
	
	 /*@OneToOne
	 private Image image;*/
	
	
	@OneToMany (mappedBy = "weapon")
	 private List<Image> images;
	
	private String imagePath;



	
	
	/*
	
	public Weapon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Weapon(String nomWp, Double prixWp, Date dateWp) {
		super();
		this.nomWp = nomWp;
		this.prixWp = prixWp;
		this.dateWp = dateWp;
	}




	public Long getIdWp() {
		return idWp;
	}
	public void setIdWp(Long idWp) {
		this.idWp = idWp;
	}
	public String getNomWp() {
		return nomWp;
	}
	public void setNomWp(String nomWp) {
		this.nomWp = nomWp;
	}
	public Double getPrixWp() {
		return prixWp;
	}
	public void setPrixWp(Double prixWp) {
		this.prixWp = prixWp;
	}
	public Date getDateWp() {
		return dateWp;
	}
	public void setDateWp(Date dateWp) {
		this.dateWp = dateWp;
	}




	@Override
	public String toString() {
		return "Weapon [idWp=" + idWp + ", nomWp=" + nomWp + ", prixWp=" + prixWp + ", dateWp=" + dateWp + "]";
	}




	public Class getClasse() {
		return classe;
	}




	public void setClasse(Class classe) {
		this.classe = classe;
	}
	
	*/

}
