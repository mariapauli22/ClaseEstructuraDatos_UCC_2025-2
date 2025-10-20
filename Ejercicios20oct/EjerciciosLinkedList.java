import java.util.LinkedList;
import java.util.Iterator;

public class EjerciciosLinkedList {

    // Remover duplicados
    public static void removerDuplicados(LinkedList<Integer> lista) {
        LinkedList<Integer> sinDuplicados = new LinkedList<>();
        for (Integer num : lista) {
            if (!sinDuplicados.contains(num)) {
                sinDuplicados.add(num);
            }
        }
        lista.clear();
        lista.addAll(sinDuplicados);
    }

    // Mover el último elemento al inicio
    public static void moverUltimoAlInicio(LinkedList<Integer> lista) {
        if (lista.size() > 1) {
            Integer ultimo = lista.removeLast();
            lista.addFirst(ultimo);
        }
    }

    // Separar pares e impares
    public static void separarParesImpares(LinkedList<Integer> lista) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for (Integer num : lista) {
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }

        System.out.println("Lista de pares: " + pares);
        System.out.println("Lista de impares: " + impares);
    }

    // Imprimir la lista al revés
    public static void imprimirReversa(LinkedList<Integer> lista) {
        Iterator<Integer> it = lista.descendingIterator();
        System.out.print("Lista invertida: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    // Probar todo
    public static void main(String[] args) {
        LinkedList<Integer> numeros = new LinkedList<>();
        numeros.add(3);
        numeros.add(5);
        numeros.add(3);
        numeros.add(8);
        numeros.add(2);
        numeros.add(5);

        System.out.println("Lista original: " + numeros);

        removerDuplicados(numeros);
        System.out.println("Sin duplicados: " + numeros);

        moverUltimoAlInicio(numeros);
        System.out.println("Último al inicio: " + numeros);

        separarParesImpares(numeros);

        imprimirReversa(numeros);
    }
}