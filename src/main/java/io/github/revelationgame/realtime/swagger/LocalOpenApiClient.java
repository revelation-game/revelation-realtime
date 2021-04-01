package io.github.revelationgame.game.swagger;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "${spring.application.name}")
public interface LocalOpenApiClient {

    @RequestMapping("/v3/api-docs")
    String getLocalOpenApi();
}
