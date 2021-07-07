package com.hibernate.OneToOne;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @OneToOne(mappedBy = "answer")
    private Question question;
}
