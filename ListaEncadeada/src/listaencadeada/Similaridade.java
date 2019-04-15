
package listaencadeada;

public class Similaridade {
    
    public static double norma(ListaEncadeada<Integer> listaA){
        double norma = 0.0;
        
        for (int i = 0; i < listaA.tamanho(); i++)
		{
			norma += Math.pow(listaA.recuperar(i), 2);
		}
        return Math.sqrt(norma);
    }
    
    static double similaridade(ListaEncadeada<Integer> listaA, ListaEncadeada<Integer> listaB) throws Exception
	{
		double similaridade = 0.0, prodInterno = 0.0;
		
		
		if (listaA.tamanho() != listaB.tamanho())
		{
			throw new Exception("As listas devem possuir o mesmo tamanho.");
		}
		
		else
		{
			for (int i = 0; i < listaA.tamanho(); i++)
			{
				prodInterno += listaA.recuperar(i) * listaB.recuperar(i);				
			}
			
			similaridade += prodInterno / (norma(listaA) * norma(listaB));
		}
		
		return Math.round(similaridade * 100.0) / 100.0;
	}
    
    public static void main(String[] args) throws Exception
	{
		ListaEncadeada<Integer> listaA = new ListaEncadeada<Integer>();
		
		listaA.inserirOrdenado(1);
		listaA.inserirOrdenado(2);
		listaA.inserirOrdenado(3);
		listaA.inserirOrdenado(4);	
		
		ListaEncadeada<Integer> listaB = new ListaEncadeada<Integer>();
		
		listaB.inserirOrdenado(1);
		listaB.inserirOrdenado(2);
		listaB.inserirOrdenado(3);
		listaB.inserirOrdenado(4);
		
		System.out.println(similaridade(listaA, listaB));
	}
}
