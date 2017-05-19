/**
 * Created by Linity on 2017/5/2.
 */
$(document).ready(function () {

    var formData = new FormData();
    formData.append('file', $('#file')[0].files[0]);

   $("#submit").on("click",function () {
       $.ajax({
           url:'/fileServer/fileUpload',
           // enctype: 'multipart/form-data',
           type: "POST",
           cache: false,
           data: new FormData($('#file-form')[0]),
           processData: false,
           contentType: false
       }).done(function(res) {
               $('#myPic').modal('hide');
               $('.meta_pic').attr('src',res.path);
               $('.meta_pic').attr('id',res.id);
       }).fail(function(res) {});
   });
});
