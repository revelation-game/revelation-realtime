package io.github.revelationgame.realtime.swagger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomOpenApiServiceTest {

    @Mock
    private OpenApiFacade openApiFacade;

    @InjectMocks
    private CustomOpenApiService customOpenApiService;

    @Test
    void getDefinitionWithServer() {
        when(openApiFacade.getLocalOpenApiDefinition()).thenReturn("{\"servers\":[{\"url\":\"someUrl\"},{\"url\":\"someOtherUrl\"}]}");

        String actual = customOpenApiService.getDefinitionWithServer("newServerUrl");

        assertThat(actual).isEqualTo("{\"servers\":[{\"url\":\"newServerUrl\"},{\"url\":\"newServerUrl\"}]}");
    }
}