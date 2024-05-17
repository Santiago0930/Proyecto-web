package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.javeriana.proyecto_web.model.TipoNave;

@Repository
public interface TipoNaveRepository extends JpaRepository<TipoNave, Long> {

    List<TipoNave> findAllByNombre(String text);

}