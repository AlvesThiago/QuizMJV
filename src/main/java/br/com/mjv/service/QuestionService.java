package br.com.mjv.service;

import br.com.mjv.builder.QuestionMapper;
import br.com.mjv.dto.QuestionDTO;
import br.com.mjv.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questaoRepository;
    @Autowired
    private QuestionMapper questaoMapper;


    public QuestionDTO salvarQuestao(QuestionDTO questionDTO) throws Exception {
        Long newQuestionId = null;
        if (Objects.nonNull(questionDTO.getId())) {
            newQuestionId = questionDTO.getId();
            if (questaoRepository.existsById(newQuestionId)) {
                throw new Exception();
            } else {
                return questaoMapper.toDTO(questaoRepository.save(questaoMapper.toEntity(questionDTO)));
            }

        } else {
            return questaoMapper.toDTO(questaoRepository.save(questaoMapper.toEntity(questionDTO)));
        }
    }

    public void apagarQuestao(Long id){
        questaoRepository.deleteById(id);
    }

    public QuestionDTO buscarPorId(Long id) throws Exception {
        return questaoMapper.toDTO(questaoRepository.findById(id).orElseThrow(Exception::new));
    }

}
