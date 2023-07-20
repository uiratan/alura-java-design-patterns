package br.com.alura.loja.orcamento;

import java.util.Map;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

public class RegistroDeOrcamento {

	private HttpAdapter http;
	
	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}

	public void registrar(Orcamento orcamento) {
		// chamada http para a api externa
		// url connection
		// http cliente
		// lib rest
		if (!orcamento.isFinalizado()) {
			throw new DomainException("Orçamento não finalizado!");
		}

		//String url = "http://api.externa/orcamento";
		String url = "https://httpbin.org/post";
		Map<String, Object> dados = Map.of(
				"valor", orcamento.getValor(),
				"quantidadeItens", orcamento.getQuantidade()
				);
		http.post(url , dados);
	}
}
