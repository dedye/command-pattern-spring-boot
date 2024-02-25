package com.doku.wallet.services;

import reactor.core.publisher.Mono;
import javax.servlet.http.HttpServletRequest;

public interface Command<RESULT, REQUEST extends HttpServletRequest> {
    Mono<RESULT> execute(REQUEST request);
}
