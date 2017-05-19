/**
 * Created by Linity on 2017/4/22.
 */
$(document).ready(function () {
    // alert(123);
    $("#setting-content").load("/weChat/accountDetail",{id:$("#uid").val()});

    $('ul').find('li').each(function () {
        // $
    });
    $('ul').on("click","li",function () {
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
    })
});
