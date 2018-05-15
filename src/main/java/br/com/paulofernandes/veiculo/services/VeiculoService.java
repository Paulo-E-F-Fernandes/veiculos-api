package br.com.paulofernandes.veiculo.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.paulofernandes.veiculo.models.Veiculo;

@Service
public class VeiculoService {

	private static List<Veiculo> veiculos;
	private Comparator<Veiculo> comparador;

	/**
	 * Construtor estático para inicializar o atributo <i>veiculos</i> da
	 * classe.
	 *
	 * Criei como uma varíavel estático para mostrar conhecimento na linguagem,
	 * utilizando o <b>construtor estático</b> para iniciar a <b>lista</b> de
	 * <b>veículos.
	 */
	static {
		veiculos = new ArrayList<>();
	}

	/**
	 * Método responsável por adicionar um novo {@link Veiculo} na {@link List},
	 * sendo que o método atribui também atualiza a <b>data</b> de alteração do
	 * registro e por fim re-ordena a {@link List}.
	 *
	 * @param veiculo
	 *            que se deseja adicionar na {@link List} de {@link Veiculo}.
	 */
	public void adicionar(Veiculo veiculo) {
		if (veiculos.contains(veiculo)) {
			throw new IllegalArgumentException("Veículo já cadastrado!");
		}

		veiculo.setDataAlteracao(Calendar.getInstance());
		veiculos.add(veiculo);

		ordenarVeiculos();
	}

	public void atualizar(Veiculo veiculoAtualizado) {
		final Veiculo veiculo = veiculos.get(veiculos.indexOf(veiculoAtualizado));
		if (veiculo != null) {
			veiculo.setModelo(veiculoAtualizado.getModelo());
			veiculo.setMontadora(veiculoAtualizado.getMontadora());
			veiculo.setAnoFabricacao(veiculoAtualizado.getAnoFabricacao());
			veiculo.setAnoModelo(veiculoAtualizado.getAnoModelo());
			veiculo.setCor(veiculoAtualizado.getCor());
			veiculo.setValor(veiculoAtualizado.getValor());
			veiculo.setDataAlteracao(Calendar.getInstance());

			ordenarVeiculos();
		} else {
			throw new IllegalArgumentException("Veículo não encontrado!");
		}
	}

	/**
	 * Método responsável por remover o {@link Veiculo} selecionado da
	 * {@link List} de {@link Veiculo} apartir da <b>placa</b> do mesmo.
	 *
	 * @param placa
	 *            uma {@link String} que identifica a <b>placa</b>, ou seja, o
	 *            identificador do {@link Veiculo} que será removido.
	 */
	public void remover(String placa) {
		final Veiculo veiculoSelecionado = new Veiculo(placa);
		veiculos.remove(veiculoSelecionado);
	}

	/**
	 * Método responsável por retornar toda a {@link List} de {@link Veiculo}.
	 *
	 * @return {@link List} com todos os {@link Veiculo}.
	 */
	public List<Veiculo> listar() {
		return veiculos;
	}

	/**
	 * Método criado com a responsabilidade de ordenar a {@link List} de
	 * {@link Veiculo}, sendo que o mesmo verifica se o <b>comparador</b> está
	 * instanciado, caso esteja usa o mesmo. Caso não esteja instanciado, é
	 * feita a inicialização do comparador para depois utilizar.
	 */
	private void ordenarVeiculos() {
		if (comparador == null) {
			comparador = new Comparator<Veiculo>() {

				@Override
				public int compare(Veiculo o1, Veiculo o2) {
					return o1.getModelo().compareToIgnoreCase(o2.getModelo());
				}

			};
		}

		veiculos.sort(comparador);
	}

}
