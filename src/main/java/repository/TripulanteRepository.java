package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Tripulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface TripulanteRepository extends JpaRepository<Tripulante, Long> {
    
    List<Tripulante> findAllByUsuario(String text);

}