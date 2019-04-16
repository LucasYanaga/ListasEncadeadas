
package listaencadeada;

public class No {
    private int elemento;
    private No proximo;
    
    //Construtor com elemento.
    public No(int elemento){
        this.elemento = elemento;
        this.proximo = null;
    }
    
    //Construtor com elemento e proximoNo.
    public No(int elemento, No proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }
    
    //Construtor sem parâmentros.
    public No(){
        this.proximo = null;
    }
    
    //Getters and Setters.
    public void setElemento(int elemento){
        this.elemento = elemento;
    }
    public int getElemento(){
        return this.elemento;
    }
    
    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }
    
    
}
