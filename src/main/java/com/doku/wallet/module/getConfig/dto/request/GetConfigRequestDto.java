package com.doku.wallet.module.getConfig.dto.request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetConfigRequestDto {
    private String accountId;
    private String token;
    private String configKey;
    private String tokenKey;
    private String words;
    private String version;
}
