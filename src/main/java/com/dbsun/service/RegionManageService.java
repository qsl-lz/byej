package com.dbsun.service;
import com.dbsun.common.ServerResponse;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import com.dbsun.mapper.RegionManageMapper;
import com.dbsun.service.BaseService;
import com.dbsun.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class RegionManageService extends BaseService {
@Autowired
private RegionManageMapper _mapper;
/**  添加景区区域管理 重复数据不能添加*/
@Transactional
public ServerResponse<String> addRegionManageNo(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.createByErrorMessage("删除景区区域管理参数错误"); }
List<PageData> list =_mapper.queryRegionManageKey(pd);
if(list.size() > 0) return ServerResponse.createByErrorMessage("景区区域管理已存在");
int rowCount = _mapper.addRegionManage(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加景区区域管理成功"); }
return ServerResponse.createByErrorMessage("添加景区区域管理失败");}
/**  添加景区区域管理 重复数据可以添加*/
@Transactional
public ServerResponse<String> addRegionManageAll(PageData pd) {
int rowCount = _mapper.addRegionManage(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加景区区域管理成功");  }
return ServerResponse.createByErrorMessage("添加景区区域管理失败");}
/** 根据id删除景区区域管理数据 */
public ServerResponse<String> deleteRegionManage(PageData pd) {
if(Tools.isObjEmpty(pd.get("id"))){ return ServerResponse.createByErrorMessage("删除景区区域管理参数错误");  }
int rowCount = _mapper.deleteRegionManageId(pd);
if(rowCount > 0){  return ServerResponse.createBySuccessMessage("删除景区区域管理成功"); }
return ServerResponse.createByErrorMessage("删除景区区域管理失败");}
/** 根据id更新景区区域管理数据 */
@Transactional
public ServerResponse<String> updateRegionManage(PageData pd) {
if(Tools.isEmpty(pd.getString("id"))){return ServerResponse.createByErrorMessage("修改景区区域管理参数错误");}
int rowCount = _mapper.updateRegionManage(pd);
if(rowCount > 0){return ServerResponse.createBySuccessMessage("修改景区区域管理成功");}
return ServerResponse.createByErrorMessage("修改景区区域管理失败"); }
/** 获取景区区域管理数据(非分页,搜索功能) */
public ServerResponse<List<PageData>> queryRegionManageKey(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.badArgument(); }
List<PageData> list=_mapper.queryRegionManageKey(pd);
return ServerResponse.createBySuccess(list);}
/** 获取景区区域管理列表数据 分页*/
 public List<PageData> queryPageRegionManageKeyList(Page pd) {
List<PageData> list=_mapper.queryPageRegionManageKeyList(pd);
return list;}}
