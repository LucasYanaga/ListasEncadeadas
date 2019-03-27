
package tdefilalucas;

public class Fila {
    private Object dados[];
    private int primeiro = 0;
    private int ultimo = -1;
    private int max;
    private int tamanho;
    
    public Fila(int tamanhoFila){
        max = tamanhoFila;
        dados = new Object[tamanhoFila];
        
    }
    
    public boolean cheia(){
        return tamanho == max;
        
    }
    public boolean vazia(){
        return tamanho == 0;
        
    }
    
    public Object primeiro(){
        return dados[primeiro];
    }
    
    public Object ultimo(){
        return dados[ultimo];
    }
    
    public int tamanho(){
        return max;
    }
    
    public void insere(int elemento){
        if(cheia()){
            System.out.println("Fila cheia! Impossível inserir elementos!");
        }
        else{
            ultimo = (ultimo + 1) % max;
            dados[ultimo] = elemento;
            tamanho++;
        }
    }
    
    public Object remove(){
        Object elementoRemovido = null;
        if(vazia()){
            System.out.println("Fila vazia! Impossível remover elementos!");
        }
        else{
            elementoRemovido = dados[primeiro];
            dados[primeiro] = null;
            primeiro = (primeiro + 1) % max;
            tamanho--;
        }
        return elementoRemovido;
    }
    
    public void mostrarFila(){
        for(int i = 0; i < max; i++){
            System.out.print("| " + dados[i] + " ");
            
        }
        System.out.println("|");
    }
    
    public static Fila merge(Fila filaA, Fila filaB){
        Fila filaC = new Fila(filaA.tamanho() + filaB.tamanho());
        
        
        do{
        
            if(filaA.vazia() && filaB.vazia()){
                break;
            }
            else if(filaA.vazia()){
                filaC.insere(filaA.remove());
            }
            else if(filaB.vazia()){
                filaC.insere(filaB.remove());
            }
            else if(filaA.primeiro() < filaB.primeiro()){
                filaC.insere(filaA.remove());
            }
            else if(filaB.primeiro() < filaB.primeiro()){
                filaC.insere(filaB.remove());
            }
        }
           while(true);
        
        
        return filaC;
    }
    
    
}
