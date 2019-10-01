;(function (global, $) {

    function _initHtml() {

    }

    function _bindEvent() {

        /*登陆*/
        $("#login").click(function () {
            var form = utils.getElements("#form1");
            _ajaxData(form);
        })

        /*注册*/
        $("#register").click(function () {
            window.location.href='${request.contextPath}/tuser/jump/registry';
        })

    }




    /*ajax请求*/
    function _ajaxData(form) {
        $.ajax({
            url : '${request.contextPath}/tuser/login.json',
            type : 'post',
            contentType : 'application/json;charset=UTF-8',
            data : form,
            dataType : 'json',
            success : function(data) {
                // 成功
                if (data.code=="0") {
                    window.location.href='${request.contextPath}/tuser/bankloans';
                } else {
                    alert(data.msg)
                    // alert("登陆失败，账号或密码错误，请重新输入！");
                }
            }
        });
    }

    function init() {
        _initHtml();
        _bindEvent();
    }


    // 供别人调用，需要导出的方法

    $(function () {
        init();
    })



})(window, $);