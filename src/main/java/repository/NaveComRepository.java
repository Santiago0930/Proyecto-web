package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface NaveComRepository extends JpaRepository<NaveComerciante, Long> {

    List<NaveComerciante> findAllByNombre(String text);

}