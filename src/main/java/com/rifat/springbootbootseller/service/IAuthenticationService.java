package com.rifat.springbootbootseller.service;

import com.rifat.springbootbootseller.model.User;

public interface IAuthenticationService {
    User signAndReturnJWT(User signInRequest);
}
