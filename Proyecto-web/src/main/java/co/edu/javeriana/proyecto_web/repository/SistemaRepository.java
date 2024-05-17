package co.edu.javeriana.proyecto_web.repository;

import co.edu.javeriana.proyecto_web.model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Long> {
    Sistema findFirstByOrderByIdAsc();
}
