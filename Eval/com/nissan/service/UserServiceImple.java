package com.nissan.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.model.User;
import com.nissan.repository.IUserRepository;
import com.nissan.util.JwtUtil;

@Service
public class UserServiceImple implements IUserService {
	@Autowired
	private IUserRepository userrepo;
	@Autowired
	private APIResponse apiresponse;
	@Autowired
	private JwtUtil jwtutil;

	@Override
	public APIResponse findUserByNameAndPassword(String userName, String password, int roleId) {
		// verify user exist or not
		User user = userrepo.findUserByUserNameAndPasword(userName, password, roleId);
		if (user == null) {
			apiresponse.setData("INVALID CREDENTIALS!");
			return apiresponse;
		}
		// credentials are correct, create a token
		if (roleId == 1) {
			String token = jwtutil.generateJwtAdmin(user);
			// storing more details and token
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("ACCESSTOKEN", token);
			data.put("role", user.getRoleId());
			data.put("UserName", user.getUserName());
			apiresponse.setStatus(200);
			apiresponse.setData(data);

			return apiresponse;

		} else if (roleId == 2) {
			String token = jwtutil.generateJwtCustomer(user);
			// storing more details and token
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("ACCESSTOKEN", token);
			data.put("role", user.getRoleId());
			data.put("UserName", user.getUserName());
			apiresponse.setStatus(200);
			apiresponse.setData(data);
			return apiresponse;
		} else {

			apiresponse.setData("INVALID CREDENTIALS!");
			return apiresponse;
		}

	}
}