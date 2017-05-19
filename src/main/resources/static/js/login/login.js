/**
 * Created by Administrator on 2017/4/7 0007.
 */
$(document).ready(function () {

    $(document).keydown(function (event) {
        if (event.keyCode == 13) {
            login();
        }
    })

    $(".btn-login").on("click", function(){
        login();
    });
});
function login() {
    $("#form_login").ajaxSubmit({
        url: "/doLogin",
        async: true,
        dataType: 'text',
        success: function (data) {
            var obj = JSON.parse(data);
            console.log(JSON.parse(data));
            if (obj.status == "success") {
                self.location.href = "/index";
                // $.post('/index',
                //     {id:obj.id},function (str) {
                //         console.log(str);
                //         $(document).html(str);
                //     });
            } else {
                layer.alert('用户名或者密码错误！', {
                    icon: 1
                });
            }
        },
        error: function (data) {
            layer.alert(data, {
                icon: 1
            });
        }
    });
}
