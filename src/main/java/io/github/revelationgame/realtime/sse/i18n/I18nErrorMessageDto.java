package io.github.revelationgame.realtime.sse.i18n;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class I18nErrorMessageDto implements Serializable {

    private String translationKey;
    private String englishMessage;
    private List<String> placeHolders;

    public I18nErrorMessageDto(I18nMessage message, Object... placeHolders) {
        this.translationKey = message.getKey();
        this.englishMessage = message.getMessage().formatted(placeHolders);
        this.placeHolders = Arrays.stream(placeHolders).map(Object::toString).collect(Collectors.toList());
    }

}
