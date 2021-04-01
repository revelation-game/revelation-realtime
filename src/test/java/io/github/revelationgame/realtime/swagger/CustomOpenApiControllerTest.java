package io.github.revelationgame.game.swagger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomOpenApiControllerTest {

    @Mock
    private CustomOpenApiService customOpenApiService;

    @InjectMocks
    private CustomOpenApiController customOpenApiController;

    @Test
    void getOpenApi() {
        when(customOpenApiService.getDefinitionWithServer("url")).thenReturn("result");

        assertThat(customOpenApiController.getOpenApi("url")).isEqualTo("result");
    }
}