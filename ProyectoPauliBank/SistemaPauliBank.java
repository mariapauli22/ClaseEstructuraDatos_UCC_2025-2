import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPauliBank {

    private ArrayList<CuentaPauli> cuentas = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // --- CRUD DE LAS CUENTAS -W- //

    public void crearCuenta() {
        System.out.print("ID de la cuenta: ");
        String id = sc.nextLine();
        System.out.print("Nombre del titular: ");
        String nombre = sc.nextLine();

        cuentas.add(new CuentaPauli(id, nombre, 0));
        System.out.println("Cuenta creada con éxito.\n");
    }

    public void actualizarCuenta() {
        System.out.print("ID a actualizar: ");
        String id = sc.nextLine();

        int pos = buscarCuenta(id);
        if (pos == -1) {
            System.out.println("No existe una cuenta con ese ID.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nuevo = sc.nextLine();

        cuentas.get(pos).setNombre(nuevo);
        System.out.println("Cuenta actualizada.\n");
    }

    public void eliminarCuenta() {
        System.out.print("ID a eliminar: ");
        String id = sc.nextLine();

        int pos = buscarCuenta(id);
        if (pos == -1) {
            System.out.println("No existe una cuenta con ese ID.");
            return;
        }

        cuentas.remove(pos);
        System.out.println("Cuenta eliminada.\n");
    }

    //  OPERACIONES DE DINERO :D //

    public void depositar() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        int pos = buscarCuenta(id);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.print("Monto a depositar: ");
        double monto = sc.nextDouble();
        sc.nextLine();

        cuentas.get(pos).depositar(monto);
        System.out.println("Depósito realizado.\n");
    }

    public void retirar() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        int pos = buscarCuenta(id);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.print("Monto a retirar: ");
        double monto = sc.nextDouble();
        sc.nextLine();

        if (cuentas.get(pos).retirar(monto)) {
            System.out.println("Retiro exitoso.\n");
        } else {
            System.out.println("Saldo insuficiente.\n");
        }
    }

    public void transferir() {
        System.out.print("ID origen: ");
        String origen = sc.nextLine();
        System.out.print("ID destino: ");
        String destino = sc.nextLine();

        int p1 = buscarCuenta(origen);
        int p2 = buscarCuenta(destino);

        if (p1 == -1 || p2 == -1) {
            System.out.println("Una de las cuentas no existe.");
            return;
        }

        System.out.print("Monto: ");
        double monto = sc.nextDouble();
        sc.nextLine();

        if (cuentas.get(p1).retirar(monto)) {
            cuentas.get(p2).depositar(monto);
            System.out.println("Transferencia realizada.\n");
        } else {
            System.out.println("Saldo insuficiente.\n");
        }
    }

    //ORDENAMIENTO//

    public void ordenarPorSaldo() {
        quickSort(0, cuentas.size() - 1);
        System.out.println("Cuentas ordenadas por saldo.\n");
    }

    private void quickSort(int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(inicio, fin);
            quickSort(inicio, pivote - 1);
            quickSort(pivote + 1, fin);
        }
    }

    private int particion(int inicio, int fin) {
        double ref = cuentas.get(fin).getSaldo();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (cuentas.get(j).getSaldo() <= ref) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, fin);
        return i + 1;
    }

    private void swap(int a, int b) {
        CuentaPauli tmp = cuentas.get(a);
        cuentas.set(a, cuentas.get(b));
        cuentas.set(b, tmp);
    }

    //---> BUSQUEDA EN BINARIO <---//

    public int buscarCuenta(String id) {
        ordenarPorID();
        return binarySearch(id, 0, cuentas.size() - 1);
    }

    private void ordenarPorID() {
        cuentas.sort((a, b) -> a.getId().compareTo(b.getId()));
    }

    private int binarySearch(String id, int inicio, int fin) {
        if (inicio > fin) return -1;

        int mid = (inicio + fin) / 2;
        String midID = cuentas.get(mid).getId();

        if (midID.equals(id)) return mid;
        if (id.compareTo(midID) < 0)
            return binarySearch(id, inicio, mid - 1);
        else
            return binarySearch(id, mid + 1, fin);
    }

    //LISTAR//

    public void listar() {
        for (CuentaPauli c : cuentas) {
            System.out.println(c);
        }
        System.out.println();
    }
}
