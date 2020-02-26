package com.imooc.service.impl;

import com.imooc.mapper.CategoryMapper;
import com.imooc.pojo.Category;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", 1);

        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }
}
