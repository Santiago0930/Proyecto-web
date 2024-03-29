package co.edu.javeriana.proyecto_web.init;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.edu.javeriana.proyecto_web.model.Tripulante;
import co.edu.javeriana.proyecto_web.repository.TripulanteRepository;
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.repository.NaveComRepository;
import co.edu.javeriana.proyecto_web.model.Producto;
import co.edu.javeriana.proyecto_web.repository.ProductoRepository;
import co.edu.javeriana.proyecto_web.model.Comercio;
import co.edu.javeriana.proyecto_web.repository.ComercioRepository;
import co.edu.javeriana.proyecto_web.model.Planeta;
import co.edu.javeriana.proyecto_web.repository.PlanetaRepository;
import co.edu.javeriana.proyecto_web.model.Estrella;
import co.edu.javeriana.proyecto_web.repository.EstrellaRepository;

@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    private TripulanteRepository tripulanteRepository;

    @Autowired
    private NaveComRepository naveComRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Override
    public void run(String... args) throws Exception {
        
        generarEstrellas(40000);
        distribuirJugadoresEnEquipos(100, 10);
        generarNaves(20);
        generarEspecificacionesProductos(500);
        
    }

    private void generarEstrellas(int cantidad) {
        List<Estrella> estrellas = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            double x = rand.nextDouble() * 1000;
            double y = rand.nextDouble() * 1000;
            double z = rand.nextDouble() * 1000;
            String nombre = "Estrella " + i;
            boolean estado = rand.nextBoolean();
            Estrella estrella = new Estrella(x, y, z, nombre, estado);

            // Generar entre 1 y 3 planetas aleatorios y asociarlos con la estrella
            int numPlanetas = rand.nextInt(3) + 1;
            for (int j = 0; j < numPlanetas; j++) {
                Planeta planeta = new Planeta("Planeta " + j);
                planeta.setEstrella(estrella);
                estrella.agregarPlaneta(planeta);
            }

            estrellas.add(estrella);
        }
        estrellaRepository.saveAll(estrellas);
    }

    private void distribuirJugadoresEnEquipos(int cantidadJugadores, int cantidadEquipos) {
        List<List<Tripulante>> equipos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidadEquipos; i++) {
            equipos.add(new ArrayList<>());
        }

        for (int i = 0; i < cantidadJugadores; i++) {
            String usuario = "Usuario" + i;
            String contrasenia = "Pass" + random.nextInt(9999);
            String rol = "Rol" + (i % 5 + 1); 

            Tripulante tripulante = new Tripulante(usuario, contrasenia, rol);

            tripulanteRepository.save(tripulante);
            equipos.get(i % 10).add(tripulante);
        }



    }

    private void generarNaves(int cantidadNaves){
        List<NaveComerciante> naves = new ArrayList<>();
        for (int i = 0; i < cantidadNaves; i++) {
            NaveComerciante nave = new NaveComerciante(1000.0 * i, "Nave " + i, 100.0, 20.0, 1.0);
            naves.add(nave);
        }
        naveComRepository.saveAll(naves);
    }

    private void generarEspecificacionesProductos(int cantidadProductos){
        List<Producto> productos = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < cantidadProductos; i++) {
            String nombre = "Producto" + i;
            Double precioUnitarioCompra = 50.0 + (1000.0 - 50.0) * random.nextDouble();
            Double precioUnitarioVenta = precioUnitarioCompra * (1.05 + (1.2 - 1.05) * random.nextDouble()); 
            int stock = random.nextInt(100) + 1; 
            Double volumen = 0.5 + (100.0 - 0.5) * random.nextDouble(); 

            Producto producto = new Producto(nombre, precioUnitarioCompra, precioUnitarioVenta, stock, volumen);
            productos.add(producto);
        }
         productoRepository.saveAll(productos);
    }
}












/*Tripulante t1 = new Tripulante("Alice", "ali123", "Jefe");
        Tripulante t2 = new Tripulante("Camila", "ali123", "Jefe");
        tripulanteRepository.save(t1);
        tripulanteRepository.save(t2);
    
        NaveComerciante n1 = new NaveComerciante(3.456, "Santi", 456.8, 356.8, 4656.7);
        NaveComerciante n2 = new NaveComerciante(3.456, "Brayan", 456.8, 356.8, 4656.7);
        naveComRepository.save(n1);
        naveComRepository.save(n2);

        t1.setNave(n1);
        n1.agregarTripulante(t1);

        tripulanteRepository.save(t1);
        naveComRepository.save(n1);

        t2.setNave(n2);
        n2.agregarTripulante(t2);

        tripulanteRepository.save(t2);
        naveComRepository.save(n2);

        Producto p1 = new Producto("Verdura", 2.345, 456.8, 356, 4656.7);
        productoRepository.save(p1);

        p1.setNaveP(n1);
        n1.agregarProducto(p1);

        productoRepository.save(p1);
        naveComRepository.save(n1);

        Estrella e1 = new Estrella(2.3, 4.5, 6.6, "estrella1", true);
        estrellaRepository.save(e1);

        e1.setNaveE(n2);
        n2.agregarEstrella(e1);

        estrellaRepository.save(e1);
        naveComRepository.save(n2);

        Planeta pl1 = new Planeta("Marte");
        planetaRepository.save(pl1);

        pl1.setEstrella(e1);
        e1.agregarPlaneta(pl1);

        planetaRepository.save(pl1);
        estrellaRepository.save(e1);
        */