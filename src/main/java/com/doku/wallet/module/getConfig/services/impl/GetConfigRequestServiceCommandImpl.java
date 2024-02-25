package com.doku.wallet.module.getConfig.services.impl;

import com.doku.wallet.module.getConfig.dto.request.GetConfigRequestDto;
import com.doku.wallet.module.getConfig.dto.response.GetConfigDetailResponseDto;
import com.doku.wallet.module.getConfig.dto.response.GetConfigResponseDto;
import com.doku.wallet.services.AbstractCommand;
import com.doku.wallet.module.getConfig.services.GetConfigRequestServiceCommand;
import com.doku.wallet.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class GetConfigRequestServiceCommandImpl extends AbstractCommand<GetConfigResponseDto, HttpServletRequest> implements GetConfigRequestServiceCommand {

    @Autowired
    private JsonUtils jsonUtils;

    @SneakyThrows
    @Override
    public Mono<GetConfigResponseDto> doExecute(HttpServletRequest request) {
        String dataReg = jsonUtils.convertJson(request);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        GetConfigRequestDto getConfigRequestDto = mapper.readValue(dataReg, GetConfigRequestDto.class);

        GetConfigDetailResponseDto getConfigDetailResponseDto1 = new GetConfigDetailResponseDto();
        getConfigDetailResponseDto1.setKey("apps.fresh-chat.app-id");
        getConfigDetailResponseDto1.setValue("evau0vIpPy1FbeioHPHk2AH/6bI74FvkJq/Gz+h9qVPKZGTHPg8ZIPDhxxCo6U2E");
        GetConfigDetailResponseDto getConfigDetailResponseDto2 = new GetConfigDetailResponseDto();
        getConfigDetailResponseDto2.setKey("apps.fresh-chat.app-key");
        getConfigDetailResponseDto2.setValue("ZpBdt/J/PbiHgheYr9zA8gyXOjhsrICjR/Jk99/gnWm0lUAmVTTkFuKWI8faq9/J");

        List<GetConfigDetailResponseDto> addConf = new ArrayList<>();
        addConf.add(getConfigDetailResponseDto1);
        addConf.add(getConfigDetailResponseDto2);

        GetConfigResponseDto dataRequest = GetConfigResponseDto.builder()
                .responseCode("0000")
                .responseMsg("Berhasil")
                .configuration(addConf)
                .build();
        return Mono.just(dataRequest);
    }
}
