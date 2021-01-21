package io.vimero.sovio.api.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnswerResource {

    private String id;
    private String title;
    private String description;
    private String sequence;
    private String order;
    private String value;
    private String imageUrl;

}
