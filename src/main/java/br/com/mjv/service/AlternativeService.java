package br.com.mjv.service;


import br.com.mjv.builder.AlternativeMapper;
import br.com.mjv.dto.AlternativeDTO;
import br.com.mjv.model.Alternative;
import br.com.mjv.repository.AlternativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlternativeService {
    @Autowired
    AlternativeRepository alternativaRepository;

    @Autowired
    AlternativeMapper alternativeMapper;

    public AlternativeDTO getAlternativeById(Long id) throws Exception {
        return alternativeMapper.toDTO(alternativaRepository.findById(id).orElseThrow(Exception::new));
    }

    public List<AlternativeDTO> getAllAlternatives() {
        return alternativeMapper.toListDTO(alternativaRepository.findAll());
    }

    public AlternativeDTO salvaAlternativa(AlternativeDTO alternativeDTO){
        //return alternativaDTO <-- Alternativa <-- AlternativaDTO <-- Alternativa <-- AlternativaDTO
        return alternativeMapper.toDTO(alternativaRepository.save(alternativeMapper.toEntity(alternativeDTO)));
    }

    public void deletaAlternativa(Long id) throws Exception {
        alternativaRepository.delete(alternativeMapper.toEntity(getAlternativeById(id)));
    }

    //Com esse método você consegue mudar um método já salvo no banco, passando uma nova alternativa
    public AlternativeDTO atualizaAlternativa(AlternativeDTO newAlternative, Long id) throws Exception {
        Alternative alternativaAtualizada = alternativaRepository.findById(id).orElseThrow(Exception::new);

        alternativaAtualizada.setAlternative(newAlternative.getAlternative());
        alternativaAtualizada.setCorrect(newAlternative.isCorrect());

        return alternativeMapper.toDTO(alternativaRepository.save(alternativaAtualizada));
    }

}
