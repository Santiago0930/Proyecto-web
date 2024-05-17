package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Long> {
    Sistema findFirstByOrderByIdAsc();
}
