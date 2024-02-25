package com.doku.wallet.services;

import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

public interface ServiceExecutor {
    <T, R extends HttpServletRequest> Mono<T> execute(Class<? extends Command<T, R>> commandClass, R request);
}
