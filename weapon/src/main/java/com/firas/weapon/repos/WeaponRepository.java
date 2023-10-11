package com.firas.weapon.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.firas.weapon.entities.Weapon;
import com.firas.weapon.entities.Class;
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
	List<Weapon> findByNomWp(String nom);
	 List<Weapon> findByNomWpContains(String nom);
	 //List<Weapon> findByClassidClass(Long idClass);
	
	 @Query("select p from Weapon p where p.nomWp like %:nom and p.prixWp > :prix")
	 List<Weapon> findBynPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 @Query("select p from Weapon p where p.classe = ?1")
	 List<Weapon> findByClass (Class classe);
	 
	 List<Weapon> findByOrderByNomWpAsc();

	 @Query("select p from Weapon p order by p.nomWp ASC, p.prixWp DESC")
	 List<Weapon> trierWeaponsNomsPrix ();



}

