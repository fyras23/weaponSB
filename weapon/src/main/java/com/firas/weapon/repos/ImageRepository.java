package com.firas.weapon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firas.weapon.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	

}
