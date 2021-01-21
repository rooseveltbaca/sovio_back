package io.vimero.sovio.api.rest;

import io.vimero.ms.crud.APIRest;
import io.vimero.sovio.api.data.TestData;
import io.vimero.sovio.entity.Test;
import io.vimero.sovio.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/tests")
public class TestController extends APIRest<Test, Long, TestData, TestService> {

    public TestController(TestService service) {
        super(service);
    }

}
