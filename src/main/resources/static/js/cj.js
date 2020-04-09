$(function () {

    $.ajax({
            url: "getMaterial",
            type:"get",
            dataType:"json",
            data:{
              "xzqh":"330301",
              "projId":"5a06241asbecd15f2210a",
              "code":"yt01.06"
            },
            success:function (res) {
                var data = res.data;
                $.each(data,function (i,n) {
                    $("#material").append('<li  class="list list-group-item " data-toggle="tab" id="'+this.id+'" onclick="showImg(\''+n.id+'\')">'+this.name+'<span class="badge">'+n.count+'</span></li>')
                    appendImg(this);
                })

        }
        }
    )

    $("#upload").click(function(){
       var entityId = $("li.active").attr("id");
       $("#entityId").val(entityId);
        $("#myModal").modal({
            backdrop:"static",
            remote:"/goUpload"
        })
    })


})
function showImg(id) {
    $("[entity]").css("display","none");
    $("[entity="+id+"]").css("display","block");
}
function appendImg(obj) {
    var showArea = $("#showArea");
    var _this=$(obj);
    var licenses =  _this[0].content;
   $.each(licenses,function (i,n) {
       var html='<div class="col-sm-6 col-md-4" style="display: none;" entity='+this.entityId+' ><a href="#" class="thumbnail" style="width: 100%;height: 100%;"><img src="/img/logo.png"></a></div>';
       showArea.children("div:last").after(html);
   })
}