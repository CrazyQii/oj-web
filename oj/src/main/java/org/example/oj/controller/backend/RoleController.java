package org.example.oj.controller.backend;


import com.github.pagehelper.PageInfo;
import org.example.oj.entity.Role;
import org.example.oj.response.RestResponseVO;
import org.example.oj.service.RoleService;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller("backendRoleController")
@RequestMapping("/backend/role")
public class RoleController {

    @Resource
    RoleService roleService;


    /**
     * 跳转到角色列表页面
     *
     * @return
     */
    @RequestMapping("/roleListPage")
    public String roleListPage(HttpServletRequest request) {
        //set data
        request.setAttribute("systemActive",true);
        request.setAttribute("roleActive",true);
        return "backend/user/role-list";
    }




    /**
     * 获取角色到页面
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/listRole2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listRole2Page(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10")Integer pageSize,
                                                  @RequestParam(defaultValue = "")String keyword){
        return roleService.listRole2Page(pageNum,pageSize,keyword);
    }


    /**
     * 获取角色到页面
     * @return
     */
    @RequestMapping("/listRole")
    @ResponseBody
    public RestResponseVO listRole(){
        return roleService.listRole();
    }



    /**
     * 添加role
     * @param role
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public RestResponseVO save(Role role){
        if(role != null && role.getId() != null){
            return roleService.updateById(role);
        }else {
            return roleService.insert(role);
        }
    }



    /**
     *  get role
     * @param roleId
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public RestResponseVO get(Integer roleId){
        return roleService.getById(roleId);
    }


    /**
     * 删除role
     * @param roleId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer roleId){
        return roleService.delById(roleId);
    }





}
