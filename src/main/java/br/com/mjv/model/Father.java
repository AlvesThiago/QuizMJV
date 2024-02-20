package br.com.mjv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tabela_pai")
public class Father {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fatherName;

    private Long fatherAge;
    @OneToMany(mappedBy = "paiDentroDeFilho", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Son> son  = new ArrayList<>();
    public Father() {

    }

    public Father(Long id, String fatherName, Long fatherAge) {
        this.id = id;
        this.fatherName = fatherName;
        this.fatherAge = fatherAge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getFatherAge() {
        return fatherAge;
    }

    public void setFatherAge(Long fatherAge) {
        this.fatherAge = fatherAge;
    }
}
