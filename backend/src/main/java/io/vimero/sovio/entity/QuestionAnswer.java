package io.vimero.sovio.entity;


import io.vimero.persistence.SequenceEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TSOVTBC_MARCADO")
@AttributeOverride(name = "id", column = @Column(name = "N_MARCADOID"))
@SequenceGenerator(name = "seq_superclass", sequenceName = "SEQ_N_MARCADOID", allocationSize = 1)
public class QuestionAnswer extends SequenceEntity<Long> {

    @Column(name = "N_PREGUNTAID")
    private Long question;

    @Column(name = "N_RESPUESTAID")
    private Long answer;

    @Column(name = "N_USUARIOID")
    private Long user;

}
