package io.vimero.sovio.api.rest;

import io.vimero.api.EmailAPI;
import io.vimero.sovio.api.data.EmailData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/configurations")
public class ConfigurationController {

    private final EmailAPI emailComponent;

    @PostMapping("/send-email")
    public void findByIdMap(@RequestBody EmailData data) {
        emailComponent.sendPlainText(data.getTo(), data.getTitle(), data.getBody());
    }

}
