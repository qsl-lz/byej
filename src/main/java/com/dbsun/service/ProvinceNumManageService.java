package com.dbsun.service;
import com.dbsun.common.ServerResponse;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import com.dbsun.mapper.ProvinceNumManageMapper;
import com.dbsun.service.BaseService;
import com.dbsun.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ProvinceNumManageService extends BaseService {
@Autowired
private ProvinceNumManageMapper _mapper;
/**  添加地图数据管理 重复数据不能添加*/
@Transactional
public ServerResponse<String> addProvinceNumManageNo(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.createByErrorMessage("删除地图数据管理参数错误"); }
List<PageData> list =_mapper.queryProvinceNumManageKey(pd);
if(list.size() > 0) return ServerResponse.createByErrorMessage("地图数据管理已存在");
int rowCount = _mapper.addProvinceNumManage(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加地图数据管理成功"); }
return ServerResponse.createByErrorMessage("添加地图数据管理失败");}
/**  添加地图数据管理 重复数据可以添加*/
@Transactional
public ServerResponse<String> addProvinceNumManageAll(PageData pd) {
int rowCount = _mapper.addProvinceNumManage(pd);
if(rowCount > 0){ return ServerResponse.createBySuccessMessage("添加地图数据管理成功");  }
return ServerResponse.createByErrorMessage("添加地图数据管理失败");}
/** 根据id删除地图数据管理数据 */
public ServerResponse<String> deleteProvinceNumManage(PageData pd) {
if(Tools.isObjEmpty(pd.get("id"))){ return ServerResponse.createByErrorMessage("删除地图数据管理参数错误");  }
int rowCount = _mapper.deleteProvinceNumManageId(pd);
if(rowCount > 0){  return ServerResponse.createBySuccessMessage("删除地图数据管理成功"); }
return ServerResponse.createByErrorMessage("删除地图数据管理失败");}
/** 根据id更新地图数据管理数据 */
@Transactional
public ServerResponse<String> updateProvinceNumManage(PageData pd) {
if(Tools.isEmpty(pd.getString("id"))){return ServerResponse.createByErrorMessage("修改地图数据管理参数错误");}
int rowCount = _mapper.updateProvinceNumManage(pd);
if(rowCount > 0){return ServerResponse.createBySuccessMessage("修改地图数据管理成功");}
return ServerResponse.createByErrorMessage("修改地图数据管理失败"); }
/** 获取地图数据管理数据(非分页,搜索功能) */
public ServerResponse<List<PageData>> queryProvinceNumManageKey(PageData pd) {
if(Tools.isObjEmpty(pd)){ return ServerResponse.badArgument(); }
List<PageData> list=_mapper.queryProvinceNumManageKey(pd);
return ServerResponse.createBySuccess(list);}
/** 获取地图数据管理列表数据 分页*/
 public List<PageData> queryPageProvinceNumManageKeyList(Page pd) {
List<PageData> list=_mapper.queryPageProvinceNumManageKeyList(pd);
return list;}}
