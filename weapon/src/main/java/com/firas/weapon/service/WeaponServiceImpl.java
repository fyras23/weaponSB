package com.firas.weapon.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firas.weapon.entities.Weapon;
import com.firas.weapon.repos.ImageRepository;
import com.firas.weapon.repos.WeaponRepository;
import com.firas.weapon.dto.WeaponDTO;
import com.firas.weapon.entities.Class;
@Service
public class WeaponServiceImpl implements WeaponService  {
	@Autowired
	WeaponRepository weaponRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	ModelMapper modelMapper;

	
	@Override
	public WeaponDTO saveWeapon(WeaponDTO p) {
		// TODO Auto-generated method stub
		return convertEntityToDto( weaponRepository.save(convertDtoToEntity(p)));

	}

	@Override
	public WeaponDTO updateWeapon(WeaponDTO p) {
		// TODO Auto-generated method stub
		//return convertEntityToDto( weaponRepository.save(convertDtoToEntity(p)));
		//Long oldWepImageId =
				//this.getWeapon(p.getIdWp()).getImage().getIdImage();
				// newWepImageId = p.getImage().getIdImage();
				WeaponDTO wepUpdated = convertEntityToDto( weaponRepository.save(convertDtoToEntity(p)));
				//if (oldWepImageId != newWepImageId) //si l'image a été modifiée
			//	imageRepository.deleteById(oldWepImageId);
				return wepUpdated;
		}
	

	@Override
	public void deleteWeapon(Weapon p) {
		weaponRepository.delete(p);
		
	}

	@Override
	public void deleteWeaponById(Long id) {
		weaponRepository.deleteById(id);		
	}

	@Override
	public WeaponDTO getWeapon(Long id) {
		return convertEntityToDto( weaponRepository.findById(id).get());

	}

	@Override
	public List<WeaponDTO> getAllWeapon() {
		return weaponRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());

	}
	
	
	
	
	@Override
	public List<Weapon> findByNomWp(String nom) {
	return weaponRepository.findByNomWp(nom);
	}
	@Override
	public List<Weapon> findByNomWpContains(String nom) {
	return weaponRepository.findByNomWpContains(nom);
	}
	@Override
	public List<Weapon> findBynPrix(String nom, Double prix) {
		return weaponRepository.findBynPrix(nom, prix);
	}
	@Override
	public List<Weapon> findByClass(Class categorie) {
	return weaponRepository.findByClass(categorie);
	}

	@Override
	public List<Weapon> findByOrderByNomWpAsc() {
		return weaponRepository.findByOrderByNomWpAsc();
		
	}

	@Override
	public List<Weapon> trierWeaponsNomsPrix() {
		
		return weaponRepository.trierWeaponsNomsPrix();
	}

	@Override
	public WeaponDTO convertEntityToDto(Weapon weapon) {
		/*return WeaponDTO.builder()
				.idWp(weapon.getIdWp())
				.nomWp(weapon.getNomWp())
				.prixWp(weapon.getPrixWp())
				.dateWp(weapon.getDateWp())
				.classe(weapon.getClasse())
				.build();*/
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		WeaponDTO weaponDTO = modelMapper.map(weapon, WeaponDTO.class);
		 return weaponDTO; 

		
	}

	@Override
	public Weapon convertDtoToEntity(WeaponDTO weaponDTO) {
		Weapon weapon = new Weapon();
		weapon = modelMapper.map(weaponDTO, Weapon.class);
		/*
		weapon.setIdWp(weaponDTO.getIdWp());
		weapon.setNomWp(weaponDTO.getNomWp());
		weapon.setPrixWp(weaponDTO.getPrixWp());
		weapon.setDateWp(weaponDTO.getDateWp());
		weapon.setClasse(weaponDTO.getClasse());*/
		 return weapon;
	}


}
