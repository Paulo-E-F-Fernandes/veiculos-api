package br.com.paulofernandes.veiculo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.paulofernandes.veiculo.models.Montadora;

@Service
public class MontadoraService {

	// Atributo que representa a lista de montadoras que será utilizado no combo
	// da tela de cadastro.
	private static List<Montadora> montadoras;
	// Atributo para ser utilizado como identificador das montadoras
	private static long proximoId;

	/**
	 * Construtor estático para inicializar os atributos da classe.
	 *
	 * Eu poderia estar usando os <b>scopes</b> do <b>Spring</b> para manter os
	 * dados de <b>montadoras</b> e também de <b>veículos</b>, mas criei como
	 * uma varíavel estático para mostrar conhecimento na linguagem, utilizando
	 * o <b>construtor estático</b> para iniciar os dados de combo das
	 * montadoras.
	 */
	static {
		montadoras = new ArrayList<>();
		proximoId = 1;
	}

	/**
	 * Método criado para realizar o <b>insert</b> da {@link Montadora} na
	 * {@link List} <b>static</b> de {@link Montadora}.
	 *
	 * Essa {@link List} é utilizada, principalmente, para carregar o combo de
	 * <b>montadoras</b> na tela de cadastro.
	 *
	 * @param montadora
	 *            que será <b>inserida</b> na {@link List} de {@link Montadora}.
	 */
	public void adicionar(Montadora montadora) {
		montadora.setId(proximoId());
		montadoras.add(montadora);
	}

	/**
	 * Método criado para retornar a {@link List} de {@link Montadora} com os
	 * dados registrados.
	 *
	 * O método verifica se a {@link List} está instanciada, caso não esteja é
	 * feita a instanciação da mesma e após isso é retornada essa {@link List}.
	 * Caso a {@link List} já foi instanciada, apenas é feito o <b>return</b> da
	 * mesma, seguindo a idéia do Singleton.
	 *
	 * @return {@link List} de todas as {@link Montadora}
	 */
	public List<Montadora> listar() {
		if (montadoras.isEmpty()) {
			initMontadoras();
		}

		return montadoras;
	}

	/**
	 * Método criado apenas para carregar os dados da {@link Montadora} na
	 * {@link List}, desta forma o combo de <b>montadoras</b> da tela será
	 * exibida com todos os dados.
	 */
	private void initMontadoras() {
		adicionar(new Montadora("Audi"));
		adicionar(new Montadora("BMW"));
		adicionar(new Montadora("Chevrolet"));
		adicionar(new Montadora("Fiat"));
		adicionar(new Montadora("Ford"));
		adicionar(new Montadora("Honda"));
		adicionar(new Montadora("Jaguar"));
		adicionar(new Montadora("Mercedes"));
		adicionar(new Montadora("Renault"));
		adicionar(new Montadora("Volkswagen"));
		adicionar(new Montadora("Volvo"));
	}

	/**
	 * Apenas um método de auto incremento para criar um identificador para a
	 * {@link Montadora}.
	 *
	 * @return o próximo id
	 */
	private static Long proximoId() {
		return proximoId++;
	}

}
