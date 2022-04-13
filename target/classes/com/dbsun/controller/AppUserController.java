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
import  com.dbsun.service.AppUserService;
@Api(value = "app_user", description = "用户管理", tags = "用户管理")
@Controller
@RequestMapping("/app_user")
public class AppUserController extends BaseController {
@Autowired
private AppUserService _service;
/** 获取用户管理页面 */
@RequestMapping(value = "/AppUser", method = RequestMethod.GET)
@ApiOperation(value = "获取用户管理页面")
public String goAppUserPage() {  return ""; }
/**  添加用户管理 (重复数据不能添加) */
@RequestMapping(value = "/addAppUserNo", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "添加用户管理(重复数据不能添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "username", value = "账号", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "nickname", value = "昵称", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "signature", value = "个性签名", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "is_yc", value = "是否异常", required = false, dataType = "int"),
})
public ServerResponse<String> addAppUserNo() {
PageData pd =  getPageData();
return _service.addAppUserNo(this.putUserPd(pd)); }
/**  添加用户管理 (重复数据可以添加) */
@RequestMapping(value = "/addAppUserAll", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "添加用户管理(重复数据可以添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "username", value = "账号", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "nickname", value = "昵称", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "signature", value = "个性签名", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "is_yc", value = "是否异常", required = false, dataType = "int"),
})
public ServerResponse<String> addAppUserAll() {
PageData pd =  getPageData();
return _service.addAppUserAll(this.putUserPd(pd));}
/** 删除用户管理 */
@RequestMapping(value = "/deleteAppUser", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "删除用户管理", notes = "删除不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "xxx", required = true, dataType = "int"),
})
public ServerResponse<String> deleteAppUser() {
PageData pd =  getPageData();
return _service.deleteAppUser(pd);}
/** 根据id更新数据 */
@RequestMapping(value = "/updateAppUser", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "更新用户管理", notes = "更新不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "主键id", required = true, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "username", value = "账号", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "nickname", value = "昵称", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "signature", value = "个性签名", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "is_yc", value = "是否异常", required = false, dataType = "int"),
})
public ServerResponse<String> updateAppUser() {
PageData pd =  getPageData();
return _service.updateAppUser(pd);}
/** 获取用户管理数据(非分页,搜索功能) */
@RequestMapping(value = "/queryAppUserKey", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取用户管理数据(非分页,搜索功能)")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "主键id", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "username", value = "账号", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "nickname", value = "昵称", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "signature", value = "个性签名", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "is_yc", value = "是否异常", required = false, dataType = "int"),
})
public ServerResponse<List<PageData>> queryAppUserKey() {
PageData pd = this.getPageData();
return _service.queryAppUserKey(pd);}
/** 获取用户管理列表数据 */
@RequestMapping(value = "/queryPageAppUserKeyList", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取用户管理列表数据", notes = "分页")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "showCount", value = "每页记录数", dataType = "String"),
@ApiImplicitParam(paramType = "query", name = "currentPage", value = "当前页", required = true, dataType = "String"),
})
public JSONObject queryPageAppUserKeyList() {
PageData pd = getPageData();
Page page = getPage();
page.setPd(pd);
List<PageData> systemUserList = null;
try {
systemUserList = _service.queryPageAppUserKeyList(page);
} catch (Exception e) {
e.printStackTrace();}
return viewReturnPageData(page, systemUserList);
}
}
