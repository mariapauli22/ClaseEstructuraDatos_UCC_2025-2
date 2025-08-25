public class Vehiculo {
    
    private String chasis;
    private String marca;
    private int modelo;
    private boolean matriculado;
    
    public Vehiculo(String chasis, String marca, int modelo, boolean matriculado){
        this.chasis = chasis;
        this.marca = marca;
        this.modelo = modelo;
        this.matriculado = matriculado;
    }
    
    public String toString(){
        return "Vehiculo [ Chasis: " + chasis + " Marca: " + marca + " Modelo: " + modelo + " Matriculado: " + matriculado + "]";
    }
    
    //Método para iterar el arreglo
    public String iterarVehiculos(Vehiculo[] v){
        String cad = "";
        for(int i = 0; i < v.length; i++){
            cad += v[i].toString() + "\n";
        }
        return cad;
    }
}