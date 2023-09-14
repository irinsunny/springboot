package com.nissan.rest;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Customer;
import com.nissan.service.ICustomerInterface;
import com.nissan.util.JwtUtil;

@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private APIResponse apiresponse;
	@Autowired
	private ICustomerInterface custservice;
	@Autowired
	private JwtUtil jwtutil;

	@PutMapping("/customers/deposit/{AccountNo}&{DepositAmt}")
	public ResponseEntity<APIResponse> Deposit(@PathVariable int AccountNo, @PathVariable int DepositAmt,
			@RequestHeader(value = "authorization", defaultValue = "") String auth, @RequestBody Customer cust)
			throws AccessDeniedException {// get value passed bu postman
		jwtutil.verifyCustomer(auth);
		if (DepositAmt > 50000 && cust.getPan()==null) {
			apiresponse.setData("re-enter pan details");
			apiresponse.setStatus(500);
			apiresponse.setError("amount to large");

			return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);

		}
		custservice.Deposit(AccountNo, DepositAmt);
		apiresponse.setData("Amount Deposited");
		apiresponse.setStatus(200);
		return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);

	}

	@PutMapping("/customers/withdraw/{AccountNo}&{WithdrawAmt}")
	public  void Withdraw(@PathVariable int AccountNo, @PathVariable int WithdrawAmt,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException 
	{
		jwtutil.verifyCustomer(auth);
		
		
		custservice.Withdraw(AccountNo, WithdrawAmt);
		
	}
		

	
	@GetMapping("/customers/{AccountNo}")
	public int ShowBalance(@PathVariable int AccountNo,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {// get
																													// value
																													// passed
																													// bu
																													// postman
		jwtutil.verifyCustomer(auth);
		return custservice.ShowBalance(AccountNo);

	}

	@PutMapping("/customers/{AccountNo1}&{AccountNo2}&{Amount}")
	public void Transfer(@PathVariable int AccountNo1,@PathVariable int AccountNo2, @PathVariable int Amount,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {// get
																													// value
																													// passed
																													// bu
																													// postman
		jwtutil.verifyAdmin(auth);
		custservice.Transfer(AccountNo1,AccountNo2, Amount);
	}

}
