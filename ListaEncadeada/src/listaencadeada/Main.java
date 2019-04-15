
package listaencadeada;


public class Main {
    public static void main(String[] args) {
        ListaEncadeada listaA = new ListaEncadeada();
        
        listaA.inserir(1);
        listaA.inserir(2);
        listaA.inserir(3);
        listaA.inserir(4);
        listaA.inserir(5);
        listaA.inserirPrimeiro(6);
        listaA.inserirUltimo(7);
        listaA.inserirDepois(2, 8);
        listaA.inserirDepois(0, 9);
        // [ 6 | 9 | 1 | 2 | 8 | 3 | 4 | 5 | 7 ]
        System.out.println(listaA.toString());
        listaA.removePrimeiro();
        listaA.removeUltimo();
        // [ 9 | 1 | 2 | 8 | 3 | 4 | 5 ]
        System.out.println(listaA.toString());
    }
}
