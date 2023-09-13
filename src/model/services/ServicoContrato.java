package model.services;

import java.time.LocalDate;

import model.entities.Contrato;
import model.entities.Parcela;

public class ServicoContrato {
	
	private ServicoPagamentoOnline servicoPagamentoOnline;

	public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}

	public ServicoPagamentoOnline getServicoPagamentoOnline() {
		return servicoPagamentoOnline;
	}

	public void setServicoPagamentoOnline(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}
	
	public void ProcessarContrato(Contrato contrato, Integer meses) {
		Double valorTotalContrato = contrato.getValorTotalContrato() / meses;
		for (int i= 1; i <= meses; i++) {
			LocalDate dataParcela = contrato.getDataContrato().plusMonths(i);
			Double juroPagamento = servicoPagamentoOnline.Juro(valorTotalContrato, i);
			Double taxaPagamento = servicoPagamentoOnline.taxaPagamento(valorTotalContrato + juroPagamento);
			Double valorParcelaMensal = valorTotalContrato + taxaPagamento + juroPagamento;
			contrato.getParcelas().add(new Parcela (dataParcela, valorParcelaMensal));
		}
	}
}
