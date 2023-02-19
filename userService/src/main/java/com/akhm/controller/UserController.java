package com.akhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akhm.bo.UserBO;
import com.akhm.bo.vo.UserVO;
import com.akhm.util.EmailDetails;
import com.akhm.util.EmailUtil;

@Controller
@RequestMapping("/user/v1")
public class UserController {
	@Autowired
	private UserBO userBO;
	@Autowired
	private EmailUtil emailUtil;
	@GetMapping("/isuserexist")
	public ResponseEntity<Boolean> isUserExist(@RequestParam String emailId){
		try {
			Boolean isExist=userBO.isUserExist(emailId);
			return new ResponseEntity<Boolean>(isExist,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@PostMapping("/registration")
	public ResponseEntity<Integer> registration(@RequestBody UserVO userVO){
		try {
			Integer userId=userBO.insertUser(userVO);
			if(userId!=null && userId>0)
			{
				EmailDetails emailDetails=new EmailDetails();
				emailDetails.setRecipieant(userVO.getEmailId());
				emailDetails.setMessageBody("u r successfully registred");
				emailDetails.setSubject("Registration");
				emailUtil.sendSimpleMail(emailDetails);
			}
			return new ResponseEntity<Integer>(userId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}
	@PostMapping("/login")
	public ResponseEntity<UserVO> logIn(@RequestBody UserVO userVO){
		try {
			UserVO user=userBO.getUser(userVO.getEmailId(), userVO.getPassword());
			
			return new ResponseEntity<UserVO>(user,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<UserVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
