package io.github.revelationgame.game.swagger;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomOpenApiService {

    private OpenApiFacade openApiFacade;

    public String getDefinitionWithServer(String externalUrl) {
        log.info("Starting Get openApi Definition and replace ");
        String original = openApiFacade.getLocalOpenApiDefinition();

        JsonObject parsedDefinition = JsonParser.parseString(original).getAsJsonObject();

        JsonObject updatedDefinition = updateServerUrls(parsedDefinition, externalUrl);

        return updatedDefinition.toString();
    }

    private JsonObject updateServerUrls(JsonObject parsedDefinition, String newUrl) {
        JsonObject copy = parsedDefinition.deepCopy();
        JsonArray servers = copy.getAsJsonArray("servers");

        // Update each key with the new url
        servers.forEach(jsonElement -> jsonElement.getAsJsonObject().addProperty("url", newUrl));

        return copy;
    }
}
