$(function () {

    // function checkUsername() {
    //     var username=$(".uUsername").val();
    //     var reg = /^\w{6,15}$/;
    //     var flag = reg.test(username);
    //     if(flag)
    //     {
    //         $("#username").css("border","");
    //         $.post("user/ifUserExist","username="+username,function (data) {
    //
    //             if(data=="true")
    //             {
    //                 $("#username").css("border","1px solid red");
    //                 $("#spanUsername").html("用户名已存在");
    //
    //             }
    //             else{
    //                 $("#spanUsername").html("");
    //             }
    //         })
    //     }
    //     else{
    //         $("#username").css("border","1px solid red");
    //     }
    //     return flag;
    // }

    $('.ui.form').form({
        fields : {
            uUsername : {
                identifier: 'uUsername',
                rules: [{
                    type : 'empty',
                    prompt: '请输入用户名'
                }]
            },
            uPassword : {
                identifier: 'uPassword',
                rules: [{
                    type : 'empty',
                    prompt: '请输入密码'
                }]
            },
            surePassword : {
                identifier: 'surePassword',
                rules: [{
                    type : 'empty',
                    prompt: '请确认密码'
                }]
            },
            uEmail : {
                identifier: 'uEmail',
                rules: [{
                    type : 'empty',
                    prompt: '请输入邮箱'
                }]
            }
        }
    });
})