package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    List<Producto> findAllByNombre(String text);

    @Query("SELECT p FROM Producto p WHERE p.id = :productoId")
    Producto obtenerProducto(@Param("productoId") Long productoId);

}