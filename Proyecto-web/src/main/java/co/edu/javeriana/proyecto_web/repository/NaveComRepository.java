package co.edu.javeriana.proyecto_web.repository;

import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NaveComRepository extends JpaRepository<NaveComerciante, Long> {


    @Query("SELECT n FROM NaveComerciante n WHERE n.tipoNave.id = :naveId")
    NaveComerciante obtenerNave(@Param("naveId") Long naveId);

    @Query("SELECT n.dinero FROM NaveComerciante n WHERE n.tipoNave.id = :naveId")
    int obtenerDinero(@Param("naveId") Long naveId);

    @Transactional
    @Modifying
    @Query("UPDATE NaveComerciante p SET p.dinero = :dinero WHERE p.id = :naveId")
    int modificarDinero(@Param("naveId") Long naveId,  @Param ("dinero") int dinero);

    @Transactional
    @Modifying
    @Query("UPDATE NaveComerciante p SET p.tiempo = :tiempo WHERE p.id = :naveId")
    int actualizarTiempo(@Param("naveId") Long naveId,  @Param ("tiempo") int tiempo);

    @Transactional
    @Modifying
    @Query("UPDATE NaveComerciante p SET p.x = :x WHERE p.id = :naveId")
    int actualizarX(@Param("naveId") Long naveId,  @Param ("x") double x);

    @Transactional
    @Modifying
    @Query("UPDATE NaveComerciante p SET p.y = :y WHERE p.id = :naveId")
    int actualizarY(@Param("naveId") Long naveId,  @Param ("y") double y);

    @Transactional
    @Modifying
    @Query("UPDATE NaveComerciante p SET p.z = :z WHERE p.id = :naveId")
    int actualizarZ(@Param("naveId") Long naveId,  @Param ("z") double z);

}