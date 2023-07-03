package modelo.entidades;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaQuarto {
	
	private Integer numQuarto;
	private LocalDate dataSaida;
	private LocalDate dataEntrada;
	
	
	public ReservaQuarto(Integer numQuarto, LocalDate dataSaida, LocalDate dataEntrada) {
		this.numQuarto = numQuarto;
		this.dataSaida = dataSaida;
		this.dataEntrada = dataEntrada;
	}


	public Integer getNumQuarto() {
		return numQuarto;
	}


	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}


	public LocalDate getDataSaida() {
		return dataSaida;
	}


	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	
	public String attData(LocalDate entrada, LocalDate saida) {
		LocalDate data1 = LocalDate.now();
		
		if(dataEntrada.isBefore(data1) || dataSaida.isBefore(data1) ) {
			return "Erro na reserva: as datas de reserva para atualizações devem ser datas futuras";
		}
		if(!dataSaida.isAfter(dataEntrada)) {
			return "Erro na reserva: a data de saida deve ser posterior à data de entrada";
		}
		this.dataEntrada = entrada;
		this.dataSaida = saida;
		return null;
	}
	
	
	public long duracao() {
		Duration t1 = Duration.between(dataEntrada.atStartOfDay(), dataSaida.atStartOfDay());
		return t1.toDays();
	}
	
	
	@Override
	public String toString() {
		return "Quarto: " + numQuarto 
				+ ", entrada: " + dataEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
				+ ", saída: " + dataSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
				+ ", duração: " + duracao() + " noites";
	}
	
	
	

}
