package com.xiaoyu.controller;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.domain.AjaxMessageEntity;
import com.xiaoyu.domain.PageInfo;
import com.xiaoyu.domain.PageResult;
import com.xiaoyu.domain.TUser;
import com.xiaoyu.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart@create 2019-09-22 20:36
 */
@Controller
@RequestMapping("/tuser")
public class TUserController {

    @Autowired
    private TUserService tUserService;
    /**
     * 跳转到登陆页面
     * */
    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        return new ModelAndView("main/html/user_login");
    }

    @RequestMapping("/query-by-page")
    public ModelAndView queryByPage(){
        return new ModelAndView("main/html/user_by_page");
    }

    /**
     * 跳转到订单页面
    * */
    @RequestMapping("/bankloans")
    public ModelAndView bankloans(){
        return new ModelAndView("user/html/bankloans");

    }

    @RequestMapping("/insert")
    @ResponseBody
    public ModelAndView inserUser(@RequestParam TUser tUser){
        return new ModelAndView("main/user_login");
    }

    /**
     * 用户登陆
     * @return
     */
    @RequestMapping("/login.json")
    public @ResponseBody AjaxMessageEntity<Object> userLogin(@RequestBody TUser tUser) throws Exception {
        AjaxMessageEntity<Object> tUserAjaxMessageEntity = new AjaxMessageEntity<>();
        tUserService.accountPasswordQuery(tUser);
        return tUserAjaxMessageEntity;
    }


    /**
     * 跳转注册页面
     */
    @RequestMapping("/jump/registry")
    public ModelAndView jumpRegister(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main/html/user_register");
        return modelAndView;
    }

    /**
       用户注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public TUser register(@RequestBody TUser tUser) throws Exception {
        TUser user = new TUser();

        tUserService.registerTUser(tUser);
        return user;
    }


    /**
     判断用户是否注册
     */
    @RequestMapping("/checkuserid")
    @ResponseBody
    public TUser checkUserId(@RequestBody TUser tUser) throws Exception {
        if(tUser.getUserid().trim().isEmpty()){
            tUser.setFlag(false);
            tUser.setMessage("请输入用户名！");
            return tUser;
        }
        TUser queryTuser = tUserService.queryTuser(tUser);
        if (queryTuser == null){
            tUser.setFlag(true);
        }else{
            tUser.setFlag(false);
            tUser.setMessage("该用户已注册！");
        }
        return tUser;
    }

    /**
     * 分页查询
     */
    @RequestMapping("/query-tuser-by-page.json")
    @ResponseBody
    public String queryTUserByPage(@RequestBody TUser tUser){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setStart(tUser.getStart());
        pageInfo.setLimit(tUser.getLimit());
        PageResult<TUser> tUserPageResult = tUserService.queryTUserByPage(tUser, pageInfo);
        Map<String, Object> maps = new HashMap<>();
        maps.put("rows",tUserPageResult.getRows());
        maps.put("total",tUserPageResult.getTotal());
        return JSON.toJSONString(maps);
    }


    /**
     * 修改用户
     * */

//    public TUser modifyTUser()

}
