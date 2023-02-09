import { createRouter, createWebHistory } from 'vue-router'

import HomeInfo from "../pages/HomeInfo"
import AboutInfo from "../pages/AboutInfo"
import NewsInfo from "../pages/NewsInfo"
import MessageInfo from "../pages/MessageInfo"
import DetailInfo from "../pages/DetailInfo"

//注册路由
const routes = [
    {
        name:'zhuye',
        path: '/home',
        component:HomeInfo,
        meta:{isAuth:false,title:'主页'},
        children:[
            // 嵌套时子的path不加斜杠

            {
                name:'xinwen',
                path: 'news',
                component:NewsInfo
            },
            {
                name:'xinxi',
                path:'message',
                component:MessageInfo,
                children:[
                    {
                        path:'detail',
                        component:DetailInfo,

                        //第一种写法：值为对象，该对象中的所有key-value都会以props的形势传递给Detail组件
                        // props:{a:1,b:'hello'}

                        //第二种写法：职位布尔值，若布尔值为真，就会把该路由组件收到的所有params参数，以props的形势传给Detail组件
                        // props:true

                        //props的第三种写法，值为函数
                        props($route){
                            return {id:$route.query.id,title:$route.query.title}
                        }
                    }
                ]
            }

        ]
    },
    {
        name:'guanyu',
        path: '/about',
        component:AboutInfo,
        meta:{isAuth:true}
    }
];
const router = createRouter({
// createWebHashHistory()是使用hash模式路由
// createWebHistory()是使用history模式路由
    history: createWebHistory(),
    routes
});

//全局前置路由守卫--初始化时被调用、每次路由切换之前被调用
router.beforeEach((to,from,next)=>{
  console.log('前置路由守卫')
  console.log(to)
  console.log(from)

  //根据条件进行判断，如果是支持的就执行next()
  //next()就是放行   

  if(to.meta.isAuth){
    alert('需要权限')
  }else{
    next()
  }
//   next()
})


//全局后置路由守卫--初始化时被调用、每次路由切换之后被调用
router.afterEach((to,from)=>{
    console.log('后置路由守卫')
    console.log(to)
    console.log(from)
    document.title = to.meta.title || 'meilun'
  
  })

export default router;
