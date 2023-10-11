package com.firas.weapon.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.firas.weapon.entities.Image;
import com.firas.weapon.entities.Weapon;
import com.firas.weapon.repos.ImageRepository;
import com.firas.weapon.repos.WeaponRepository;

@Service
public class ImageServiceImpl   implements ImageService{
	@Autowired
	 ImageRepository imageRepository;
	
	@Autowired
	 WeaponService weaponService;
	
	@Autowired
	WeaponRepository weaponRepository;

	@Override
	 public Image uplaodImage(MultipartFile file) throws IOException {
	 /*Ce code commenté est équivalent au code utilisant le design pattern Builder
	 * Image image = new Image(null, file.getOriginalFilename(),
	 file.getContentType(), file.getBytes(), null);
	 return imageRepository.save(image);*/
	 return imageRepository.save(Image.builder()
	 .name(file.getOriginalFilename())
	 .type(file.getContentType())
	 .image(file.getBytes()).build() );
	 }
	 @Override
	 public Image getImageDetails(Long id) throws IOException{
	 final Optional<Image> dbImage = imageRepository. findById (id);
	 return Image.builder()
	 .idImage(dbImage.get().getIdImage())
	 .name(dbImage.get().getName())
	 .type(dbImage.get().getType())
	 .image(dbImage.get().getImage()).build() ;
	 }
	 @Override
	 public ResponseEntity<byte[]> getImage(Long id) throws IOException{
	 final Optional<Image> dbImage = imageRepository. findById (id);
	 return ResponseEntity
	 .ok()
	 .contentType(MediaType.valueOf(dbImage.get().getType()))
	 .body(dbImage.get().getImage());
	 }
	 @Override
	 public void deleteImage(Long id) {
	 imageRepository.deleteById(id);
	 }
	@Override
	public Image uplaodImagewep(MultipartFile file, Long idWp) throws IOException {
		Weapon p = new Weapon();
		p.setIdWp(idWp);
		return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes())
		 .weapon(p).build() );
	}
	@Override
	public List<Image> getImagesParWep(Long WpId) {
		Weapon p = weaponRepository.findById(WpId).get();
		return p.getImages();
	}
	}
	

