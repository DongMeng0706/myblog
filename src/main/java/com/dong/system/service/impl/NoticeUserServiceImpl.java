package com.dong.system.service.impl;

import com.dong.system.entity.NoticeUser;
import com.dong.system.mapper.NoticeUserMapper;
import com.dong.system.service.INoticeUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class NoticeUserServiceImpl extends ServiceImpl<NoticeUserMapper, NoticeUser> implements INoticeUserService {
    @Autowired
    NoticeUserMapper noticeUserMapper;

    @Transactional
    @Override
    public List<NoticeUser> selectNotUser (Integer id) {
        return noticeUserMapper.selectNotUser(id);
    }
}
