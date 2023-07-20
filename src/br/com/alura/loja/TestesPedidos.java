package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestesPedidos {

	public static void main(String[] args) {
		GeraPedido gerador = new GeraPedido("Uiratan Cavalcante", new BigDecimal("300"), 2);
		GeraPedidoHandler handler = new GeraPedidoHandler(
											Arrays.asList(new SalvarPedidoNoBancoDeDados(),
														  new EnviarEmailPedido())
											);
		
		handler.execute(gerador);
	}

}
