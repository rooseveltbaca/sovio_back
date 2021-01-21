package io.vimero.sovio.api.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupResource {

    protected String sequence;
    protected String name;
    protected String instruction;
    protected Object time;
    protected Object order;
    protected String type;

}
