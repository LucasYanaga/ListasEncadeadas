
package listaencadeada;


public class Main {
    public static void main(String[] args) {
        ListaEncadeada listaA = new ListaEncadeada();
       
        listaA.inserir(4);                  //[4]
        listaA.inserir(5);                  //[4, 5]
        listaA.inserirOrdenado(2);          //[2, 4, 5]
        listaA.inserirOrdenado(1);          //[1, 2, 4, 5]
        listaA.inserirOrdenado(3);          //[1, 2, 3, 4, 5]
        listaA.inserirPrimeiro(6);          //[6, 1, 2, 3, 4, 5]
        listaA.inserirUltimo(7);            //[6, 1, 2, 3, 4, 5, 7]
        listaA.inserirDepoisPosicao(2, 8);  //[6, 1, 2, 8, 3, 4, 5, 7]
        listaA.inserirDepoisPosicao(0, 9);  //[6, 9 ,1, 2, 8, 3, 4, 5, 7]
        System.out.println(listaA.toString());
        listaA.removePrimeiro();
        listaA.removeUltimo();
        //[9, 1, 2, 8, 3, 4, 5]
        System.out.println(listaA.toString());
    }
}
