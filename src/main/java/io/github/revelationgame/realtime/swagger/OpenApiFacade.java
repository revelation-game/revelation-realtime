package io.github.revelationgame.game.swagger;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OpenApiFacade {

    private final LocalOpenApiClient localOpenApiClient;

    public String getLocalOpenApiDefinition() {
        return localOpenApiClient.getLocalOpenApi();
    }
}
