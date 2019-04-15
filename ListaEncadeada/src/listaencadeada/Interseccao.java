package listaencadeada;

public class Interseccao {

    public static boolean pertence(No p, int info) {
        No novoNo = p;

        while (novoNo != null) {
            if (novoNo.getElemento() == info) {
                return true;
            }

            novoNo = novoNo.getProximo();
        }

        return false;
    }

    public static ListaEncadeada<Integer> interseccao(ListaEncadeada<Integer> listaA, ListaEncadeada<Integer> listaB) {
        No aux = listaA.primeiroNo;
        No novo = null;

        ListaEncadeada<Integer> listaC = new ListaEncadeada<>();

        while (aux != null) {
            if (pertence(listaB.primeiroNo, aux.getElemento())) {
                listaC.inserirOrdenado(aux.getElemento());
            }

            aux = aux.getProximo();
        }

        return listaC;
    }

    public static void main(String[] args) {
        ListaEncadeada<Integer> listaA = new ListaEncadeada<Integer>();

        listaA.inserirPrimeiro(3);
        listaA.inserirPrimeiro(24);
        listaA.inserirUltimo(4);
        listaA.inserirPrimeiro(13);

        ListaEncadeada<Integer> listaB = new ListaEncadeada<Integer>();

        listaB.inserirPrimeiro(24);
        listaB.inserirPrimeiro(4);
        listaB.inserirUltimo(9);
        listaB.inserirPrimeiro(-1);

        ListaEncadeada<Integer> listaC = new ListaEncadeada<Integer>();

        listaC = interseccao(listaA, listaB);

        System.out.println(listaC.toString());
    }

}
