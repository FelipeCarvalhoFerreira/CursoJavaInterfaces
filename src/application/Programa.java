package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ServicoContrato;
import model.services.ServicoaPagamentoPaypal;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero do Contrato: ");
		int numeroContrato = sc.nextInt();
		System.out.print("Data do Contrato (dd/MM/yyyy): ");
		LocalDate dataContrato = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valorTotalContrato = sc.nextDouble();
		
		Contrato contrato = new Contrato(numeroContrato, dataContrato, valorTotalContrato);
		
		System.out.print("Entre com o numero de parcelas: "); 
		Integer numeroParcelar = sc.nextInt();
		
		System.out.println("Parcelas do Contrato: "); 
		
		ServicoContrato servicoContrato = new ServicoContrato (new ServicoaPagamentoPaypal());
		servicoContrato.ProcessarContrato(contrato, numeroParcelar);
		
		for (Parcela parcelas : contrato.getParcelas()) {
			System.out.println(parcelas);
			
		}
		
		sc.close();

	}

}
