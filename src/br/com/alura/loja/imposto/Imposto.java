package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Imposto {
	
	private Imposto outroImposto;
	
	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	protected abstract BigDecimal realizarcalculo(Orcamento orcamento);
	
	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal valorImposto = realizarcalculo(orcamento);
		BigDecimal valorOutroImposto = BigDecimal.ZERO;
		
		if (outroImposto != null) {
			valorOutroImposto = outroImposto.realizarcalculo(orcamento);
		}
		
		return valorImposto.add(valorOutroImposto);
	}
}
