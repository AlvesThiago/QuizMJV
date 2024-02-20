package br.com.mjv.controller;

import br.com.mjv.dto.AlternativeDTO;
import br.com.mjv.model.Alternative;
import br.com.mjv.service.AlternativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternativa")
public class AlternativeController {

    @Autowired
    AlternativeService alternativeService;

    @GetMapping
    public ResponseEntity<List<AlternativeDTO>> encontraTodasAlternativas(){
        return new ResponseEntity<>(alternativeService.getAllAlternatives(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlternativeDTO> encontraAlternativaPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(alternativeService.getAlternativeById(id), HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<AlternativeDTO> salvaAlternativa(@RequestBody AlternativeDTO alternativeDTO) {
        return new ResponseEntity<>(alternativeService.salvaAlternativa(alternativeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity deletaAlternativa(@PathVariable Long id){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<AlternativeDTO> atualizaAlternativa(@RequestBody AlternativeDTO alternativeDTO, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(alternativeService.atualizaAlternativa(alternativeDTO, id), HttpStatus.CREATED);
    }

}
