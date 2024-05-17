package co.edu.javeriana.proyecto_web.repository;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.BodegaNave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BodegaNaveRepository extends JpaRepository<BodegaNave, Long> {

    List<BodegaNave> findByProductoBIdIn(List<Long> productoIds);

    @Query("SELECT bn FROM BodegaNave bn WHERE bn.naveB.id = :naveId AND bn.productoB.id = :productoId")
    BodegaNave obtenerStock(@Param("naveId") Long naveId, @Param("productoId") Long productoId);
    
    @Query("SELECT b FROM BodegaNave b WHERE b.naveB.id = :naveId")
    List<BodegaNave> obtenerStocks(@Param("naveId") Long naveId);

    @Transactional
    @Modifying
    @Query("UPDATE BodegaNave b SET b.stock = :stock WHERE b.naveB.id = :naveId AND b.productoB.id = :productoId")
    int modificarStock(@Param("naveId") Long naveId, @Param("productoId") Long productoId, @Param ("stock") int stock);
    
}