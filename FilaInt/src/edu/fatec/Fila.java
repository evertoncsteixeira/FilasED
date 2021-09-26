package edu.fatec;

public class Fila {
	No inicio;
	No fim;
	
	public Fila() {
		inicio = null;
		fim = null;
	}
	
	public boolean isEmpty() {
		if ((inicio == null) && (fim == null)) {
			return true;
		} else {
			return false;
		}
	}

	public void adicionarFila(int dado) {

		No novo = new No();
		novo.dado = dado;
		
		if (inicio == null) {
			inicio = novo;
			fim = novo;
			novo.proximo = null;
		} else {
			if (inicio == fim && inicio != null) {
				fim = novo;
				inicio.proximo = fim;
				fim.proximo = null;
			} else {
				fim.proximo = novo;
				novo.proximo = null;
				fim = novo;
			}
		}
	}

	public int removerFila() throws Exception {

		int removido;

		if (isEmpty()) {

			throw new Exception("Não há elementos na fila");

		} else if (inicio == fim) {

			removido = inicio.dado;

			inicio = null;

			fim = null;

		} else {

			removido = inicio.dado;

			fim = inicio;

			inicio = inicio.proximo;

			fim.proximo = inicio;

		}

		return removido;

	}

	public void Listar() throws Exception {

		if (isEmpty()) {

			throw new Exception("Não há elementos na fila");

		}
		No aux = inicio;
		while (aux != null) {

			System.out.println(aux.dado);
			aux =  aux.proximo;
		}

	}
	
	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No aux = inicio;
			while (aux != null) {
				cont += 1;
				aux = aux.proximo;
			}
		}
		return cont;
	}
	
	public int get (int p) throws Exception {
		if (isEmpty()) {
			throw new Exception("Não há elementos na fila");
		}
		
		if (p < 0) {
			throw new Exception("Posição inexistente");
		}
		
		int tamanho = size();
		
		if (p > tamanho - 1) {
			throw new Exception("Posição inexistente");
		}
		
		int cont = 0;
		No aux = inicio;
		while (cont < p) {
			aux = aux.proximo;
			cont++;
		}
		return aux.dado;
	}
}
