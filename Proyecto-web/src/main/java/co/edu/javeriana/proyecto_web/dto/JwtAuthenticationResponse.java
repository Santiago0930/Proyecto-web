package co.edu.javeriana.proyecto_web.dto;

import co.edu.javeriana.proyecto_web.model.Role;

public class JwtAuthenticationResponse {
    private String token;
    private String user;
    private Role role;

    public JwtAuthenticationResponse() {
    }

    public JwtAuthenticationResponse(String token, String user, Role role) {
        this.token = token;
        this.user = user;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
