package br.com.mjv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlternativeDTO {

    private Long id;
    private String alternative;
    private boolean correct;

}
