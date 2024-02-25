package com.doku.wallet.module.getConfig.controller;

import com.doku.wallet.module.getConfig.dto.response.GetConfigResponseDto;
import com.doku.wallet.services.ServiceExecutor;
import com.doku.wallet.module.getConfig.services.GetConfigRequestServiceCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(value = "apprequest/")
public class GetConfigController {

    @Autowired
    private ServiceExecutor serviceExecutor;

    @PostMapping("/getConfig")
    public Mono<GetConfigResponseDto> getConfig(HttpServletRequest reguest) {
        return serviceExecutor.execute(GetConfigRequestServiceCommand.class, reguest)
                .map(response -> response)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
