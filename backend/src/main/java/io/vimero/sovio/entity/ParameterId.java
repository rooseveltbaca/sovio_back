package io.vimero.sovio.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ParameterId implements Serializable {

    private Integer id;
    private Integer table;

}
