package com.dbsun.mapper;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface RegionManageMapper {
/** 添加数据 */
int addRegionManage(PageData pd);
/** 根据id删除数据 */
int deleteRegionManageId(PageData pd);
/** 根据id更新数据 */
int updateRegionManage(PageData pd);
/** 获取用户列表数据 不分页*/
List<PageData> queryRegionManageKey(PageData pd);
/** 获取用户列表数据 分页*/
List<PageData> queryPageRegionManageKeyList(Page page);}
