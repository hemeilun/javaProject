<template>
   <div>
    <h2 @click="showName">学生名字：{{name}}</h2>
    <button @click="sentName">把学生名给App</button>
    <button @click="unbind">解绑</button>
   </div>
</template>

<script>
import {mixin} from '../mixin'

export default {
    name:'StudentInfo',
    data(){
        return {
            name:'上三'
        }
    },
    mixins:[mixin],
    methods: {
        sentName() {
            this.$emit('meilun',this.name)
        },
        unbund() {
            //适用于解绑一个事件
            this.$parent.$off('meilun')
        }
    }

}
</script>

<style>

</style>