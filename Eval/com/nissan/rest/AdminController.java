package com.nissan.rest;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Customer;
import com.nissan.service.IAdminService;
import com.nissan.util.JwtUtil;

@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private APIResponse apiresponse;
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private IAdminService adminService;

	// display customer details
	@GetMapping("/admin")
	public List<Customer> getCustomer(@RequestHeader(value = "authorization", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtutil.verifyAdmin(auth);

		return adminService.Display();
	}

	// add customer details
	@PostMapping("/admin")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Customer customer,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtutil.verifyAdmin(auth);
		if (adminService.saveCustomer(customer) == null) {
			apiresponse.setData("name can have only alphabet!");
			apiresponse.setStatus(500);
			apiresponse.setError("invalid name");

			return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);

		}
		apiresponse.setData("employee added successfuly");
		apiresponse.setStatus(200);
		return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
	}

	// updateEmployee
	@PutMapping("/admin/update/{AccountNo}")
	public void updateCustomer(@RequestBody Customer customer,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtutil.verifyAdmin(auth);
		adminService.saveCustomer(customer);

	}

	// delete an employee
	@PutMapping("/admin/delete/{AccountNo}")
	public void deleteCustomer(@PathVariable int acno,@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtutil.verifyAdmin(auth);
		adminService.deleteCustomer(acno);
	}

	// display employee by account no
	@GetMapping("/admin/{AccountNo}")
	public Customer getCustomer(@PathVariable int AccountNo,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtutil.verifyAdmin(auth);
		return adminService.DisplaybyAccountNo(AccountNo);
	}

}
