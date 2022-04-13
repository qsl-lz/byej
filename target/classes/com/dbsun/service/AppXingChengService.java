package com.dbsun.service;
import com.dbsun.common.ServerResponse;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import com.dbsun.mapper.AppXingChengMapper;
import com.dbsun.service.BaseService;
import com.dbsun.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AppXingChengService extends BaseService {
@Autowired
private AppXingChengMapper _mapper;
/**  添加行程管理 重复数据不能添加*/
@Transactional
public ServerResponse<String> addAppXingChengNo(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.createByErrorMessage("删除行程管理参数错误"); }
List<PageData> list =_mapper.queryAppXingChengKey(pd);
if(list.size() > 0) return ServerResponse.createByErrorMessage("行程管理已存在");
int rowCount = _mapper.addAppXingCheng(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加行程管理成功"); }
return ServerResponse.createByErrorMessage("添加行程管理失败");}
/**  添加行程管理 重复数据可以添加*/
@Transactional
public ServerResponse<String> addAppXingChengAll(PageData pd) {
int rowCount = _mapper.addAppXingCheng(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加行程管理成功");  }
return ServerResponse.createByErrorMessage("添加行程管理失败");}
/** 根据id删除行程管理数据 */
public ServerResponse<String> deleteAppXingCheng(PageData pd) {
if(Tools.isObjEmpty(pd.get("id"))){ return ServerResponse.createByErrorMessage("删除行程管理参数错误");  }
int rowCount = _mapper.deleteAppXingChengId(pd);
if(rowCount > 0){  return ServerResponse.createBySuccessMessage("删除行程管理成功"); }
return ServerResponse.createByErrorMessage("删除行程管理失败");}
/** 根据id更新行程管理数据 */
@Transactional
public ServerResponse<String> updateAppXingCheng(PageData pd) {
if(Tools.isEmpty(pd.getString("id"))){return ServerResponse.createByErrorMessage("修改行程管理参数错误");}
int rowCount = _mapper.updateAppXingCheng(pd);
if(rowCount > 0){return ServerResponse.createBySuccessMessage("修改行程管理成功");}
return ServerResponse.createByErrorMessage("修改行程管理失败"); }
/** 获取行程管理数据(非分页,搜索功能) */
public ServerResponse<List<PageData>> queryAppXingChengKey(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.badArgument(); }
List<PageData> list=_mapper.queryAppXingChengKey(pd);
return ServerResponse.createBySuccess(list);}
/** 获取行程管理列表数据 分页*/
 public List<PageData> queryPageAppXingChengKeyList(Page pd) {
List<PageData> list=_mapper.queryPageAppXingChengKeyList(pd);
return list;}}
