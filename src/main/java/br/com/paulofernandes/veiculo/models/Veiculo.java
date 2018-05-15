package br.com.paulofernandes.veiculo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Veiculo implements Serializable {

	private static final long serialVersionUID = -811278681179502861L;

	@NotEmpty(message = "A Placa deve ser informada")
	private String placa;
	private Montadora montadora;
	@NotEmpty(message = "O Modelo deve ser informado")
	private String modelo;
	@NotNull(message = "O Ano de Fabricação deve ser informado")
	private Integer anoFabricacao;
	@NotNull(message = "O Ano do Modelo deve ser informado")
	private Integer anoModelo;
	private BigDecimal valor;
	@NotEmpty(message = "A Cor deve ser informada")
	private String cor;
	private Calendar dataAlteracao;

	public Veiculo() {
	}

	public Veiculo(String placa) {
		setPlaca(placa);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = (placa != null) ? placa.toUpperCase() : placa;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Veiculo other = (Veiculo) obj;
		if (placa == null) {
			if (other.placa != null) {
				return false;
			}
		} else if (!placa.equals(other.placa)) {
			return false;
		}
		return true;
	}

}
