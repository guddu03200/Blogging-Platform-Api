package com.Guddu.BloggingPlatformApi.service;


import com.Guddu.BloggingPlatformApi.model.AuthenticationToken;
import com.Guddu.BloggingPlatformApi.model.User;
import com.Guddu.BloggingPlatformApi.repository.IAuthenticationRepo;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public void saveAuthToken(AuthenticationToken authToken) {
        authenticationRepo.save(authToken);
    }

    public boolean authenticate(String email, String token) {
        AuthenticationToken authenticationToken = authenticationRepo.findFirstByTokenValue(token);

        if(authenticationToken == null){
            return false;
        }

        String tokenConnectedEmail = authenticationToken.getUser().getUserEmail();
        return tokenConnectedEmail.equals(email);
    }

    public void removeToken(AuthenticationToken authenticationToken) {
        authenticationRepo.delete(authenticationToken);
    }

    public AuthenticationToken findFirstByUser(User user) {
        return authenticationRepo.findFirstByUser(user);
    }
}
