package com.dong.system.service.impl;

import com.dong.system.entity.ArticleTag;
import com.dong.system.mapper.ArticleTagMapper;
import com.dong.system.service.IArticleTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表和标签表 服务实现类
 * </p>
 *
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements IArticleTagService {

}
