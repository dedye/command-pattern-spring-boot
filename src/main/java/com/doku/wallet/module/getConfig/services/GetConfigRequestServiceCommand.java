package com.doku.wallet.module.getConfig.services;

import com.doku.wallet.module.getConfig.dto.response.GetConfigResponseDto;
import com.doku.wallet.services.Command;
import javax.servlet.http.HttpServletRequest;

public interface GetConfigRequestServiceCommand extends Command<GetConfigResponseDto, HttpServletRequest> {}
