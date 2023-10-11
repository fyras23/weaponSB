package com.firas.weapon.service;

import java.util.List;

import com.firas.weapon.entities.Weapon;
import com.firas.weapon.dto.WeaponDTO;
import com.firas.weapon.entities.Class;
public interface WeaponService {
	WeaponDTO saveWeapon(WeaponDTO p);
	WeaponDTO updateWeapon(WeaponDTO p);
	void deleteWeapon(Weapon p);
	 void deleteWeaponById(Long id);
	 WeaponDTO getWeapon(Long id);
	List<WeaponDTO> getAllWeapon();
	List<Weapon> findByNomWp(String nom);
	List<Weapon> findByNomWpContains(String nom);
	List<Weapon> findBynPrix (String nom, Double prix);
	List<Weapon> findByClass(Class classe);
	List<Weapon> findByOrderByNomWpAsc();
	List<Weapon> trierWeaponsNomsPrix();
	
	
	WeaponDTO convertEntityToDto (Weapon weapon);
	Weapon convertDtoToEntity(WeaponDTO weaponDTO);
}
