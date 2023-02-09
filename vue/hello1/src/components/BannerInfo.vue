<template>
    <div>
        <h2>demo</h2>
  
        <button @click="back">后退</button>
        <button @click="forward">前进</button>
    </div>
    
</template>

<script>
export default {
    name:'BannerInfo',
    methods: {
        back() {
            this.$router.back()
        },
        forward() {
            this.$router.forward()

            //另一个控制前进后退，正数就是前进，负数就是后退
            //his.$router.forward(数字)
        }
    }

}
</script>

<style>

</style>