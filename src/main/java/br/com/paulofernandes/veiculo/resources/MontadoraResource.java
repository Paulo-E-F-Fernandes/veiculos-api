package br.com.paulofernandes.veiculo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulofernandes.veiculo.models.Montadora;
import br.com.paulofernandes.veiculo.services.MontadoraService;

@RestController
@CrossOrigin("${origem-permitida}")
public class MontadoraResource {

	@Autowired
	private MontadoraService montadoraService;

	@GetMapping("/montadoras")
	public List<Montadora> listar() {
		return montadoraService.listar();
	}

}
