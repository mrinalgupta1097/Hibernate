package com.hibernate.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;



}
