package listaencadeada;

public class Interseccao {

    public static boolean pertence(No x, int elemento) {
        No novoNo = x;

        while (novoNo != null) {
            if (novoNo.getElemento() == elemento) {
                return true;
            }

            novoNo = novoNo.getProximo();
        }

        return false;
    }

    public static ListaEncadeada<Integer> interseccao(ListaEncadeada<Integer> listaA, ListaEncadeada<Integer> listaB) {
        No noAtual = listaA.primeiroNo;
        //No novoNo = null;

        ListaEncadeada<Integer> listaC = new ListaEncadeada<>();

        while (noAtual != null) {
            if (pertence(listaB.primeiroNo, noAtual.getElemento())) {
                listaC.inserirOrdenado(noAtual.getElemento());
            }

            noAtual = noAtual.getProximo();
        }

        return listaC;
    }

    public static void main(String[] args) {
        ListaEncadeada<Integer> listaA = new ListaEncadeada<>();

        listaA.inserir(3);
        listaA.inserir(24);
        listaA.inserir(4);
        listaA.inserir(13);
        listaA.inserir(5);

        ListaEncadeada<Integer> listaB = new ListaEncadeada<>();

        listaB.inserir(24);
        listaB.inserir(5);
        listaB.inserir(4);
        listaB.inserir(9);
        listaB.inserir(-1);

        ListaEncadeada<Integer> listaC = new ListaEncadeada<>();

        listaC = interseccao(listaA, listaB);

        System.out.println(listaC.toString());
    }

}
