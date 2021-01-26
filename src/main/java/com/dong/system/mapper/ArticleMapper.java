package com.dong.system.mapper;

import com.dong.system.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 */
public interface ArticleMapper extends BaseMapper<Article> {

     public List<Article> selectArticleAll(Article article);

     public int updateCount(Integer id);
}
