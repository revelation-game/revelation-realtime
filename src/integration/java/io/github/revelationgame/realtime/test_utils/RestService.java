package io.github.revelationgame.realtime.test_utils;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestService {

    private final TestRestTemplate restTemplate;

    public RestService(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String get(String url) {
        return restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
    }

    public <T> ResponseEntity<T> post(String s, Object body, Class<T> clazz) {
        HttpEntity<?> httpEntity = new HttpEntity<>(body, null);
        return restTemplate.exchange(s, HttpMethod.POST, httpEntity, clazz);
    }
}
