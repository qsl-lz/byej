package com.dbsun.mapper;
import com.dbsun.entity.system.Page;
import com.dbsun.entity.system.PageData;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AppXingChengMapper {
/** 添加数据 */
int addAppXingCheng(PageData pd);
/** 根据id删除数据 */
int deleteAppXingChengId(PageData pd);
/** 根据id更新数据 */
int updateAppXingCheng(PageData pd);
/** 获取用户列表数据 不分页*/
List<PageData> queryAppXingChengKey(PageData pd);
/** 获取用户列表数据 分页*/
List<PageData> queryPageAppXingChengKeyList(Page page);}
