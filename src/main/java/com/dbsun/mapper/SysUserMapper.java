package com.dbsun.mapper;

import com.dbsun.entity.system.PageData;

public interface SysUserMapper {

    /**
     * 验证用户账号及密码是否存在
     */
    PageData getLoginValidation(PageData pd);

    int addSystemUser(PageData pd);

    PageData getSystemUserByColumn(PageData pd);

}
