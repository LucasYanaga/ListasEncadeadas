package tdefilalucas;


public class Main {

    
    public static void main(String[] args) {
        Fila filaA = new Fila(5);
        filaA.insere(1);
        filaA.insere(2);
        filaA.insere(3);
        filaA.insere(4);
        filaA.insere(5);
        
        Fila filaB = new Fila(4);
        filaB.insere(6);
        filaB.insere(7);
        filaB.insere(8);
        filaB.insere(9);
        
        System.out.println(filaA.remove());
                
        Fila filaMerge = Fila.merge(filaA, filaB);
        filaMerge.mostrarFila();
        
        
    }
    
}
