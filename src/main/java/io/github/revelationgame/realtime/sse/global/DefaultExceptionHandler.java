package io.github.revelationgame.realtime.sse.global;

import io.github.revelationgame.realtime.sse.i18n.I18nErrorMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException e, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {

        I18nErrorMessageDto dto = new I18nErrorMessageDto(GlobalMessages.REALTIME_PARAMETER_BODY_FAILED);
        return new ResponseEntity<>(dto, status);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    I18nErrorMessageDto handleUnknownException(Exception e) {
        log.error("An unexpected exception occurred", e);

        return new I18nErrorMessageDto(GlobalMessages.REALTIME_UNEXPECTED_EXCEPTION);
    }


}
