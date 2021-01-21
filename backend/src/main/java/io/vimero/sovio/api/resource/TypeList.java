package io.vimero.sovio.api.resource;

import java.util.ArrayList;
import java.util.Collection;

public class TypeList extends ArrayList<TypeResource>{

    public TypeList(){
        super();
    }
    public TypeList(Collection<? extends TypeResource> c) {
        super(c);
    }

}
