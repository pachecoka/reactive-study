package com.study.webflux.web;


import com.mongodb.MongoException;
import com.study.webflux.web.responses.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Log4j2
public class PetExceptionHandler {

    @ExceptionHandler(MongoException.class)
    public Mono<ResponseEntity<Object>> handleMongoException(MongoException ex) {
        log.error("MongoException: {}", ex.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(ex.getMessage(), null)));
    }

}
