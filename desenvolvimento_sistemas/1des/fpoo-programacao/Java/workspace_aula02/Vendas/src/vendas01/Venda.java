package vendas01;

public class Venda {

	String produto;
	float preco;
	int quantidade;
	
	//método, acão
	float subtotal() {
		return preco * quantidade;
	}
	
}
