package com.ljw.web.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Linity on 2017/4/27.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping("/index")
    public String index(){
        return "blog/index";
    }

    @RequestMapping("/indexTable")
    public String indexTable(){
        return "blog/index_blog";
    }

    @RequestMapping("/indexType")
    public String indexType(){
        return "blog/index_typeManage";
    }

    @RequestMapping("/indexDrafts")
    public String indexDrafts(){
        return "blog/index_drafts";
    }

    @RequestMapping("/addArticle")
    public String addArticle(){
        return "blog/add_article";
    }
}
