import java.util.Scanner;

public class PauliBankApp {
    public static void main (Straing[] args) {
        SistemaPauliBank sistema = new SistemaPauliBank ();
        Scanner sc = new Scanner (System.in);

        int opcion;

        do {
            System.out.println("=== PauliBank Menu ===");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Actualizar cuenta");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Depositar");
            System.out.println("5. Retirar");
            System.out.println("6. Transferir");
            System.out.println("7. Listar cuentas");
            System.out.println("8. Ordenar por saldo");
            System.out.println("9. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> sistema.crearCuenta();
                case 2 -> sistema.actualizarCuenta();
                case 3 -> sistema.eliminarCuenta();
                case 4 -> sistema.depositar();
                case 5 -> sistema.retirar();
                case 6 -> sistema.transferir();
                case 7 -> sistema.listar();
                case 8 -> sistema.ordenarPorSaldo();
                case 9 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }


        }while (opcion !=9);
    }
}