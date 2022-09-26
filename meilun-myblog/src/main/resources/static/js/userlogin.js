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
            },
            tName : {
                identifier: 'tName',
                rules: [{
                    type : 'empty',
                    prompt: '不可为空'
                }]
            }
        }
    });
})