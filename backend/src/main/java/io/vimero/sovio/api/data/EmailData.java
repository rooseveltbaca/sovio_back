package io.vimero.sovio.api.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailData {

    private String to;
    private String title;
    private String body;

}
