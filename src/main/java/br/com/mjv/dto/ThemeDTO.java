package br.com.mjv.dto;


import br.com.mjv.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeDTO {

    private String theme;

    private Long id;

    private List<Question> questaoList = new ArrayList<>();

}
