import java.util.Scanner;

public class ListaPeliculas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántas películas desea ingresar?: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        String[][] peliculas = new String[cantidad][3];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Película #" + (i + 1));

            System.out.print("Título: ");
            peliculas[i][0] = scanner.nextLine();

            System.out.print("Año de lanzamiento: ");
            peliculas[i][1] = scanner.nextLine();

            System.out.print("Género: ");
            peliculas[i][2] = scanner.nextLine();

            System.out.println();
        }

        System.out.println("Lista de películas ingresadas:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Título: " + peliculas[i][0] +
                               ", Año: " + peliculas[i][1] +
                               ", Género: " + peliculas[i][2]);
        }

        scanner.close();
    }
}
