package com.firas.weapon;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.firas.weapon.entities.Weapon;
import com.firas.weapon.repos.WeaponRepository;
import com.firas.weapon.entities.Class;


@SpringBootTest
class WeaponApplicationTests {
	/*@Autowired
	private WeaponRepository weaponRepository;
	@Test
	public void testCreateWeapon() {
	Weapon wep = new Weapon("AK47",7400.500,new Date());
	weaponRepository.save(wep);
	}
	@Test
	public void testFindWeapon()
	{
		Weapon p = weaponRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdateWeapon()
	{
		Weapon p = weaponRepository.findById(1L).get();
	p.setPrixWp(93000.0);
	weaponRepository.save(p);
	}
	@Test
	public void testDeleteWeapon()
	{
		weaponRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousWeapon()
	{
		List<Weapon> prods = weaponRepository.findAll();
	for (Weapon p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindWeaponByNom()
	{
		List<Weapon> wp = weaponRepository.findByNomWp("FN SCAR");
		for (Weapon p : wp)
		{
		System.out.println(p);
		}
	}
	@Test
	public void findByNomWpContains()
	{
		List<Weapon> wp = weaponRepository.findByNomWpContains("k");
		for (Weapon p : wp)
		{
		System.out.println(p);
		}
	}
	@Test
	public void testfindBynPrix()
	{
	List<Weapon> wp = weaponRepository.findBynPrix("FN SCAR", 1000.0);
	for (Weapon p : wp )
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByClass()
	{
	Class cl = new Class();
	cl.setIdClass(1L);
	List<Weapon> wp = weaponRepository.findByClass(cl);
	for (Weapon p : wp)
	{
	System.out.println(p);
	}
	}
	/*@Test
	public void findByClassidClass() {
		List<Weapon> wp = weaponRepository.findByClassidClass(1L);
		for (Weapon p : wp)
		{
		System.out.println(p);
		}
	}*/
	/*@Test
	public void testfindByOrderByNomWpAsc()
	{
	List<Weapon> wp =
			weaponRepository.findByOrderByNomWpAsc();
	for (Weapon p : wp)
	{
	System.out.println(p);
	}
	}*/



	}
	


