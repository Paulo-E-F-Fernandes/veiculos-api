package br.com.paulofernandes.veiculo.resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulofernandes.veiculo.models.Veiculo;
import br.com.paulofernandes.veiculo.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("${origem-permitida}")
public class VeiculoResource {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public List<Veiculo> listar() {
		return veiculoService.listar();
	}

	@PostMapping
	public void adicionar(@Valid @RequestBody Veiculo veiculo) {
		veiculoService.adicionar(veiculo);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody Veiculo veiculo) {
		veiculoService.atualizar(veiculo);
	}

	@DeleteMapping("/{placa}")
	public void deletar(@PathVariable String placa) {
		veiculoService.remover(placa);
	}

	/**
	 * Alteração para customizar a exceção.
	 *
	 * @param response
	 * @throws IOException
	 */
	@ExceptionHandler({ IllegalArgumentException.class })
	private void handleBadRequest(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}
