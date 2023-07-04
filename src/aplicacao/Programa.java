package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import modelo.Exception.DomainExceptions;
import modelo.entidades.ReservaQuarto;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		try {
			System.out.print("Número do quarto: ");
			int quarto = sc.nextInt();
			System.out.print("Data de entrada: ");
			LocalDate dataEntrada = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Data de saida: ");
			LocalDate dataSaida = LocalDate.parse(sc.next(), fmt1);
			
			ReservaQuarto reserva = new ReservaQuarto(quarto, dataSaida, dataEntrada);
			System.out.println("Reserva: " +reserva);
	
			System.out.println();
			System.out.println("Coloque a data para fazer o update da reserva: ");
			System.out.print("Data de entrada: ");
			dataEntrada = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Data de saida: ");
			dataSaida = LocalDate.parse(sc.next(), fmt1);
			
			
			reserva.attData(dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
		}
		catch( DomainExceptions a ){
			System.out.println("Erro na reserva: " + a.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Houve um erro");
			
		}
			
				
		
		sc.close();
	}

}
