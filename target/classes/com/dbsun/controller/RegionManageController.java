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
import  com.dbsun.service.RegionManageService;
@Api(value = "region_manage", description = "景区区域管理", tags = "景区区域管理")
@Controller
@RequestMapping("/region_manage")
public class RegionManageController extends BaseController {
@Autowired
private RegionManageService _service;
/** 获取景区区域管理页面 */
@RequestMapping(value = "/RegionManage", method = RequestMethod.GET)
@ApiOperation(value = "获取景区区域管理页面")
public String goRegionManagePage() {  return ""; }
/**  添加景区区域管理 (重复数据不能添加) */
@RequestMapping(value = "/addRegionManageNo", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "添加景区区域管理(重复数据不能添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "name", value = "区域名称", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "a_status", value = "状态（1正常2维修3封闭）", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "a_num", value = "游客数量", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "yc_num", value = "异常游客数量", required = false, dataType = "int"),
})
public ServerResponse<String> addRegionManageNo() {
PageData pd =  getPageData();
return _service.addRegionManageNo(this.putUserPd(pd)); }
/**  添加景区区域管理 (重复数据可以添加) */
@RequestMapping(value = "/addRegionManageAll", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "添加景区区域管理(重复数据可以添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "name", value = "区域名称", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "a_status", value = "状态（1正常2维修3封闭）", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "a_num", value = "游客数量", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "yc_num", value = "异常游客数量", required = false, dataType = "int"),
})
public ServerResponse<String> addRegionManageAll() {
PageData pd =  getPageData();
return _service.addRegionManageAll(this.putUserPd(pd));}
/** 删除景区区域管理 */
@RequestMapping(value = "/deleteRegionManage", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "删除景区区域管理", notes = "删除不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "xxx", required = true, dataType = "int"),
})
public ServerResponse<String> deleteRegionManage() {
PageData pd =  getPageData();
return _service.deleteRegionManage(pd);}
/** 根据id更新数据 */
@RequestMapping(value = "/updateRegionManage", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "更新景区区域管理", notes = "更新不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "编号", required = true, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "name", value = "区域名称", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "a_status", value = "状态（1正常2维修3封闭）", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "a_num", value = "游客数量", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "yc_num", value = "异常游客数量", required = false, dataType = "int"),
})
public ServerResponse<String> updateRegionManage() {
PageData pd =  getPageData();
return _service.updateRegionManage(pd);}
/** 获取景区区域管理数据(非分页,搜索功能) */
@RequestMapping(value = "/queryRegionManageKey", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取景区区域管理数据(非分页,搜索功能)")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "编号", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "name", value = "区域名称", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "a_status", value = "状态（1正常2维修3封闭）", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "a_num", value = "游客数量", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "yc_num", value = "异常游客数量", required = false, dataType = "int"),
})
public ServerResponse<List<PageData>> queryRegionManageKey() {
PageData pd = this.getPageData();
return _service.queryRegionManageKey(pd);}
/** 获取景区区域管理列表数据 */
@RequestMapping(value = "/queryPageRegionManageKeyList", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取景区区域管理列表数据", notes = "分页")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "showCount", value = "每页记录数", dataType = "String"),
@ApiImplicitParam(paramType = "query", name = "currentPage", value = "当前页", required = true, dataType = "String"),
})
public JSONObject queryPageRegionManageKeyList() {
PageData pd = getPageData();
Page page = getPage();
page.setPd(pd);
List<PageData> systemUserList = null;
try {
systemUserList = _service.queryPageRegionManageKeyList(page);
} catch (Exception e) {
e.printStackTrace();}
return viewReturnPageData(page, systemUserList);
}
}
