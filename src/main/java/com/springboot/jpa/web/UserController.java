package com.springboot.jpa.web;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.dao.UserRepository;
import com.springboot.jpa.dao.UserService;
import com.springboot.jpa.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
        this.userService = userService;
    }


	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveUserData(@RequestBody User userData) {
        System.out.println("Received form data: " + userData);
        userRepository.save(userData);
    }
	
	 @GetMapping
	 public List<User> getAllUsers() {
		 	List<User> retrievedData = userService.getAllUsers();
		 	
		 	System.out.println(retrievedData);
	        return retrievedData;
	 }
	 
	 @PutMapping("/{id}")
	    public void updateData(@PathVariable String id, @RequestBody User updatedData) {
	      User userToUpdate = userRepository.findById(String.valueOf(id)).get();
	        userToUpdate.setFirstName(updatedData.getFirstName());
	        userToUpdate.setLastName(updatedData.getLastName());
	        userToUpdate.setGender(updatedData.getGender());
	        userToUpdate.setAddressLine1(updatedData.getAddressLine1());
	        userToUpdate.setAddressLine2(updatedData.getAddressLine2());
	        userToUpdate.setState(updatedData.getState());
	        userToUpdate.setCity(updatedData.getCity());
	        userToUpdate.setZipCode(updatedData.getZipCode());
	        userRepository.save(userToUpdate);
	        
	   }
	 
	 @DeleteMapping("/{id}")
	 public void deleteData(@PathVariable String id) {
		 userRepository.deleteById(String.valueOf(id));
		 
	 }
}
