package com.dong.home.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dong.system.entity.ArticleUserFabulous;
import com.dong.system.service.IArticleUserFabulousService;
import com.dong.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleUserFabulousController {
    @Autowired
    IArticleUserFabulousService iArticleUserFabulousService;

    @RequiresUser()
    @ResponseBody
    @PostMapping("/fabulous")
    public Map<String,Object> fabulous(Integer articleid){
        ArticleUserFabulous articleUserFabulous = new ArticleUserFabulous().setArticleId(articleid).setUserId(ShiroUtils.getUserId());
        Map<String, Object> map = new HashMap<>();
        map.put("user_id",ShiroUtils.getUserId());
        map.put("article_id",articleid);
        ArticleUserFabulous one = iArticleUserFabulousService.getOne(new QueryWrapper<ArticleUserFabulous>().allEq(map));
        if(one==null) {//如果没有点赞择添加
            boolean save = iArticleUserFabulousService.save(articleUserFabulous);
        }else {//如果已经点赞择删除
            iArticleUserFabulousService.removeByMap(map);
        }
        Map<String, Object> p = new HashMap<>();
        p.put("code",200);
        return p;

    }
}

