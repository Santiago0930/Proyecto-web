package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.BodegaNave;
import co.edu.javeriana.proyecto_web.repository.BodegaNaveRepository;
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodegaNaveService {
    @Autowired
    private BodegaNaveRepository bodegaRepository;

    public List<BodegaNave> listarBodegas(Long id) {
        return bodegaRepository.obtenerStocks(id);
    }

    public BodegaNave obtenerStock(Long idNave, Long idProducto){
        return bodegaRepository.obtenerStock(idNave, idProducto);
    }

    public int modificarStock(Long idNave, Long idProducto, int stockNuevo ){
        return bodegaRepository.modificarStock(idNave, idProducto, stockNuevo);
    }

    /*public BodegaNave recuperarStock(Long id) {
        return bodegaRepository.findById(id).orElseThrow();
    }

    public void guardarStock(BodegaNave bodega) {
        bodegaRepository.save(bodega);
    }

    public void eliminarStock(Long id) {
        bodegaRepository.deleteById(id);
    }

    /*public int recuperarStock(NaveComerciante nave, Producto producto){
        return bodegaRepository.obtenerStock(nave.getId(), producto.getId());
    }*/

    /*public List<BodegaNave> listarStocksPorIdsProductos(List<Long> idsProductos) {
        return bodegaRepository.findByProductoBIdIn(idsProductos);
    }*/

}