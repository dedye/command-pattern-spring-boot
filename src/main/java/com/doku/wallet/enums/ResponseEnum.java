package com.doku.wallet.enums;

import com.doku.wallet.constants.MessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SUCCESS("0000", MessageConstant.SUCCESS,"Success",HttpStatus.OK);

    private String code;
    private String type;
    private String detail;
    private HttpStatus httpStatus;
}
