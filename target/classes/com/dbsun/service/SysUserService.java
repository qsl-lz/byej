package com.dbsun.service;

import com.dbsun.common.ServerResponse;
import com.dbsun.entity.system.PageData;
import com.dbsun.mapper.SysUserMapper;
import com.dbsun.util.Tools;
import org.springframework.stereotype.Service;

import javax.tools.Tool;

@Service
public class SysUserService {

    private final SysUserMapper sysuserMapper;

    public SysUserService(SysUserMapper sysuserMapper) {
        this.sysuserMapper = sysuserMapper;
    }

    /**
     * 验证用户账号及密码是否存在
     */
    public PageData getLoginValidation(PageData pd) {
        return sysuserMapper.getLoginValidation(pd);
    }


    public ServerResponse registerUser(PageData pd) {

        if(Tools.isEmpty(pd.getString("USERNAME")) || Tools.isEmpty(pd.getString("PASSWORD"))){
           return ServerResponse.badArgument();
        }

        final PageData pageData = new PageData();
        pageData.put("USERNAME", pd.getString("USERNAME"));
        pageData.put("luck", true);
        final PageData systemUserByColumn = sysuserMapper.getSystemUserByColumn(pageData);

        if(!Tools.isObjEmpty(systemUserByColumn)){
            return ServerResponse.createByErrorMessage("该用户已存在");
        }

        final int i = sysuserMapper.addSystemUser(pd);

        if(i > 0)return ServerResponse.createBySuccessMessage("注册成功");

        return ServerResponse.createByErrorMessage("注册失败");
    }


}
