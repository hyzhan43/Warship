package com.hy.zhan.springbootwarship.service.impl;

import com.hy.zhan.springbootwarship.Fire;
import com.hy.zhan.springbootwarship.dto.LoginDTO;
import com.hy.zhan.springbootwarship.exception.CommonErrorCode;
import com.hy.zhan.springbootwarship.service.LoginService;
import com.hy.zhan.springbootwarship.vo.LoginVO;
import org.springframework.stereotype.Service;

/**
 * author :  HyJame
 * date  :   2020/4/1
 * desc :    tell me what
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        Fire.error(CommonErrorCode.HTTP_METHOD_ERROR);

        return null;
    }
}
