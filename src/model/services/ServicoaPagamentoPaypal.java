package model.services;

public class ServicoaPagamentoPaypal implements ServicoPagamentoOnline {

	public Double taxaPagamento(Double ValorParcela) {
		Double taxaPagamento = 0.02;
		return ValorParcela * taxaPagamento;
	}

	@Override
	public Double Juro(Double valorParcela, Integer meses) {
		Double Juro = 0.01;
		return valorParcela * Juro * meses;
	}

}
