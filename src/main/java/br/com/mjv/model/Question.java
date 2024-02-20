package br.com.mjv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private String response;
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Alternative> alternatives = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Theme temaDentroDaQuestao;
    public Question(){

    }

    public Question(Long id, String question, String response, List<Alternative> alternatives, Theme temaDentroDaQuestao) {
        this.id = id;
        this.question = question;
        this.response = response;
        this.alternatives = alternatives;
        this.temaDentroDaQuestao = temaDentroDaQuestao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Theme getTemaDentroDaQuestao() {
        return temaDentroDaQuestao;
    }

    public void setTemaDentroDaQuestao(Theme temaDentroDaQuestao) {
        this.temaDentroDaQuestao = temaDentroDaQuestao;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", response='" + response + '\'' +
                ", alternatives=" + alternatives +
                ", temaDentroDaQuestao=" + temaDentroDaQuestao +
                '}';
    }

}
