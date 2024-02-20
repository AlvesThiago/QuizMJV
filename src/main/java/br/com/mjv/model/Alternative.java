package br.com.mjv.model;

import jakarta.persistence.*;


@Entity
@Table
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String alternative;
    private boolean correct;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questao_id")

    private Question question;


    public Alternative(){

    }

    public Alternative(Long id, String alternative, boolean correct, Question question) {
        this.id = id;
        this.alternative = alternative;
        this.correct = correct;
        this.question = question;
    }

    public Alternative(String alternative, boolean correct, Question question) {
        this.alternative = alternative;
        this.correct = correct;
        this.question = question;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
