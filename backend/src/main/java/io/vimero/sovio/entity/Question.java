package io.vimero.sovio.entity;

import io.vimero.persistence.SequenceEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TSOVTBC_PREGUNTA")
@AttributeOverride(name = "id", column = @Column(name = "N_PREGUNTAID"))
@SequenceGenerator(name = "seq_superclass", sequenceName = "SEQ_N_PREGUNTAID", allocationSize = 1)
public class Question extends SequenceEntity<Long> {

}
