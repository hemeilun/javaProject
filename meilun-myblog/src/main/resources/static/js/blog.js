$(function () {
    $('#toTop-button').click(function () {
        $(window).scrollTo(0,500);
    });


    var waypoint = new Waypoint({
        element: document.getElementById('waypoint'),
        handler: function(direction) {
            if (direction == 'down') {
                $('#toolbar').show(100);
            } else {
                $('#toolbar').hide(500);
            }
            console.log('Scrolled to waypoint!  ' + direction);
        }
    })


    // 滑动到指定位置显示
    $(window).scroll(function () {
         var scrollTop = $(window).scrollTop();
         if(scrollTop >203){
             $(".m-nav-top-button-hidden").css("margin-top","0");
         }else {
             $(".m-nav-top-button-hidden").css("margin-top","-60px");
         }
    });

    //点击后显示目录
    $('.toc.button').popup({
        popup : $('.toc-container.popup'),
        on : 'click',
        position: 'left center'
    });

    //目录显示初始化
    tocbot.init({
        //内容显示在哪
        tocSelector: '.js-toc',
        //显示哪个地方里面的内容目录
        contentSelector: '.js-toc-content',
        //显示到几级标题
        headingSelector: 'h1, h2, h3, h4 ,h5 ,h6',
    });
})


