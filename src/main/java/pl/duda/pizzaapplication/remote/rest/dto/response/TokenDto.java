package pl.duda.pizzaapplication.remote.rest.dto.response;

public class TokenDto {
    private String token;

    public TokenDto(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
