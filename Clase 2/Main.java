import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        Vehiculo[] v = new Vehiculo[5];
        
        v[0] = new Vehiculo("WSE2324343DS", "BMW", 2000, true);
        v[1] = new Vehiculo("OP9864HYHHYW", "KIA", 2025, false);
        v[2] = new Vehiculo("234VBGT4334F", "CHEVROLET", 2005, true);
        v[3] = new Vehiculo("QAWE3ER4RT66", "PEGOUT", 2010, false);
        v[4] = new Vehiculo("23SDER5443DF", "MERCEDEZ BENZ", 1970, true);
        
        System.out.println(v[0].iterarVehiculos(v));
    }
}
