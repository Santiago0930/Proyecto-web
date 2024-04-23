package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.PlanetaXProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlanetaXProductoRepository extends JpaRepository<PlanetaXProducto, Long> {
    
    List<PlanetaXProducto> findByProductoIdIn(List<Long> productoIds);

    @Query("SELECT p FROM PlanetaXProducto p WHERE p.planeta.id = :planetaId")
    List<PlanetaXProducto> obtenerPxP(@Param("planetaId") Long planetaId);

    @Query("SELECT p FROM PlanetaXProducto p WHERE p.planeta.id = :planetaId AND p.producto.id = :productoId")
    PlanetaXProducto obtenerpxp(@Param("planetaId") Long planetaId, @Param("productoId") Long productoId);

    @Transactional
    @Modifying
    @Query("UPDATE PlanetaXProducto p SET p.stock = :stock WHERE p.planeta.id = :planetaId AND p.producto.id = :productoId")
    int modificarStock(@Param("planetaId") Long planetaId, @Param("productoId") Long productoId, @Param ("stock") int stock);

}