package com.dong.system.controller;


import com.dong.system.entity.NoticeUser;
import com.dong.system.service.INoticeService;
import com.dong.system.service.INoticeUserService;
import com.dong.system.service.impl.NoticeUserServiceImpl;
import com.dong.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 */
@Controller
@RequestMapping("/admin/noticeuser")
public class NoticeUserController {
    @Autowired
    INoticeUserService noticeUserService;
    @Autowired
    INoticeService noticeService;

    @RequestMapping()
    public String index(Model model){
         model.addAttribute("noticeuser",noticeUserService.selectNotUser(ShiroUtils.getUserId()));
        return "admin/page/notice/Mynotice";
    }

    @GetMapping("/see")
    public String see(Integer id,Integer nid,Model model){

        noticeUserService.saveOrUpdate(new NoticeUser().setNoseId(id).setIsRead(1).setReadtime(LocalDateTime.now()));
        model.addAttribute("notice",noticeService.getById(nid));
        return "admin/page/notice/Seenotice";
    }
}

