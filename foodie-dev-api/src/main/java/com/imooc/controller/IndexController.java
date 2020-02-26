package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    CarouselService carouselService;

    @Autowired
    CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图", notes = "获取首页轮播图", httpMethod = "GET")
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel(){
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return IMOOCJSONResult.ok(list);
    }

    /*
    * 1. 查询大分类
    * 2. 如果鼠标上移到大分类，则加载子分类
    * */
    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类", httpMethod = "GET")
    @GetMapping("/cats")
    public IMOOCJSONResult cats(){
        List<Category> list = categoryService.queryAllRootCat();
        return IMOOCJSONResult.ok(list);
    }

}
