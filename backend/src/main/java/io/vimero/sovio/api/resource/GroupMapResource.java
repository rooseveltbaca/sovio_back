package io.vimero.sovio.api.resource;

import io.vimero.sovio.type.TestType;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.Map;

@Getter
@Setter
public class GroupMapResource extends GroupResource{

    private EnumMap<TestType, Map<String, QuestionResource>> data;

}
