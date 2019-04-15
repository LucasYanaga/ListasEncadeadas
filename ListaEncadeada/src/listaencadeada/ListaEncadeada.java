package listaencadeada;


public class ListaEncadeada<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;
    
    //Construtor da Lista Encadeada.
    public <T>ListaEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }
    
    //Inserir Elementos.
    public void inserir(T elemento){
        No<T> novoNo = new No<T>(elemento); //Cria novo nó.
        if(vazio()){ // Se vazia...
            this.primeiroNo = novoNo; //Ponteiro do primeiro vai para o novo nó.
            this.ultimoNo = novoNo;   //Ponteiro do ultimo vai para o novo nó.
        }
        else{ //Se não...
            this.ultimoNo.setProximo(novoNo); //O novo nó é setado como próximo do atual último.
            this.ultimoNo = novoNo;           //O ponteiro do último passa para o novo nó.
            
        }
        this.tamanho++; //Acrescenta 1 ao tamanho.
    }
    
    //Inserir depois determinada poisição.
    public void inserirDepois(int posicao,T elemento){
        if(posicao >= tamanho()){ //Verificação de posição.
            System.out.println("Posição Inválida.");
        }else{ //Se não...
            No<T> noFrente = recuperarNo(posicao + 1);
            No<T> noAtual = recuperarNo(posicao);       //Recupera No Atual.
            No<T> novoNo = new No<T>(elemento);         //Cria novo No.              
            noAtual.setProximo(novoNo);                 //Seta o novoNo como proximo do Atual.
            novoNo.setProximo(noFrente);                //Seta o noFrente como proximo do novoNo
            
         }
        tamanho++; //Acresenta 1 ao tamanho.
    }
    
    //Inserir por primeiro.
    public void inserirPrimeiro(T elemento){
        No<T> novoNo = new No<T>(elemento); //Cria novoNo.
        novoNo.setProximo(primeiroNo);      //Seta o primeiroNo como próximo do novoNo.
        this.primeiroNo = novoNo;           //Atualiza o ponteiro do primeiroNo como novoNo.
        tamanho++; //Acrescenta 1 ao tamanho.
    }
    
    //Inserir por último.
    public void inserirUltimo(T elemento){
        No<T> novoNo = new No<T>(elemento); //Cria novoNo
        ultimoNo.setProximo(novoNo);        //Seta o novoNo como proximo do ultimoNo.
        this.ultimoNo = novoNo;             //Atualiza o ponteiro do ultimoNo como novoNo
        tamanho++; //Acresenta 1 ao tamnho.
    }
    
    public void removePrimeiro(){
        No<T> novoNo = primeiroNo;
        primeiroNo = primeiroNo.getProximo(); //Passar ponteiro do primeiro para frente.
        novoNo.setProximo(null);              //NovoNo, que era o antigo primeiro(antes de ser atualizado^^), passsa a ser null
        tamanho--;                            //decresce 1 do tamanho.
        
    }
    public void removeUltimo(){
        No<T> novoNo = primeiroNo;
        No<T> noAnterior = null;
        
        while(novoNo.getProximo() != null){ //Enquando o proximo do novoNo for diferente de null...
            noAnterior = novoNo;            //Atribui o novoNo ao noAnterior
            novoNo = novoNo.getProximo();   //Atualiza o novoNo para o seu próximo.
        }
        tamanho--;
        noAnterior.setProximo(null);        /*Assim quando o novoNó chegar no último Nó(condição que seu próximo seja null),
                                             o anterior vai ser 1 posição atrás, e setaremos o próximo do anterior(novoNo, que é o último) como NULL.*/
    }
    
    //Recuperar elemento de uma posição.
    public T recuperar(int posicao){
      if(posicao >= tamanho()){ //Verifica posição.
          System.out.println("Posição Inválida.");
      }
      No<T> no = recuperarNo(posicao); //Variável para guaradar posição do No.
      if(no != null){ //Se for diferente de null...
          return no.getElemento(); //Retorna o elemento da posição guardada na variável.
      }
      return null; //Se não retorna null.
    }
    
    //Recuperar Nó de uma poisção.
    private No<T> recuperarNo(int posicao){
        if(posicao >= tamanho()){ //Verifica posição.
            System.out.println("Posição Inválida.");
        }
        No<T> resultado = null; //Cria variável do tipo No<T>.
        for(int i = 0; i <= posicao; i++){ //Varrer posições de 0 até posição.
             if(i == 0){
                 resultado = this.primeiroNo; //Se for == 0, retorna o primeiroNo.
             }else{
                 resultado = resultado.getProximo(); //Se não, ele pegando o proximo, e vai atualizando a variável.
             }
        }
        return resultado; //retorna o resultado.
    }
    
    //Retorna True se vazia, se não false.
    public boolean vazio(){
        if(this.tamanho == 0){
            return true;
        }
        else{
            return false;
        }     
    }
    
    //Retorna Tamanho.
    public int tamanho(){
        return this.tamanho;
    }
    
    
    //ToString para mostrar Lista Encadeada.
    @Override
    public String toString() {
        if(vazio()){
            return "ListaEncadeada[]";
        }else{
            No<T> noAtual = this.primeiroNo;
            StringBuilder sb = new StringBuilder();
            sb.append("Lista[ " );                                                                          
            for(int i = 0; i < tamanho(); i++){
                if(noAtual.getElemento() != null){
                sb.append(noAtual.getElemento().toString());
                }else{
                sb.append("<NULO>");
                }
                sb.append(" | ");
                noAtual = noAtual.getProximo();
            }
            sb.append(" ]");
            return sb.toString();
        }
    }
    
    
}
