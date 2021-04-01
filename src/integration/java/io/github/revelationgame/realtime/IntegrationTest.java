package io.github.revelationgame.realtime;

import io.github.revelationgame.realtime.test_utils.FeignClientMock;
import io.github.revelationgame.realtime.test_utils.RestService;
import org.assertj.core.util.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@ActiveProfiles("test")
@AutoConfigureWireMock(port = 0)
@ContextConfiguration(classes = RealtimeApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:/application-test.yml")
public class IntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(IntegrationTest.class);

    @LocalServerPort
    protected int applicationPort;

    @Autowired
    protected RestService restService;

    @Autowired
    protected FeignClientMock feignClientMock;

    protected String readAndNormalize(String name) {
        URL url = getClass().getResource(name);

        return Files.linesOf(new File(url.getFile()), StandardCharsets.UTF_8).stream()
                .map(String::trim)
                .map(s -> s.replaceAll(": ", ":"))
                .collect(Collectors.joining());
    }


}
