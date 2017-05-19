/**
 * Created by Linity on 2017/4/27.
 */
$(document).ready(function () {

    $("#blog-content").load('/blog/indexTable',function () {});
    $("#type-manage").on("click",function () {
        $("#blog-content").load('/blog/indexType',function () {})
    });
    $("#article-manage").on("click",function () {
        $("#blog-content").load('/blog/indexTable',function () {})
    });
    $("#drafts").on("click",function () {
        $("#blog-content").load('/blog/indexDrafts',function () {})
    });
    $("#addArticle").on("click",function () {
        $("#blog-content").load('/blog/addArticle',function () {})
    });
    $('ul').on("click","li",function () {
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
    });

});
