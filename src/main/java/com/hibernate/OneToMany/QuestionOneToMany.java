package com.hibernate.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionOneToMany {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToMany(mappedBy = "question")
    private List<AnswerOneToMany> answerList;



}