package com.firas.weapon.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firas.weapon.dto.WeaponDTO;
import com.firas.weapon.entities.Weapon;
import com.firas.weapon.service.WeaponService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class WeaponRESTController {
	@Autowired
	WeaponService weaponService;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<WeaponDTO> getAllWeapon() {
	return weaponService.getAllWeapon();
	}
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public WeaponDTO getWeaponById(@PathVariable("id") Long id) {
	return weaponService.getWeapon(id);
	}
	@RequestMapping(path="/addwep",method = RequestMethod.POST)
	public WeaponDTO createWeapon(@RequestBody WeaponDTO weaponDTO) {
	return weaponService.saveWeapon(weaponDTO);
	}
	
	@RequestMapping(path="/updatewep",method = RequestMethod.PUT)
	public WeaponDTO updateWeapon(@RequestBody WeaponDTO weaponDTO) {
	return weaponService.updateWeapon(weaponDTO);
	}
	
	@RequestMapping(value="/delwep/{id}",method = RequestMethod.DELETE)
	public void deleteWeapon(@PathVariable("id") Long id)
	{
		weaponService.deleteWeaponById(id);
	}
	
	/*@RequestMapping(value="/wepclass/{idCat}",method = RequestMethod.GET)
	public List<Weapon> getWeaponByClassId(@PathVariable("idClass") Long idClass) {
	return weaponService.findByClassIdCat(idClass);
	}*/
	
	@RequestMapping(value="/wpByName/{nom}",method = RequestMethod.GET)
	public List<Weapon> findByNomWpContains(@PathVariable("nom") String nom) {
	     return weaponService.findByNomWpContains(nom);
	}



}
