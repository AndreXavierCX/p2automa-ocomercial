package com.unilins.p2springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unilins.p2springboot.entities.Aluguel;
import com.unilins.p2springboot.entities.Carro;
import com.unilins.p2springboot.entities.Cliente;
import com.unilins.p2springboot.entities.pk.PK_Aluguel;
import com.unilins.p2springboot.services.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/aluguel")
public class AluguelResource {

	@Autowired
	private AluguelService aluguelService;

	@Autowired
	private CarroService carroService;

	@Autowired
	private ClienteService clienteService;

	@CrossOrigin(origins = "*")
	@PostMapping("/{carroId}/{clienteId}")
	public ResponseEntity<Void> saveAluguel(@PathVariable Long carroId, @PathVariable Long clienteId,
			@RequestBody Aluguel aluguel) {
		aluguel.setCarro(carroService.findById(carroId));
		aluguel.setCliente(clienteService.findById(clienteId));
		aluguelService.saveAluguel(aluguel);
		
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{carroId}/{clienteId}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Aluguel> getAluguel(@PathVariable Long carroId, @PathVariable Long clienteId) {
		PK_Aluguel id = new PK_Aluguel();
		id.setCarro(carroService.findById(carroId));
		id.setCliente(clienteService.findById(clienteId));

		Aluguel aluguel = aluguelService.getAluguel(id);

		if (aluguel != null) {
			return ResponseEntity.ok(aluguel);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Aluguel>> getAllAlugueis() {
		List<Aluguel> alugueis = aluguelService.getAllAlugueis();
		return ResponseEntity.ok(alugueis);
	}

	@PutMapping("/{carroId}/{clienteId}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Aluguel> updateAluguel(@PathVariable Long carroId, @PathVariable Long clienteId,
			@RequestBody Aluguel updatedAluguel) {
		PK_Aluguel id = new PK_Aluguel();
		id.setCarro(carroService.findById(carroId));
		id.setCliente(clienteService.findById(clienteId));

		Aluguel aluguel = aluguelService.updateAluguel(id, updatedAluguel);

		if (aluguel != null) {
			return ResponseEntity.ok(aluguel);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{carroId}/{clienteId}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Void> deleteAluguel(@PathVariable Long carroId, @PathVariable Long clienteId) {
		PK_Aluguel id = new PK_Aluguel();
		id.setCarro(carroService.findById(carroId));
		id.setCliente(clienteService.findById(clienteId));

		aluguelService.deleteAluguel(id);
		return ResponseEntity.noContent().build();
	}
}
