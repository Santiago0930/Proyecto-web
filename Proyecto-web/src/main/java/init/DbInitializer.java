package co.edu.javeriana.proyecto_web.init;

import java.util.*;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import jakarta.transaction.Transactional;

import co.edu.javeriana.proyecto_web.model.Tripulante;
import co.edu.javeriana.proyecto_web.repository.TripulanteRepository;
import co.edu.javeriana.proyecto_web.model.Sistema;
import co.edu.javeriana.proyecto_web.repository.SistemaRepository;
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.repository.NaveComRepository;
import co.edu.javeriana.proyecto_web.model.Producto;
import co.edu.javeriana.proyecto_web.repository.ProductoRepository;
import co.edu.javeriana.proyecto_web.model.PlanetaXProducto;
import co.edu.javeriana.proyecto_web.repository.PlanetaXProductoRepository;
import co.edu.javeriana.proyecto_web.model.Planeta;
import co.edu.javeriana.proyecto_web.repository.PlanetaRepository;
import co.edu.javeriana.proyecto_web.model.Estrella;
import co.edu.javeriana.proyecto_web.repository.EstrellaRepository;
import co.edu.javeriana.proyecto_web.model.TipoNave;
import co.edu.javeriana.proyecto_web.repository.TipoNaveRepository;
import co.edu.javeriana.proyecto_web.model.BodegaNave;
import co.edu.javeriana.proyecto_web.repository.BodegaNaveRepository;
import co.edu.javeriana.proyecto_web.model.AgujeroGusano;
import co.edu.javeriana.proyecto_web.repository.AgujeroGusanoRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"default"})
public class DbInitializer implements CommandLineRunner {

    @Autowired
    private TripulanteRepository tripulanteRepository;

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private NaveComRepository naveComRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PlanetaXProductoRepository planetaXProductoRepository;

    @Autowired
    private TipoNaveRepository tipoNaveRepository;

    @Autowired
    private BodegaNaveRepository bodegaRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private AgujeroGusanoRepository agujeroGusanoRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        generarEstrellas(400);
        distribuirJugadoresEnEquipos(200, 20);
        generarNaves(20);
        generarEspecificacionesProductos(500);
        generarRelacionNaveXEstrella();
        generarAgujerosDeGusano();
        generarTiempoPartida();
    }

    private void generarEstrellas(int cantidad) {
        List<Estrella> estrellas = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            double x = rand.nextDouble() * 300; 
            double y = rand.nextDouble() * 300;
            double z = rand.nextDouble() * 300;
            String nombre = "Estrella " + i;
            boolean habitada = false;

            if (rand.nextDouble() < 0.4) {
                habitada = true;
            }
            Estrella estrella = new Estrella(x, y, z, nombre, habitada);
            if(habitada){
                int numPlanetas = rand.nextInt(3) + 1;
                for (int j = 0; j < numPlanetas; j++) {
                    Planeta planeta = new Planeta("Planeta " + j + " de " + nombre);
                    planeta.setEstrella(estrella);
                    estrella.agregarPlaneta(planeta);
                }
            }
            estrellas.add(estrella);
        }
        estrellaRepository.saveAll(estrellas);
    }
    

    private void distribuirJugadoresEnEquipos(int cantidadJugadores, int cantidadEquipos) {
        int id = 0;
        Random random = new Random();
    
        for (int i = 0; i < cantidadEquipos; i++) {
            double x = random.nextDouble() * 300;
            double y = random.nextDouble() * 300;
            double z = random.nextDouble() * 300;
            int dinero = random.nextInt(1000);
            NaveComerciante equipo = new NaveComerciante(x, y, z, dinero, 0);
            naveComRepository.save(equipo);
        }
    
        List<NaveComerciante> equipos = naveComRepository.findAll();
        
        String[] roles = {"Piloto", "Comerciante", "Capitan"}; 
    
        for (int i = 0; i < cantidadJugadores; i++) {
            String usuario = "Usuario" + i;
            String contrasenia = "Pass" + random.nextInt(9999);
            String rol = roles[i % 3]; 
    
            Tripulante tripulante = new Tripulante(usuario, contrasenia, rol);
            if (i != 0 && i % 10 == 0) {
                id = (id + 1) % equipos.size();
            }
            tripulante.setNaveT(equipos.get(id));
            tripulanteRepository.save(tripulante);
        }

        
    }
    
    private void generarNaves(int cantidadNaves){
        double minv = 300.0;
        double maxv = 1000.0;
        double minb = 500.0;
        double maxb = 1500.0;
        Random rand = new Random();

        for (int i = 0; i < cantidadNaves; i++) {
            double bodega = minb + (rand.nextDouble() * (maxb - minb));
            double velocidad = minv + (rand.nextDouble() * (maxv - minv));
            TipoNave tipoNave = new TipoNave("Nave " + i , bodega, velocidad);
            tipoNaveRepository.save(tipoNave);
        }

        List<TipoNave> naves = tipoNaveRepository.findAll();
        List<NaveComerciante> equipos = naveComRepository.findAll();

        //Collections.shuffle(naves); 
        for (int i = 0; i < equipos.size(); i++) {
            equipos.get(i).setTipoNave(naves.get(i)); 
        }
        naveComRepository.saveAll(equipos);
    }

    private void generarEspecificacionesProductos(int cantidadProductos){
        Random random = new Random();
        for (int i = 0; i < cantidadProductos; i++) {
            String nombre = "Producto " + i;
            Double volumen = 0.5 + (100.0 - 0.5) * random.nextDouble(); 
            Producto producto = new Producto(nombre, volumen);
            productoRepository.save(producto);
        }  

        List<Producto> productos = productoRepository.findAll();
        List<NaveComerciante> equipos = naveComRepository.findAll();
        List<Planeta> planetas = planetaRepository.findAll();

        for (int i = 0; i < planetas.size(); i++){
            for (int j = 0; j < productos.size(); j++){
            PlanetaXProducto PxP = new PlanetaXProducto(random.nextInt(1000000),random.nextInt(1000000),random.nextInt(1000000));
                PxP.setPlaneta(planetas.get(i));
                PxP.setProducto(productos.get(j));
                planetaXProductoRepository.save(PxP);
            }
        }

        for (int i = 0; i < equipos.size(); i++){
            for (int j = 0; j < productos.size(); j++){
                BodegaNave bodega = new BodegaNave(random.nextInt(1000000));
                bodega.setNaveB(equipos.get(i));
                bodega.setProductoB(productos.get(j));
                bodegaRepository.save(bodega);
            }
        }
    }

    private void generarRelacionNaveXEstrella(){
        List<NaveComerciante> equipos = naveComRepository.findAll();
        List<Estrella> estrellas = estrellaRepository.findAll();
        for(int i = 0; i<equipos.size(); i++){
            equipos.get(i).setEstrellas(estrellas);
        }
        for(int i = 0; i<estrellas.size(); i++){
            estrellas.get(i).setNaves(equipos);
        }
        naveComRepository.saveAll(equipos);
        estrellaRepository.saveAll(estrellas);
    }

    private void generarAgujerosDeGusano() {
        List<Estrella> estrellas = estrellaRepository.findAll();
        List<Estrella> habitadas = estrellas.stream().filter(Estrella::isEstado).collect(Collectors.toList());
        Random rand = new Random();
        Set<Pair<Long, Long>> conexionesExistentes = new HashSet<>();
        List<AgujeroGusano> agujerosDeGusano = new ArrayList<>();

        // Garantizar que todas las estrellas habitadas estén conectadas
        conectarEstrellasHabitadas(habitadas, agujerosDeGusano, rand, conexionesExistentes);

        // Opcional: agregar más agujeros de gusano aleatorios
        int cantidadAgujerosAdicionales = (int) (estrellas.size() * 0.3);  // Ejemplo: 30% de las estrellas
        for (int i = 0; i < cantidadAgujerosAdicionales; i++) {
            Estrella origen = estrellas.get(rand.nextInt(estrellas.size()));
            Estrella destino;
            do {
                destino = estrellas.get(rand.nextInt(estrellas.size()));
            } while (destino == origen || conexionesExistentes.contains(new ImmutablePair<>(origen.getId(), destino.getId())));

            double tiempoViaje = 1 + (10 - 1) * rand.nextDouble(); // Ejemplo de tiempo de viaje
            AgujeroGusano agujero = new AgujeroGusano();
            agujero.setEstrellaOrigen(origen);
            agujero.setEstrellaDestino(destino);
            agujero.setTiempoViaje(tiempoViaje);
            AgujeroGusano agujero1 = new AgujeroGusano();
            agujero1.setEstrellaOrigen(destino);
            agujero1.setEstrellaDestino(origen);
            agujero1.setTiempoViaje(tiempoViaje);
            agujerosDeGusano.add(agujero);
            agujerosDeGusano.add(agujero1);
            conexionesExistentes.add(new ImmutablePair<>(origen.getId(), destino.getId())); // Añadir a las conexiones existentes
            conexionesExistentes.add(new ImmutablePair<>(destino.getId(), origen.getId()));
        }

        agujeroGusanoRepository.saveAll(agujerosDeGusano);
    }

    private void conectarEstrellasHabitadas(List<Estrella> habitadas, List<AgujeroGusano> agujeros, Random rand, Set<Pair<Long, Long>> conexionesExistentes) {
        Collections.shuffle(habitadas); // Mezclar para randomizar las conexiones
        for (int i = 0; i < habitadas.size() - 1; i++) {
            Estrella origen = habitadas.get(i);
            Estrella destino = habitadas.get(i + 1);
            if (!conexionesExistentes.contains(new ImmutablePair<>(origen.getId(), destino.getId()))) {
                double tiempoViaje = 1 + (5 - 1) * rand.nextDouble(); // Tiempo de viaje más corto para estrellas habitadas
                AgujeroGusano agujero = new AgujeroGusano();
                agujero.setEstrellaOrigen(origen);
                agujero.setEstrellaDestino(destino);
                agujero.setTiempoViaje(tiempoViaje);
                AgujeroGusano agujero1 = new AgujeroGusano();
                agujero1.setEstrellaOrigen(destino);
                agujero1.setEstrellaDestino(origen);
                agujero1.setTiempoViaje(tiempoViaje);
                agujeros.add(agujero);
                agujeros.add(agujero1);
                conexionesExistentes.add(new ImmutablePair<>(origen.getId(), destino.getId())); // Añadir a las conexiones existentes
                conexionesExistentes.add(new ImmutablePair<>(destino.getId(), origen.getId()));
            }
        }
        // Conectar el último con el primero para cerrar el ciclo
        Estrella ultimo = habitadas.get(habitadas.size() - 1);
        Estrella primero = habitadas.get(0);
        if (!conexionesExistentes.contains(new ImmutablePair<>(ultimo.getId(), primero.getId()))) {
            double tiempoViaje = 1 + (5 - 1) * rand.nextDouble();
            AgujeroGusano agujeroFinal = new AgujeroGusano();
            agujeroFinal.setEstrellaOrigen(ultimo);
            agujeroFinal.setEstrellaDestino(primero);
            agujeroFinal.setTiempoViaje(tiempoViaje);
            AgujeroGusano agujeroFinal1 = new AgujeroGusano();
            agujeroFinal1.setEstrellaOrigen(primero);
            agujeroFinal1.setEstrellaDestino(ultimo);
            agujeroFinal1.setTiempoViaje(tiempoViaje);
            agujeros.add(agujeroFinal1);
            conexionesExistentes.add(new ImmutablePair<>(ultimo.getId(), primero.getId()));
            conexionesExistentes.add(new ImmutablePair<>(primero.getId(), ultimo.getId()));
        }
    }

    private void generarTiempoPartida() {
        Random rand = new Random();
        Long tiempo = rand.nextLong(1000);
        Sistema sistema = new Sistema(tiempo);
        sistemaRepository.save(sistema);
    }
}