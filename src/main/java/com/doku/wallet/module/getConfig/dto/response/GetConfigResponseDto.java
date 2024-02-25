package com.doku.wallet.module.getConfig.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class GetConfigResponseDto {
    private String responseCode;
    private String responseMsg;
    private List<GetConfigDetailResponseDto> configuration;
}

