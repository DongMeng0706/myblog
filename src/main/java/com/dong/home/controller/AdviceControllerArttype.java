package com.dong.home.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dong.system.entity.Arttype;
import com.dong.system.service.IArttypeService;
import com.dong.system.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages = "com.dong.home.controller")
public class AdviceControllerArttype {
    @Autowired
    IArttypeService arttypeService;
    @Autowired
    ITagService iTagService;

    @ModelAttribute
    public void addmodel(Model model){
        model.addAttribute("listArttype",arttypeService.list(new QueryWrapper<Arttype>().eq("parentid",0).eq("state",1).orderByAsc("sort")));
        model.addAttribute("tags",iTagService.list());
    }
}
