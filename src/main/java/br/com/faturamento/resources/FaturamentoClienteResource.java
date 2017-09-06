package br.com.faturamento.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.faturamento.domain.Cliente;
import br.com.faturamento.service.ClienteService;

@RestController
@RequestMapping("/faturamento-cliente")
public class FaturamentoClienteResource {
	
	
	
	@RequestMapping(value="/lista-clientes", method = RequestMethod.GET)
	public ResponseEntity<?> buscaCliente() {		
		
		List<Cliente> lista = new ArrayList<>();
		try {
			 lista = new ClienteService().buscaCliente();
		
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	

	

}
