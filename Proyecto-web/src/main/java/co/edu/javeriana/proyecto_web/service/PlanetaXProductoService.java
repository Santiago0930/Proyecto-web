package co.edu.javeriana.proyecto_web.service;

import java.util.*;


import co.edu.javeriana.proyecto_web.model.PlanetaXProducto;
import co.edu.javeriana.proyecto_web.repository.PlanetaXProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PlanetaXProductoService {
    @Autowired
    private PlanetaXProductoRepository planetaXProductoRepository;

    @Transactional
    public List<PlanetaXProducto> listarPxP(Long idPlaneta) {
        return planetaXProductoRepository.obtenerPxP(idPlaneta);
    }

    @Transactional
    public List<Integer> listarPrecioVenta(Long idPlaneta) {
        List<PlanetaXProducto> PxP =  planetaXProductoRepository.obtenerPxP(idPlaneta);
        List<Integer> listPreciosVenta = new ArrayList<>();
        for (int i =0; i< PxP.size(); i++){
            int precioVenta = PxP.get(i).getFactorDemanda()/PxP.get(i).getStock()+1;
            listPreciosVenta.add(precioVenta);
        }
        return listPreciosVenta;
    }

    @Transactional
    public List<Integer> listarPrecioCompra(Long idPlaneta) {
        List<PlanetaXProducto> PxP =  planetaXProductoRepository.obtenerPxP(idPlaneta);
        List<Integer> listPreciosCompra = new ArrayList<>();
        for (int i =0; i< PxP.size(); i++){
            int precioCompra = PxP.get(i).getFactorOferta()/PxP.get(i).getStock()+1;
            listPreciosCompra.add(precioCompra);
        }
        return listPreciosCompra;
    }

    @Transactional
    public PlanetaXProducto obtenerpxp(Long idPlaneta, Long idProducto){
        return planetaXProductoRepository.obtenerpxp(idPlaneta, idProducto);
    }

    @Transactional
    public int modificarStock(Long idPlaneta, Long idProducto, int stockNuevo ){
        return planetaXProductoRepository.modificarStock(idPlaneta, idProducto, stockNuevo);
    }

}