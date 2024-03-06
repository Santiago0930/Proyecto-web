package co.edu.javeriana.proyecto_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.proyecto_web.model.Comercio;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Long> {
    
}