package io.github.revelationgame.game.swagger;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom-open-api")
@AllArgsConstructor
@Hidden
public class CustomOpenApiController {

    private CustomOpenApiService service;

    @GetMapping(value = "/v3/api-docs", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOpenApi(@RequestParam(value = "serverUrl") String serverUrl) {
        return service.getDefinitionWithServer(serverUrl);
    }

}
