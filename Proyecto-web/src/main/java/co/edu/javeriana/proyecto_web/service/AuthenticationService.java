package co.edu.javeriana.proyecto_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.javeriana.proyecto_web.dto.JwtAuthenticationResponse;
import co.edu.javeriana.proyecto_web.dto.LoginDTO;
/*import co.edu.javeriana.proyecto_web.dto.UserRegistrationDTO;
import co.edu.javeriana.proyecto_web.model.Role;*/
import co.edu.javeriana.proyecto_web.model.Tripulante;
import co.edu.javeriana.proyecto_web.repository.TripulanteRepository;

@Service
public class AuthenticationService {

    @Autowired
    private TripulanteRepository tripulanteRepository;
    /*@Autowired
    private PasswordEncoder passwordEncoder;*/
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    /*public JwtAuthenticationResponse signup(UserRegistrationDTO request) {
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Role.CAPITAN);

        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt, user.getEmail(), user.getRole());
    }*/

    public JwtAuthenticationResponse login(LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUser(), request.getPassword()));
        Tripulante tripulante = tripulanteRepository.findByUsuario(request.getUser()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        String jwt = jwtService.generateToken(tripulante);
        return new JwtAuthenticationResponse(jwt, tripulante.getUsuario(), tripulante.getRole());
    }

}
