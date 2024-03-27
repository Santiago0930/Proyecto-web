package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.javeriana.proyecto_web.model.Estrella;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EstrellaRepository extends JpaRepository<Estrella, Long> {
    
    List<Estrella> findAllByNombre(String text);

}