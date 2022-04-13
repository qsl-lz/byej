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
import  com.dbsun.service.ProvinceNumManageService;
@Api(value = "province_num_manage", description = "地图数据管理", tags = "地图数据管理")
@Controller
@RequestMapping("/province_num_manage")
public class ProvinceNumManageController extends BaseController {
@Autowired
private ProvinceNumManageService _service;
/** 获取地图数据管理页面 */
@RequestMapping(value = "/ProvinceNumManage", method = RequestMethod.GET)
@ApiOperation(value = "获取地图数据管理页面")
public String goProvinceNumManagePage() {  return ""; }
/**  添加地图数据管理 (重复数据不能添加) */
@RequestMapping(value = "/addProvinceNumManageNo", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "添加地图数据管理(重复数据不能添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "name", value = "省份", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "value", value = "人数", required = false, dataType = "int"),
})
public ServerResponse<String> addProvinceNumManageNo() {
PageData pd =  getPageData();
return _service.addProvinceNumManageNo(this.putUserPd(pd)); }
/**  添加地图数据管理 (重复数据可以添加) */
@RequestMapping(value = "/addProvinceNumManageAll", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "添加地图数据管理(重复数据可以添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "name", value = "省份", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "value", value = "人数", required = false, dataType = "int"),
})
public ServerResponse<String> addProvinceNumManageAll() {
PageData pd =  getPageData();
return _service.addProvinceNumManageAll(this.putUserPd(pd));}
/** 删除地图数据管理 */
@RequestMapping(value = "/deleteProvinceNumManage", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "删除地图数据管理", notes = "删除不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "xxx", required = true, dataType = "int"),
})
public ServerResponse<String> deleteProvinceNumManage() {
PageData pd =  getPageData();
return _service.deleteProvinceNumManage(pd);}
/** 根据id更新数据 */
@RequestMapping(value = "/updateProvinceNumManage", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "更新地图数据管理", notes = "更新不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "编号", required = true, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "name", value = "省份", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "value", value = "人数", required = false, dataType = "int"),
})
public ServerResponse<String> updateProvinceNumManage() {
PageData pd =  getPageData();
return _service.updateProvinceNumManage(pd);}
/** 获取地图数据管理数据(非分页,搜索功能) */
@RequestMapping(value = "/queryProvinceNumManageKey", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取地图数据管理数据(非分页,搜索功能)")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "编号", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "name", value = "省份", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "value", value = "人数", required = false, dataType = "int"),
})
public ServerResponse<List<PageData>> queryProvinceNumManageKey() {
PageData pd = this.getPageData();
return _service.queryProvinceNumManageKey(pd);}
/** 获取地图数据管理列表数据 */
@RequestMapping(value = "/queryPageProvinceNumManageKeyList", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取地图数据管理列表数据", notes = "分页")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "showCount", value = "每页记录数", dataType = "String"),
@ApiImplicitParam(paramType = "query", name = "currentPage", value = "当前页", required = true, dataType = "String"),
})
public JSONObject queryPageProvinceNumManageKeyList() {
PageData pd = getPageData();
Page page = getPage();
page.setPd(pd);
List<PageData> systemUserList = null;
try {
systemUserList = _service.queryPageProvinceNumManageKeyList(page);
} catch (Exception e) {
e.printStackTrace();}
return viewReturnPageData(page, systemUserList);
}
}
