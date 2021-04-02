package io.github.revelationgame.realtime.sse.i18n;

import lombok.Getter;

@Getter
public abstract class I18nException extends RuntimeException {

    private final I18nErrorMessageDto i18nErrorMessageDto;

    protected I18nException(I18nMessage i18nMessage, Object... placeHolders) {
        this.i18nErrorMessageDto = new I18nErrorMessageDto(i18nMessage, placeHolders);
    }

    protected I18nException(String message, I18nMessage i18nMessage, Object... placeHolders) {
        super(message);
        this.i18nErrorMessageDto = new I18nErrorMessageDto(i18nMessage, placeHolders);
    }

    protected I18nException(String message, Throwable cause, I18nMessage i18nMessage, Object... placeHolders) {
        super(message, cause);
        this.i18nErrorMessageDto = new I18nErrorMessageDto(i18nMessage, placeHolders);
    }

    protected I18nException(Throwable cause, I18nMessage i18nMessage, Object... placeHolders) {
        super(cause);
        this.i18nErrorMessageDto = new I18nErrorMessageDto(i18nMessage, placeHolders);
    }

    protected I18nException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, I18nMessage i18nMessage, Object... placeHolders) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.i18nErrorMessageDto = new I18nErrorMessageDto(i18nMessage, placeHolders);
    }
}
