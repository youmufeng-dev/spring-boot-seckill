package com.itstyle.seckill.tuomin;

import lombok.Data;

/**
 * @Author: qiyu
 * @Date: 2020/9/12 8:36 下午
 * @Description:
 */
@Data
public class User {

    private String account;

    private String idCardNo;

    @Desensitized(type = SensitiveTypeEnum.MOBILE_PHONE)
    private String mobileNo;

    private String password;

    private String realName;

}
