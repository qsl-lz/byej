package com.dbsun.controller;

import com.dbsun.base.BaseController;
import com.dbsun.common.ServerResponse;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.dbsun.service.AppTiWenService;

@Api(value = "app_ti_wen", description = "体温管理", tags = "体温管理")
@Controller
@RequestMapping("/app_ti_wen")
public class AppTiWenController extends BaseController {
    @Autowired
    private AppTiWenService _service;

    /**
     * 获取体温管理页面
     */
    @RequestMapping(value = "/AppTiWen", method = RequestMethod.GET)
    @ApiOperation(value = "获取体温管理页面")
    public String goAppTiWenPage() {
        return "";
    }

    /**
     * 添加体温管理 (重复数据不能添加)
     */
    @RequestMapping(value = "/addAppTiWenNo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "添加体温管理(重复数据不能添加)", notes = "添加不为空的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "u_id", value = "用户id", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_name", value = "体温", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_time", value = "体温添加时间", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_note", value = "体温备注", required = false, dataType = "varchar"),
    })
    public ServerResponse<String> addAppTiWenNo() {
        PageData pd = getPageData();
        return _service.addAppTiWenNo(this.putUserPd(pd));
    }

    /**
     * 添加体温管理 (重复数据可以添加)
     */
    @RequestMapping(value = "/addAppTiWenAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "添加体温管理(重复数据可以添加)", notes = "添加不为空的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "u_id", value = "用户id", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_name", value = "体温", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_time", value = "体温添加时间", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_note", value = "体温备注", required = false, dataType = "varchar"),
    })
    public ServerResponse<String> addAppTiWenAll() {
        PageData pd = getPageData();
        return _service.addAppTiWenAll(this.putUserPd(pd));
    }

    /**
     * 删除体温管理
     */
    @RequestMapping(value = "/deleteAppTiWen", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除体温管理", notes = "删除不为空的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "xxx", required = true, dataType = "int"),
    })
    public ServerResponse<String> deleteAppTiWen() {
        PageData pd = getPageData();
        return _service.deleteAppTiWen(pd);
    }

    /**
     * 根据id更新数据
     */
    @RequestMapping(value = "/updateAppTiWen", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "更新体温管理", notes = "更新不为空的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "主键id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "u_id", value = "用户id", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_name", value = "体温", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_time", value = "体温添加时间", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_note", value = "体温备注", required = false, dataType = "varchar"),
    })
    public ServerResponse<String> updateAppTiWen() {
        PageData pd = getPageData();
        return _service.updateAppTiWen(pd);
    }

    /**
     * 获取体温管理数据(非分页,搜索功能)
     */
    @RequestMapping(value = "/queryAppTiWenKey", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取体温管理数据(非分页,搜索功能)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "主键id", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "u_id", value = "用户id", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_name", value = "体温", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_time", value = "体温添加时间", required = false, dataType = "varchar"),
            @ApiImplicitParam(paramType = "query", name = "tw_note", value = "体温备注", required = false, dataType = "varchar"),
    })
    public ServerResponse<List<PageData>> queryAppTiWenKey() {
        PageData pd = this.getPageData();
        return _service.queryAppTiWenKey(pd);
    }

    /**
     * 获取体温管理列表数据
     */
    @RequestMapping(value = "/queryPageAppTiWenKeyList", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取体温管理列表数据", notes = "分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "showCount", value = "每页记录数", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "currentPage", value = "当前页", required = true, dataType = "String"),
    })
    public JSONObject queryPageAppTiWenKeyList() {
        PageData pd = getPageData();
        Page page = getPage();
        page.setPd(pd);
        List<PageData> systemUserList = null;
        try {
            systemUserList = _service.queryPageAppTiWenKeyList(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewReturnPageData(page, systemUserList);
    }
}
