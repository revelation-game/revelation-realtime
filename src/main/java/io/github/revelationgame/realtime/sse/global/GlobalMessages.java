package io.github.revelationgame.realtime.sse.global;

import io.github.revelationgame.realtime.sse.i18n.I18nMessage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GlobalMessages implements I18nMessage {

    REALTIME_UNEXPECTED_EXCEPTION("realtime.error.unknown", "An unexpected problem occurred"),
    REALTIME_PARAMETER_BODY_FAILED("realtime.error.request.body.validation.failed", "The supplied parameter is invalid. Please refer to the api documentation");

    private final String key;
    private final String message;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
