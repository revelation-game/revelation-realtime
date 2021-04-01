package io.github.revelationgame.realtime.swagger;

import io.github.revelationgame.realtime.IntegrationTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomOpenApiControllerIT extends IntegrationTest {

    @Test
    void getOpenApi() {
        feignClientMock.getJsonStub("/v3/api-docs", readAndNormalize("exampleOpenApiDefinition.json"));

        String actual = restService.get("/custom-open-api/v3/api-docs?serverUrl=greatServer");

        String expected = readAndNormalize("expectedCustomDefinition.json");
        assertThat(actual).isEqualTo(expected);
    }
}
