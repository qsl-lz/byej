package com.dbsun.service;

import com.dbsun.common.ServerResponse;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import com.dbsun.mapper.AppTiWenMapper;
import com.dbsun.service.BaseService;
import com.dbsun.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppTiWenService extends BaseService {
    @Autowired
    private AppTiWenMapper _mapper;

    /**
     * 添加体温管理 重复数据不能添加
     */
    @Transactional
    public ServerResponse<String> addAppTiWenNo(PageData pd) {
        if (Tools.isObjEmpty(pd)) {
            return ServerResponse.createByErrorMessage("删除体温管理参数错误");
        }
        List<PageData> list = _mapper.queryAppTiWenKey(pd);
        if (list.size() > 0) return ServerResponse.createByErrorMessage("体温管理已存在");
        int rowCount = _mapper.addAppTiWen(pd);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加体温管理成功");
        }
        return ServerResponse.createByErrorMessage("添加体温管理失败");
    }

    /**
     * 添加体温管理 重复数据可以添加
     */
    @Transactional
    public ServerResponse<String> addAppTiWenAll(PageData pd) {
        int rowCount = _mapper.addAppTiWen(pd);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加体温管理成功");
        }
        return ServerResponse.createByErrorMessage("添加体温管理失败");
    }

    /**
     * 根据id删除体温管理数据
     */
    public ServerResponse<String> deleteAppTiWen(PageData pd) {
        if (Tools.isObjEmpty(pd.get("id"))) {
            return ServerResponse.createByErrorMessage("删除体温管理参数错误");
        }
        int rowCount = _mapper.deleteAppTiWenId(pd);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("删除体温管理成功");
        }
        return ServerResponse.createByErrorMessage("删除体温管理失败");
    }

    /**
     * 根据id更新体温管理数据
     */
    @Transactional
    public ServerResponse<String> updateAppTiWen(PageData pd) {
        if (Tools.isEmpty(pd.getString("id"))) {
            return ServerResponse.createByErrorMessage("修改体温管理参数错误");
        }
        int rowCount = _mapper.updateAppTiWen(pd);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("修改体温管理成功");
        }
        return ServerResponse.createByErrorMessage("修改体温管理失败");
    }

    /**
     * 获取体温管理数据(非分页,搜索功能)
     */
    public ServerResponse<List<PageData>> queryAppTiWenKey(PageData pd) {
        if (Tools.isObjEmpty(pd)) {
            return ServerResponse.badArgument();
        }
        List<PageData> list = _mapper.queryAppTiWenKey(pd);
        return ServerResponse.createBySuccess(list);
    }

    /**
     * 获取体温管理列表数据 分页
     */
    public List<PageData> queryPageAppTiWenKeyList(Page pd) {
        List<PageData> list = _mapper.queryPageAppTiWenKeyList(pd);
        return list;
    }
}
