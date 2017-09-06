package br.com.faturamento.resources;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.faturamento.domain.Cidade;

@RestController
@RequestMapping("faturamento")
public class FaturamentoCidde {

	
	@RequestMapping(value = "/cidades", method = RequestMethod.GET)
	public String faturamentoCidade() {
		
		return "Cidades do Suldeste";
		
	}
	@RequestMapping(value = "/cidades-dados", method = RequestMethod.GET)
	public ResponseEntity<?> faturamentoJSON(){
		
		List<Cidade> lista = new ArrayList<>();
		 Cidade cidade = new Cidade();
		 
			for(int i = 0; i < 10; i++) {
				
				cidade = new Cidade();
				cidade.setNome(" São Paulo " + i);
				cidade.setMunicipio("São Paulo" + i );
				cidade.setCodigo("219092109219029109201920190 " + i);
				lista.add(cidade);
			}
			return ResponseEntity.status(HttpStatus.SC_OK).body(lista);
	}
	
	
	
}
