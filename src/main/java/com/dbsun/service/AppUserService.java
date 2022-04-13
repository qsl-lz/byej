package com.dbsun.service;
import com.dbsun.common.ServerResponse;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import com.dbsun.mapper.AppUserMapper;
import com.dbsun.service.BaseService;
import com.dbsun.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AppUserService extends BaseService {
@Autowired
private AppUserMapper _mapper;
/**  添加用户管理 重复数据不能添加*/
@Transactional
public ServerResponse<String> addAppUserNo(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.createByErrorMessage("删除用户管理参数错误"); }
List<PageData> list =_mapper.queryAppUserKey(pd);
if(list.size() > 0) return ServerResponse.createByErrorMessage("用户管理已存在");
int rowCount = _mapper.addAppUser(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加用户管理成功"); }
return ServerResponse.createByErrorMessage("添加用户管理失败");}
/**  添加用户管理 重复数据可以添加*/
@Transactional
public ServerResponse<String> addAppUserAll(PageData pd) {
int rowCount = _mapper.addAppUser(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加用户管理成功");  }
return ServerResponse.createByErrorMessage("添加用户管理失败");}
/** 根据id删除用户管理数据 */
public ServerResponse<String> deleteAppUser(PageData pd) {
if(Tools.isObjEmpty(pd.get("id"))){ return ServerResponse.createByErrorMessage("删除用户管理参数错误");  }
int rowCount = _mapper.deleteAppUserId(pd);
if(rowCount > 0){  return ServerResponse.createBySuccessMessage("删除用户管理成功"); }
return ServerResponse.createByErrorMessage("删除用户管理失败");}
/** 根据id更新用户管理数据 */
@Transactional
public ServerResponse<String> updateAppUser(PageData pd) {
if(Tools.isEmpty(pd.getString("id"))){return ServerResponse.createByErrorMessage("修改用户管理参数错误");}
int rowCount = _mapper.updateAppUser(pd);
if(rowCount > 0){return ServerResponse.createBySuccessMessage("修改用户管理成功");}
return ServerResponse.createByErrorMessage("修改用户管理失败"); }
/** 获取用户管理数据(非分页,搜索功能) */
public ServerResponse<List<PageData>> queryAppUserKey(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.badArgument(); }
List<PageData> list=_mapper.queryAppUserKey(pd);
return ServerResponse.createBySuccess(list);}
/** 获取用户管理列表数据 分页*/
 public List<PageData> queryPageAppUserKeyList(Page pd) {
List<PageData> list=_mapper.queryPageAppUserKeyList(pd);
return list;}}
