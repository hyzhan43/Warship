package com.hy.zhan.springbootwarship.service;

import com.hy.zhan.springbootwarship.dto.LoginDTO;
import com.hy.zhan.springbootwarship.vo.LoginVO;

/**
 * author :  HyJame
 * date  :   2020/4/1
 * desc :    tell me what
 */
public interface LoginService {

    LoginVO login(LoginDTO loginDTO);
}
