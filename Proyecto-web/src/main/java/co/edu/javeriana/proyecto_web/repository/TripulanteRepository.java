package co.edu.javeriana.proyecto_web.repository;

import java.util.List;
import java.util.Optional;

import co.edu.javeriana.proyecto_web.model.Tripulante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripulanteRepository extends JpaRepository<Tripulante, Long> {
    
     List<Tripulante> findAllByUsuario(String text);
     Optional<Tripulante> findByUsuario(String usuario);

}