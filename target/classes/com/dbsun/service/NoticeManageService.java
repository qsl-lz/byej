package com.dbsun.service;
import com.dbsun.common.ServerResponse;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import com.dbsun.mapper.NoticeManageMapper;
import com.dbsun.service.BaseService;
import com.dbsun.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class NoticeManageService extends BaseService {
@Autowired
private NoticeManageMapper _mapper;
/**  添加紧急通知 重复数据不能添加*/
@Transactional
public ServerResponse<String> addNoticeManageNo(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.createByErrorMessage("删除紧急通知参数错误"); }
List<PageData> list =_mapper.queryNoticeManageKey(pd);
if(list.size() > 0) return ServerResponse.createByErrorMessage("紧急通知已存在");
int rowCount = _mapper.addNoticeManage(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加紧急通知成功"); }
return ServerResponse.createByErrorMessage("添加紧急通知失败");}
/**  添加紧急通知 重复数据可以添加*/
@Transactional
public ServerResponse<String> addNoticeManageAll(PageData pd) {
int rowCount = _mapper.addNoticeManage(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加紧急通知成功");  }
return ServerResponse.createByErrorMessage("添加紧急通知失败");}
/** 根据id删除紧急通知数据 */
public ServerResponse<String> deleteNoticeManage(PageData pd) {
if(Tools.isObjEmpty(pd.get("id"))){ return ServerResponse.createByErrorMessage("删除紧急通知参数错误");  }
int rowCount = _mapper.deleteNoticeManageId(pd);
if(rowCount > 0){  return ServerResponse.createBySuccessMessage("删除紧急通知成功"); }
return ServerResponse.createByErrorMessage("删除紧急通知失败");}
/** 根据id更新紧急通知数据 */
@Transactional
public ServerResponse<String> updateNoticeManage(PageData pd) {
if(Tools.isEmpty(pd.getString("id"))){return ServerResponse.createByErrorMessage("修改紧急通知参数错误");}
int rowCount = _mapper.updateNoticeManage(pd);
if(rowCount > 0){return ServerResponse.createBySuccessMessage("修改紧急通知成功");}
return ServerResponse.createByErrorMessage("修改紧急通知失败"); }
/** 获取紧急通知数据(非分页,搜索功能) */
public ServerResponse<List<PageData>> queryNoticeManageKey(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.badArgument(); }
List<PageData> list=_mapper.queryNoticeManageKey(pd);
return ServerResponse.createBySuccess(list);}
/** 获取紧急通知列表数据 分页*/
 public List<PageData> queryPageNoticeManageKeyList(Page pd) {
List<PageData> list=_mapper.queryPageNoticeManageKeyList(pd);
return list;}}
