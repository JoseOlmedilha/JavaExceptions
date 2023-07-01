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

	
	public void attData(LocalDate entrada, LocalDate saida) {
		this.dataEntrada = entrada;
		this.dataSaida = saida;
		
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
