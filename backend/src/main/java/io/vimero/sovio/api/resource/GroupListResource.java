package io.vimero.sovio.api.resource;

import io.vimero.sovio.type.TestType;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.EnumMap;

@Getter
@Setter
public class GroupListResource extends GroupResource{

    private EnumMap<TestType, Collection<QuestionResource>> data;

}
