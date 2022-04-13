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
import  com.dbsun.service.AppXingChengService;
@Api(value = "app_xing_cheng", description = "行程管理", tags = "行程管理")
@Controller
@RequestMapping("/app_xing_cheng")
public class AppXingChengController extends BaseController {
@Autowired
private AppXingChengService _service;
/** 获取行程管理页面 */
@RequestMapping(value = "/AppXingCheng", method = RequestMethod.GET)
@ApiOperation(value = "获取行程管理页面")
public String goAppXingChengPage() {  return ""; }
/**  添加行程管理 (重复数据不能添加) */
@RequestMapping(value = "/addAppXingChengNo", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "添加行程管理(重复数据不能添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "u_id", value = "用户id", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "xc_name", value = "行程地名", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "xing_cheng_time", value = "行程时间", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "is_yc", value = "", required = false, dataType = "int"),
})
public ServerResponse<String> addAppXingChengNo() {
PageData pd =  getPageData();
return _service.addAppXingChengNo(this.putUserPd(pd)); }
/**  添加行程管理 (重复数据可以添加) */
@RequestMapping(value = "/addAppXingChengAll", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "添加行程管理(重复数据可以添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "u_id", value = "用户id", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "xc_name", value = "行程地名", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "xing_cheng_time", value = "行程时间", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "is_yc", value = "", required = false, dataType = "int"),
})
public ServerResponse<String> addAppXingChengAll() {
PageData pd =  getPageData();
return _service.addAppXingChengAll(this.putUserPd(pd));}
/** 删除行程管理 */
@RequestMapping(value = "/deleteAppXingCheng", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "删除行程管理", notes = "删除不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "xxx", required = true, dataType = "int"),
})
public ServerResponse<String> deleteAppXingCheng() {
PageData pd =  getPageData();
return _service.deleteAppXingCheng(pd);}
/** 根据id更新数据 */
@RequestMapping(value = "/updateAppXingCheng", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "更新行程管理", notes = "更新不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "主键id", required = true, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "u_id", value = "用户id", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "xc_name", value = "行程地名", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "xing_cheng_time", value = "行程时间", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "is_yc", value = "", required = false, dataType = "int"),
})
public ServerResponse<String> updateAppXingCheng() {
PageData pd =  getPageData();
return _service.updateAppXingCheng(pd);}
/** 获取行程管理数据(非分页,搜索功能) */
@RequestMapping(value = "/queryAppXingChengKey", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取行程管理数据(非分页,搜索功能)")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "主键id", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "u_id", value = "用户id", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "xc_name", value = "行程地名", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "xing_cheng_time", value = "行程时间", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "is_yc", value = "", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "create_time", value = "", required = false, dataType = "varchar"),
})
public ServerResponse<List<PageData>> queryAppXingChengKey() {
PageData pd = this.getPageData();
return _service.queryAppXingChengKey(pd);}
/** 获取行程管理列表数据 */
@RequestMapping(value = "/queryPageAppXingChengKeyList", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取行程管理列表数据", notes = "分页")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "showCount", value = "每页记录数", dataType = "String"),
@ApiImplicitParam(paramType = "query", name = "currentPage", value = "当前页", required = true, dataType = "String"),
})
public JSONObject queryPageAppXingChengKeyList() {
PageData pd = getPageData();
Page page = getPage();
page.setPd(pd);
List<PageData> systemUserList = null;
try {
systemUserList = _service.queryPageAppXingChengKeyList(page);
} catch (Exception e) {
e.printStackTrace();}
return viewReturnPageData(page, systemUserList);
}
}
