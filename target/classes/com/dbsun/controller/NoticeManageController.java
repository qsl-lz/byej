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
import  com.dbsun.service.NoticeManageService;
@Api(value = "notice_manage", description = "紧急通知", tags = "紧急通知")
@Controller
@RequestMapping("/notice_manage")
public class NoticeManageController extends BaseController {
@Autowired
private NoticeManageService _service;
/** 获取紧急通知页面 */
@RequestMapping(value = "/NoticeManage", method = RequestMethod.GET)
@ApiOperation(value = "获取紧急通知页面")
public String goNoticeManagePage() {  return ""; }
/**  添加紧急通知 (重复数据不能添加) */
@RequestMapping(value = "/addNoticeManageNo", method = RequestMethod.POST)
@ResponseBody
@ApiOperation(value = "添加紧急通知(重复数据不能添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "title", value = "标题", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "content", value = "内容", required = false, dataType = "text"),
})
public ServerResponse<String> addNoticeManageNo() {
PageData pd =  getPageData();
return _service.addNoticeManageNo(this.putUserPd(pd)); }
/**  添加紧急通知 (重复数据可以添加) */
@RequestMapping(value = "/addNoticeManageAll", method = RequestMethod.POST)
@ResponseBody
@ApiOperation(value = "添加紧急通知(重复数据可以添加)", notes = "添加不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "title", value = "标题", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "content", value = "内容", required = false, dataType = "text"),
})
public ServerResponse<String> addNoticeManageAll() {
PageData pd =  getPageData();
return _service.addNoticeManageAll(this.putUserPd(pd));}
/** 删除紧急通知 */
@RequestMapping(value = "/deleteNoticeManage", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "删除紧急通知", notes = "删除不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "xxx", required = true, dataType = "int"),
})
public ServerResponse<String> deleteNoticeManage() {
PageData pd =  getPageData();
return _service.deleteNoticeManage(pd);}
/** 根据id更新数据 */
@RequestMapping(value = "/updateNoticeManage", method = RequestMethod.POST)
@ResponseBody
@ApiOperation(value = "更新紧急通知", notes = "更新不为空的内容")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "编号", required = true, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "title", value = "标题", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "content", value = "内容", required = false, dataType = "text"),
})
public ServerResponse<String> updateNoticeManage() {
PageData pd =  getPageData();
return _service.updateNoticeManage(pd);}
/** 获取紧急通知数据(非分页,搜索功能) */
@RequestMapping(value = "/queryNoticeManageKey", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取紧急通知数据(非分页,搜索功能)")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "id", value = "编号", required = false, dataType = "int"),
@ApiImplicitParam(paramType = "query", name = "title", value = "标题", required = false, dataType = "varchar"),
@ApiImplicitParam(paramType = "query", name = "content", value = "内容", required = false, dataType = "text"),
@ApiImplicitParam(paramType = "query", name = "create_time", value = "创建时间", required = false, dataType = "varchar"),
})
public ServerResponse<List<PageData>> queryNoticeManageKey() {
PageData pd = this.getPageData();
return _service.queryNoticeManageKey(pd);}
/** 获取紧急通知列表数据 */
@RequestMapping(value = "/queryPageNoticeManageKeyList", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value = "获取紧急通知列表数据", notes = "分页")
@ApiImplicitParams({
@ApiImplicitParam(paramType = "query", name = "showCount", value = "每页记录数", dataType = "String"),
@ApiImplicitParam(paramType = "query", name = "currentPage", value = "当前页", required = true, dataType = "String"),
})
public JSONObject queryPageNoticeManageKeyList() {
PageData pd = getPageData();
Page page = getPage();
page.setPd(pd);
List<PageData> systemUserList = null;
try {
systemUserList = _service.queryPageNoticeManageKeyList(page);
} catch (Exception e) {
e.printStackTrace();}
return viewReturnPageData(page, systemUserList);
}
}
