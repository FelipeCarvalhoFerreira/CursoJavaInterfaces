package model.services;

public interface ServicoPagamentoOnline {

	public Double taxaPagamento(Double ValorParcela);
	public Double Juro(Double valorParcela, Integer meses);
}
