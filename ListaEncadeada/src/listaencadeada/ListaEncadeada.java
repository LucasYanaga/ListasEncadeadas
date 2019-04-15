package listaencadeada;


public class ListaEncadeada<T> {
    private No primeiroNo;
    private No ultimoNo;
    private int tamanho;
    
    //Construtor da Lista Encadeada.
    public <T>ListaEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }
    
    //Inserir Elementos.
    public void inserir(int elemento){
        No novoNo = new No(elemento); //Cria novo nó.
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
    
    //Inserir depois entrando com No.
    public void inserirDepois(No posicao,int elemento){
            No novoNo = new No(elemento);            //Cria novo No.              
            novoNo.setProximo(posicao.getProximo()); //Seta o próximo da posição como proximo do novoNo.
            posicao.setProximo(novoNo);              //Seta o proximo da posição como o novoNo.
            tamanho++; //Acresenta 1 ao tamanho.
    }
    
    //Inserir depois de uma posição.
    public void inserirDepoisPosicao(int posicao, int elemento){
        if(posicao >= tamanho()){ //Verificação de posição.
            System.out.println("Posição Inválida.");
        }else{ //Se não...
            No noFrente = recuperarNo(posicao + 1);
            No noAtual = recuperarNo(posicao);          //Recupera No Atual.
            No novoNo = new No(elemento);               //Cria novo No.              
            noAtual.setProximo(novoNo);                 //Seta o novoNo como proximo do Atual.
            novoNo.setProximo(noFrente);                //Seta o noFrente como proximo do novoN
        }
        tamanho++;
    }
    
    //Inserir por primeiro.
    public void inserirPrimeiro(int elemento){
        No novoNo = new No(elemento);       //Cria novoNo.
        novoNo.setProximo(primeiroNo);      //Seta o primeiroNo como próximo do novoNo.
        this.primeiroNo = novoNo;           //Atualiza o ponteiro do primeiroNo como novoNo.
        tamanho++; //Acrescenta 1 ao tamanho.
    }
    
    //Inserir por último.
    public void inserirUltimo(int elemento){
        No novoNo = new No(elemento);       //Cria novoNo
        ultimoNo.setProximo(novoNo);        //Seta o novoNo como proximo do ultimoNo.
        this.ultimoNo = novoNo;             //Atualiza o ponteiro do ultimoNo como novoNo
        tamanho++; //Acresenta 1 ao tamnho.
    }
    
    public void inserirOrdenado(int elemento){
        No auxNo = new No(elemento);
        
        if(vazio()){
            this.inserirPrimeiro(elemento);
        }else{
            if(elemento < this.primeiroNo.getElemento()){
                this.inserirPrimeiro(elemento);
            }else{
                No novoNo = primeiroNo;
                No proximoNo = null;
                
                while(novoNo != null && novoNo.getElemento() < auxNo.getElemento()){
                    proximoNo = novoNo;
                    novoNo = novoNo.getProximo();
                }
                proximoNo.setProximo(novoNo);
                
                this.inserirDepois(proximoNo, elemento);
            }
        }
        
              
    }
    
    public void removePrimeiro(){
        No novoNo = primeiroNo;
        primeiroNo = primeiroNo.getProximo(); //Passar ponteiro do primeiro para frente.
        novoNo.setProximo(null);              //NovoNo, que era o antigo primeiro(antes de ser atualizado^^), passsa a ser null
        tamanho--;                            //decresce 1 do tamanho.
        
    }
    public void removeUltimo(){
        No novoNo = primeiroNo;
        No noAnterior = null;
        
        while(novoNo.getProximo() != null){ //Enquando o proximo do novoNo for diferente de null...
            noAnterior = novoNo;            //Atribui o novoNo ao noAnterior
            novoNo = novoNo.getProximo();   //Atualiza o novoNo para o seu próximo.
        }
        tamanho--;
        noAnterior.setProximo(null);        /*Assim quando o novoNó chegar no último Nó(condição que seu próximo seja null),
                                             o anterior vai ser 1 posição atrás, e setaremos o próximo do anterior(novoNo, que é o último) como NULL.*/
    }
    
    /*Recuperar elemento de uma posição.
    public T recuperar(int posicao){
      if(posicao >= tamanho()){ //Verifica posição.
          System.out.println("Posição Inválida.");
      }
       No<T> no = recuperarNo(posicao); //Variável para guaradar posição do No.
      if(no != null){ //Se for diferente de null...
          return no.getElemento(); //Retorna o elemento da posição guardada na variável.
      }
      return null; //Se não retorna null.
    }*/
    
    //Recuperar Nó de uma poisção.
    private No recuperarNo(int posicao){
        if(posicao >= tamanho()){ //Verifica posição.
            System.out.println("Posição Inválida.");
        }
        No resultado = null; //Cria variável do tipo No<T>.
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
            No noAtual = this.primeiroNo;
            StringBuilder sb = new StringBuilder();
            sb.append("Lista[ " );                                                                          
            for(int i = 0; i < tamanho(); i++){
                if(noAtual.getElemento() != 0){
                sb.append(noAtual.getElemento());
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
