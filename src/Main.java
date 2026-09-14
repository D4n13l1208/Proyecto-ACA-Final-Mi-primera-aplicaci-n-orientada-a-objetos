import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true; // bandera inicializada en true

        // Arreglo simple (requisito 3.4)
        String[] categorias = {"Operaciones básicas", "Avanzadas", "Salir"};
        System.out.println("Categorías disponibles:");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i+1) + ". " + categorias[i]);
        }

        while (flag) {
            System.out.println("=================================");
            System.out.println("       CALCULADORA BÁSICA        ");
            System.out.println("=================================");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Potenciación (Calculadora científica)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                if (opcion >= 1 && opcion <= 4) {
                    System.out.print("Ingrese el primer número: ");
                    double n1 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese el segundo número: ");
                    double n2 = Double.parseDouble(scanner.nextLine());

                    Calculadora calc = new Calculadora(n1, n2);

                    if (opcion == 1) {
                        System.out.println("Resultado: " + calc.sumar());
                    } else if (opcion == 2) {
                        System.out.println("Resultado: " + calc.restar());
                    } else if (opcion == 3) {
                        System.out.println("Resultado: " + calc.multiplicar());
                    } else { // opción 4
                        try {
                            System.out.println("Resultado: " + calc.dividir());
                        } catch (DivisionPorCeroException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                } else if (opcion == 5) {
                    try {
                        System.out.print("Ingrese la base: ");
                        double base = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese el exponente: ");
                        double exponente = Double.parseDouble(scanner.nextLine());

                        CalculadoraCientifica calcC = new CalculadoraCientifica(base, exponente);
                        System.out.println("Resultado: " + calcC.potenciar(base, exponente));
                        System.out.println("Tipo: " + calcC.mostrarTipo());

                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un número válido.");
                    }
                } else if (opcion == 6) {
                    System.out.println("Closing calculator... Goodbye!");
                    flag = false; // apagamos la bandera para salir del ciclo
                } else {
                    System.out.println("Debe ingresar una opción válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }

        scanner.close();
    }
}