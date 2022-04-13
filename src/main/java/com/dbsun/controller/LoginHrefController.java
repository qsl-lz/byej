package com.dbsun.controller;
import com.dbsun.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api(value = "login_href", description = "登录")
@Controller
@RequestMapping("/login_href")
public class LoginHrefController extends BaseController {
@ApiOperation(value = "跳转到菜单管理页面")
@GetMapping("/idx_app_menu")
public String idxAppMenu() { 
return "idx_app_menu";
}
@ApiOperation(value = "跳转到体温管理页面")
@GetMapping("/idx_app_ti_wen")
public String idxAppTiWen() { 
return "idx_app_ti_wen";
}
@ApiOperation(value = "跳转到用户管理页面")
@GetMapping("/idx_app_user")
public String idxAppUser() { 
return "idx_app_user";
}
@ApiOperation(value = "跳转到行程管理页面")
@GetMapping("/idx_app_xing_cheng")
public String idxAppXingCheng() { 
return "idx_app_xing_cheng";
}
@ApiOperation(value = "跳转到紧急通知页面")
@GetMapping("/idx_notice_manage")
public String idxNoticeManage() { 
return "idx_notice_manage";
}
@ApiOperation(value = "跳转到地图数据管理页面")
@GetMapping("/idx_province_num_manage")
public String idxProvinceNumManage() { 
return "idx_province_num_manage";
}
@ApiOperation(value = "跳转到景区区域管理页面")
@GetMapping("/idx_region_manage")
public String idxRegionManage() { 
return "idx_region_manage";
}
@ApiOperation(value = "跳转到页面")
@GetMapping("/idx_sys_user")
public String idxSysUser() { 
return "idx_sys_user";
}
}
