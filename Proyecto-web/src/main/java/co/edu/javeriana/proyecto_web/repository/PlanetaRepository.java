package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {
    
    List<Planeta> findAllByNombre(String text);

    @Query("SELECT n FROM Planeta n WHERE n.estrella.id = :estrellaId")
    List<Planeta> obtenerPlanetas(@Param("estrellaId") Long estrellaId);

    @Query("SELECT n FROM Planeta n WHERE n.id = :planetaId")
    Planeta obtenerPlaneta(@Param("planetaId") Long planetaId);

}