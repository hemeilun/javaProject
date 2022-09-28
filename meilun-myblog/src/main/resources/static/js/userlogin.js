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
            },
            bTitle : {
                identifier: 'bTitle',
                rules: [{
                    type : 'empty',
                    prompt: '标题：请输入博客标题'
                }]
            },
            bContent : {
                identifier: 'bContent',
                rules: [{
                    type : 'empty',
                    prompt: '标题：请输入博客内容'
                }]
            },
            bTagid : {
                identifier: 'bTagid',
                rules: [{
                    type : 'empty',
                    prompt: '标题：请输入博客分类'
                }]
            },
            bPicture : {
                identifier: 'bPicture',
                rules: [{
                    type : 'empty',
                    prompt: '标题：请输入博客首图'
                }]
            },
            bDescription : {
                identifier: 'bDescription',
                rules: [{
                    type : 'empty',
                    prompt: '标题：请输入博客描述'
                }]
            }
        }

    });
})