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
class OpenApiFacadeTest {

    @Mock
    private LocalOpenApiClient localOpenApiClient;

    @InjectMocks
    private OpenApiFacade openApiFacade;

    @Test
    void getLocalOpenApiDefinition() {
        when(localOpenApiClient.getLocalOpenApi()).thenReturn("Test");

        assertThat(openApiFacade.getLocalOpenApiDefinition()).isEqualTo("Test");
    }
}