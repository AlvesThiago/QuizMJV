package br.com.mjv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    private Long id;
    private String theme;
    private String question;
    private String response;
    private List<AlternativeDTO> alternativas;

}
