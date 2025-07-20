import java.util.Scanner;

public class AnalisisComida {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del alimento: ");
        String alimento = scanner.nextLine();

        System.out.print("Ingrese los gramos consumidos: ");
        double gramos = scanner.nextDouble();

        System.out.println("Seleccione el grupo alimenticio:");
        System.out.println("1. Calorías");
        System.out.println("2. Proteína");
        System.out.println("3. Grasa");
        System.out.println("4. Carbohidratos");
        int grupo = scanner.nextInt();

        double valorNutricional = calcularValorNutricional(grupo, gramos);

        System.out.println("El valor nutricional es: " + valorNutricional);

        if (valorNutricional <= 200) {
            System.out.println("La comida es aceptable.");
        } else {
            System.out.println("La comida no es aceptable.");
        }

        scanner.close();
    }

    public static double calcularValorNutricional(int grupo, double gramos) {
        double factor = switch (grupo) {
            case 1 -> 9.0; // Calorías
            case 2 -> 4.0; // Proteína
            case 3 -> 9.0; // Grasa
            case 4 -> 4.0; // Carbohidratos
            default -> 0.0;
        };
        return gramos * factor;
    }
}
