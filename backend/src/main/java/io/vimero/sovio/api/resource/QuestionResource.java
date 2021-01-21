package io.vimero.sovio.api.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResource {

    private String id;
    private String title;
    private String description;
    private String sequence;
    private BigDecimal order;
    private String type;
    private String response;
    private String imageUrl;

    private List<AnswerResource> answers;

}
