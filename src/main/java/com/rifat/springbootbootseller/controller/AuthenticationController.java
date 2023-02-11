package com.rifat.springbootbootseller.controller;


import com.rifat.springbootbootseller.model.User;
import com.rifat.springbootbootseller.service.IAuthenticationService;
import com.rifat.springbootbootseller.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private final IAuthenticationService authenticationService;
    private final IUserService userService;


    public AuthenticationController(IAuthenticationService authenticationService, IUserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }


    @PostMapping("sign-up")
    public ResponseEntity<User> signUp(@RequestBody User user){
return  new ResponseEntity<>(user,HttpStatus.OK) ;
    }


}
