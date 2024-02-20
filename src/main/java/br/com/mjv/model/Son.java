package br.com.mjv.model;

import jakarta.persistence.*;

@Entity
@Table
public class Son {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sonName;

    private Long sonAge;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questao_id")
    private Father paiDentroDeFilho;
    public Son() {

    }

    public Son(Long id, String sonName, Long sonAge) {
        this.id = id;
        this.sonName = sonName;
        this.sonAge = sonAge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public Long getSonAge() {
        return sonAge;
    }

    public void setSonAge(Long sonAge) {
        this.sonAge = sonAge;
    }
}
