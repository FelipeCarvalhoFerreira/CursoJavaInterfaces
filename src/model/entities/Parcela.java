package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {

	private LocalDate dataParcelas;
	private Double quantidade;
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Parcela(LocalDate dataParcelas, Double quantidade) {
		this.dataParcelas = dataParcelas;
		this.quantidade = quantidade;
	}

	public LocalDate getDataParcelas() {
		return dataParcelas;
	}

	public void setDataParcelas(LocalDate dataParcelas) {
		this.dataParcelas = dataParcelas;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return getDataParcelas().format(fmt) +  " - " + String.format("%.2f", getQuantidade());
	}
	
	
}
