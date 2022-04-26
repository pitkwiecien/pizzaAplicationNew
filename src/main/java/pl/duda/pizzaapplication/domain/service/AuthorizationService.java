package pl.duda.pizzaapplication.domain.service;

import pl.duda.pizzaapplication.domain.exception.UnauthorizedException;

public class AuthorizationService {
    public static void checkToken(String token){
        if(token == null || !token.equals("xzv")){
            throw new UnauthorizedException("Incorrect token");
        }
    }
}
