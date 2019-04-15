
package listaencadeada;

public class No<T> {
    private T elemento;
    private No<T> proximo;
    
    //Construtor com elemento.
    public No(T elemento){
        this.elemento = elemento;
        this.proximo = null;
    }
    
    //Construtor com elemento e No.
    public No(T elemento, No<T> proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }
    
    //Construtor sem parâmentros.
    public No(){
        this.proximo = null;
    }
    
    //Getters and Setters.
    public void setElemento(T elemento){
        this.elemento = elemento;
    }
    public T getElemento(){
        return this.elemento;
    }
    
    public void setProximo(No<T> proximo){
        this.proximo = proximo;
    }

    public No<T> getProximo() {
        return proximo;
    }
    
    
}
