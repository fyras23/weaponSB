package com.firas.weapon.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.firas.weapon.dto.WeaponDTO;
import com.firas.weapon.entities.Image;
import com.firas.weapon.entities.Weapon;
import com.firas.weapon.service.ImageService;
import com.firas.weapon.service.WeaponService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	 ImageService imageService ;
	
	@Autowired
	 WeaponService weaponService ;
	
	@RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
	{
	 return imageService.getImage(id);
	 }


	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 
	 @PostMapping(value = "/uplaodImageWep/{idWep}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idWep") Long idProd)
	throws IOException {
	 return imageService.uplaodImagewep(file,idProd);
	 }
	@RequestMapping(value = "/getImagesWeap/{idWep}" ,
	 method = RequestMethod.GET)
	 public List<Image> getImagesProd(@PathVariable("idWep") Long idProd)
	throws IOException {
	 return imageService.getImagesParWep(idProd);
	 }
	
	@RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile
	file,@PathVariable("id") Long id) throws IOException {
		WeaponDTO p = weaponService.getWeapon(id);
	 p.setImagePath(id+".jpg");

	Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
	, file.getBytes());
	weaponService.saveWeapon(p);

	 }
	
	@RequestMapping(value = "/loadfromFS/{id}" ,
			 method = RequestMethod.GET,
			 produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
			 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		WeaponDTO p = weaponService.getWeapon(id);
			 return
			Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
			 }




}
