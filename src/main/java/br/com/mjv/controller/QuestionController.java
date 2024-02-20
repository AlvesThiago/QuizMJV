package br.com.mjv.controller;

import br.com.mjv.dto.QuestionDTO;
import br.com.mjv.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questao")
public class QuestionController {

    @Autowired
    QuestionService questaoService;

    @GetMapping("{id}")
    public ResponseEntity<QuestionDTO> encontraQuestaoPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(questaoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<QuestionDTO> salvaQuestao(@RequestBody QuestionDTO questionDTO) throws Exception {
        return new ResponseEntity<>(questaoService.salvarQuestao(questionDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity deletaQuestao(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
