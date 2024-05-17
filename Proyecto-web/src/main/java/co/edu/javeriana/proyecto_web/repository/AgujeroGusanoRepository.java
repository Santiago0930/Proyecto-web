package co.edu.javeriana.proyecto_web.repository;

import co.edu.javeriana.proyecto_web.model.AgujeroGusano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgujeroGusanoRepository extends JpaRepository<AgujeroGusano, Long> {
    
}