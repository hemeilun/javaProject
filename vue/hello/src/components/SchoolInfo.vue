<template>
   <div>
    <h2 @click="showName">学校名称：{{name}}</h2>
   </div>
</template>

<script>
import {mixin} from '../mixin'

export default {
    name:'SchoolInfo',
    data(){
        return {
            name:'武科大'
        }
    },
    mixins:[mixin]

}
</script>

<style>

</style>