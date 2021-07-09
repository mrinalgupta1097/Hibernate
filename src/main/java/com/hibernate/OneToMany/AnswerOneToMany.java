package com.hibernate.OneToMany;

import com.hibernate.OneToOne.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerOneToMany {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToOne //In one to many side  normally many side is the one which is the owner of the relation
    private QuestionOneToMany question;
}
