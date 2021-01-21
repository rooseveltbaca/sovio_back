package io.vimero.sovio.api.rest;

import io.vimero.sovio.api.data.PersonData;
import io.vimero.sovio.api.resource.RegisterParams;
import io.vimero.sovio.api.resource.TypeList;
import io.vimero.sovio.api.resource.TypeResource;
import io.vimero.sovio.service.ConfigurationService;
import io.vimero.sovio.service.PersonService;
import io.vimero.web.DataResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@AllArgsConstructor
public class OnBoardController {

    private final ConfigurationService configurationService;
    private final PersonService personService;

    @GetMapping("/onboard/parameters")
    public ResponseEntity<RegisterParams> findParameters() {
        RegisterParams params = configurationService.getRegisterParams();
        params.setCountries(new TypeList(Arrays.asList(new TypeResource(1, "Perú"),
                new TypeResource(2, "Argentina"))));

        params.setDisabilities(new TypeList(Arrays.asList(new TypeResource(1, "Auditiva"),
                new TypeResource(2, "Motora"))));
        return ResponseEntity.ok(params);
    }

    @PostMapping("/onboard/users")
    public void register(@RequestBody PersonData d){
        personService.create(d);
    }

    @GetMapping("/onboard/persons/document/type/{type}/number/{number}")
    public ResponseEntity<DataResponse> register(@PathVariable String type, @PathVariable String number){
        log.info("[GET] /onboard/persons/document/type/{}/number/{}", type, number);
        return ResponseEntity.ok(personService.getDataFromRENIEC(number));
    }

}
