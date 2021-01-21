package io.vimero.sovio.api.resource;

import java.util.ArrayList;
import java.util.Collection;

public class EvaluationListResource extends ArrayList<GroupListResource> {

    public EvaluationListResource(Collection<? extends  GroupListResource> values){
        super(values);
    }

}
