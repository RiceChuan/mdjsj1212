/**
 * Created by RiceChuan on 17.9.14.
 */
var local = window.localStorage,HTML,staticUrl;
staticUrl = 'http://' + local.IP + ':' + local.port;

$("#logout").click(function () {
    layer.confirm('确认退出？',{icon:3,title:'提示'},function () {
        jQuery.ajax({
            type:'POST',
            async: false,
            cache: false,
            url: 'sso/logout',
            headers:{
                "authorization":local.sessionId
            },
            contentType: 'application/json',
            dataType: 'json',
            data:'{\"sessionId\":\"'+local.sessionId+'\"}',
            timeout:5000,
            success: function (result) {
                if (result.code ==1 ){
                    layer.msg('退出成功', {icon: 1});
                    setTimeout(function () {
                        window.location.href="/";
                    }, 1000)   //退出成功延迟1秒跳转到登录页面
                }
                else {
                    layer.confirm("系统错误");
                }
            }});

    })
});