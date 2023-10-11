package com.firas.weapon.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firas.weapon.repos.ClassRepository;
import com.firas.weapon.entities.Class;
import com.firas.weapon.entities.Weapon;

@RestController
@RequestMapping("/api/class")
@CrossOrigin("*")

public class ClassRESTController {
	@Autowired
	ClassRepository classRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Class> getAllClasses()
	{
	return classRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Class getClassById(@PathVariable("id") Long id) {
	return classRepository.findById(id).get();
	}
	@RequestMapping(method = RequestMethod.POST)
	public Class createWeapon(@RequestBody Class classe) {
	return classRepository.save(classe);
	}
	
	
}
