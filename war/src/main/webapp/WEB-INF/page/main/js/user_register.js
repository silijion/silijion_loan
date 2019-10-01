;(function (global, $) {

    function _initHtml() {


        /*校验userid是否被注册*/
        $("#userid").blur(function () {
            var form = {};
            form.userid = this.value;
            form = JSON.stringify(form);
            _checkUserId(form);
        })

    }
    
    function _checkUserId(form) {
        $.ajax({
            url : '${request.contextPath}/tuser/checkuserid',
            type : 'post',
            contentType : 'application/json;charset=UTF-8',
            data : form,
            dataType : 'json',
            success : function(data) {
                console.log(typeof data.flag)
                // 成功
                if (data.flag==true) {

                } else {
                    alert(data.message);
                    $("#userid").val("");
                }
            }
        });
    }

    function _bindEvent() {

        /*注册*/
        $("#register").click(function () {
            var form = utils.getElements("#form2")
             _ajaxData(form);
        })

        function _ajaxData(form) {
            $.ajax({
                url : '${request.contextPath}/tuser/register',
                type : 'post',
                contentType : 'application/json;charset=UTF-8',
                data : form,
                dataType : 'json',
                success : function(data) {
                    // 成功

                    alert("注册成功")
                    window.location.href='${request.contextPath}/tuser/welcome';

                }
            });
        }

        /*重置*/
        $("#reset").click(function () {
            utils.reset("#form2");
        })
    }






    function init() {
        _initHtml();
        _bindEvent();
    }


    $(function () {
        init();
    })

})(window, $);