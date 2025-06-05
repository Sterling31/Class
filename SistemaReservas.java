import java.util.*;
class Vuelo {
    private int asientosDisponibles;
    private String ruta;
    private double precioBase;
    
    public Vuelo(int asientosDisponibles, String ruta, double precioBase) {
        this.asientosDisponibles = asientosDisponibles;
        this.ruta = ruta;
        this.precioBase = precioBase;
    }
    
    public boolean reservarAsiento() {
        if (asientosDisponibles > 0) {
            asientosDisponibles--;
            return true;
        }
        return false;
    }

    public double calcularMultaCancelacion() {
        return precioBase * 0.20; // Multa del 20% del precio del pasaje
    }
    
    public String getRuta() {
        return ruta;
    }
}

class Pasajero {
    private String nombre;
    private String documento;
    private int cantidadEquipaje;
    private double pesoEquipaje;
    
    public Pasajero(String nombre, String documento, int cantidadEquipaje, double pesoEquipaje) {
        this.nombre = nombre;
        this.documento = documento;
        this.cantidadEquipaje = cantidadEquipaje;
        this.pesoEquipaje = pesoEquipaje;
    }
    
    public boolean validarEquipaje() {
        return cantidadEquipaje <= 2 && pesoEquipaje <= 23; // Restricción de equipaje
    }
    
    public String getNombre() {
        return nombre;
    }
}

public class SistemaReservas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Vuelo vuelo = new Vuelo(50, "Quito - Guayaquil", 100.0);
        
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese su documento:");
        String documento = scanner.nextLine();
        
        System.out.println("Ingrese la cantidad de equipaje:");
        int cantidadEquipaje = scanner.nextInt();
        
        System.out.println("Ingrese el peso total del equipaje en kg:");
        double pesoEquipaje = scanner.nextDouble();
        
        Pasajero pasajero = new Pasajero(nombre, documento, cantidadEquipaje, pesoEquipaje);
        
        if (!pasajero.validarEquipaje()) {
            System.out.println("Equipaje excede el límite permitido.");
        } else if (!vuelo.reservarAsiento()) {
            System.out.println("No hay asientos disponibles.");
        } else {
            System.out.println("Reserva exitosa para " + pasajero.getNombre() + " en la ruta " + vuelo.getRuta());
        }
        
        System.out.println("Si desea cancelar fuera del tiempo permitido, se aplicará una multa de $" + vuelo.calcularMultaCancelacion());
        
        scanner.close();
    }
}
