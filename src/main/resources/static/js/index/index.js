/**
 * Created by Linity on 2017/4/8.
 */
$(document).ready(function(){
    changeHeight();
    $(window).on('resize',function(){
        changeHeight();
    });
    $("#weChatSetting").on("click",function(){
        $("#content").load('/weChat/weiXinSetting',function(){})
    });
    $("#blog").on("click",function () {
        $("#content").load('/blog/index',function () {})
    });
    $("#logOut").on('click',function () {
        $.ajax({
            url:'/logout',
            success:function (data) {
                if(data == "success"){
                    self.location.href = "/login";
                }else{
                    layer.alert('系统异常！', {
                        icon: 1
                    });
                }
            }
        });
    })
});

function changeHeight() {
    var bodyH = $(window).height() - $('.navbar-static-top').height();
    // console.log(bodyH);
    $('#content').css({
        height: bodyH-5,
        overflow: 'auto'
    });
}