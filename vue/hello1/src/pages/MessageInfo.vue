<template>
    <div>
        <ul>
            <li v-for="m in messageList" :key="m.id">
            <!-- 跳转路由并携带query参数，to的字符串写法 -->
            <!-- <router-link :to="`/home/message/detail?id=${m.id}&title=${m.title}`"> {{m.title}} </router-link>&nbsp;&nbsp; -->

            <!-- 跳转路由并携带query参数，to的对象写法 -->
            <!-- <router-link :to="{
                path:'/home/message/detail',
                query:{
                    id:m.id,
                    title:m.title
                }
            }">
             {{m.title}}
            </router-link> -->
            {{m.title}}
            <button @click="pushShow(m)">push查看</button>
            <button @click="replaceShow(m)">replace查看</button>
           </li>
           <li>news001</li><input type="text"/>
        <li>news002</li><input type="text"/>
        <li>news003</li><input type="text"/>
        </ul>
    <router-view></router-view>
    </div>
</template>

<script>
export default {
    name:'MessageInfo',
    data() {
        return {
            messageList:[
                {id:'001',title:'消息1'},
                {id:'002',title:'消息2'},
                {id:'003',title:'消息3'}
            ]
        }
    },
    methods: {
        pushShow(m) {
            this.$router.push({
                path:'/home/message/detail',
                query:{
                    id:m.id,
                    title:m.title
                }
            })
        },
        replaceShow(m) {
            this.$router.replace({
                path:'/home/message/detail',
                query:{
                    id:m.id,
                    title:m.title
                }
            })
        }
    }

}
</script>

<style>

</style>