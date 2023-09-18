package com.nissan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.service.IUserService;

@RestController
@RequestMapping("/api")

public class UserController {
	@Autowired
	private IUserService userservice;
	
	@GetMapping("/users/{userName}&{password}&{roleId}")
	public ResponseEntity<APIResponse> findUserByNameAndPassword(@PathVariable String userName,@PathVariable String password,@PathVariable int roleId)
	{
		APIResponse api= userservice.findUserByNameAndPassword(userName, password,roleId);
	
		return ResponseEntity.status(api.getStatus()).body(api);
	}
}
