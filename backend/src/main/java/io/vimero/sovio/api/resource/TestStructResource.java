package io.vimero.sovio.api.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TestStructResource {

    private Long id;
    private Map<String, List<QuestionResource>> groups;

}
