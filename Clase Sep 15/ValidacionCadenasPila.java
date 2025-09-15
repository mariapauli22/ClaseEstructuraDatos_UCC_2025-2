public class ValidacionCadenasPila{
    Public static void main (String[] args){

        String[] llaves = {"{","{","}","}","}"};

        //Cree una pila de llaves y verifique si las llaves estan
        //Completas,ed decir, una llave que abre riene una llave que cierra

        Stack <String> cadenas = new Stack <>();

        for (int i=0; i <llaves.length; i ++) {
            p.push (llaves [i]);

        }

        system.out.println(p);

        int contador1= 0, contador2= 0;

        int tam = p.size();

        for (int i=0; i <p.size (); i ++) {
            if (p.peek().equals(anObject:"{")){
                contador1 += 1;
            }else{
                contador2 += 1;
            }
            p.pop ();
        
        }

        system.out.println( contador1== contador2? "Equilibrados": "No equilibrados");




    }
}