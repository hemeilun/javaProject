$(function () {

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
            }
        }
    });
})