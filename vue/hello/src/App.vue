<template>
    <div>
        <h1>{{msg}}</h1>
        <SchoolInfo/>

        <!-- 通过父组件给子组件绑定一个自定义事件实现，子给父传递数据（通过@或v-on） -->
        <StudentInfo v-on:meilun="getThisName"/>

    </div>
</template>

<script>
import SchoolInfo from './components/SchoolInfo.vue'
import StudentInfo from './components/StudentInfo.vue'

export default {
    name:'App',
    components:{
        SchoolInfo,
        StudentInfo
    },
    data() {
        return {
            msg:'你好呀'
        }
    },
    methods: {
        getThisName(name){
          console.log(name)
       }
    }

}
</script>

<style>

</style>