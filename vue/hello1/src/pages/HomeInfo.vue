<template>
   <div>
        <h2>Home组件内容</h2>
          <div>
            <ul class="nav nav-tabs">
              <!-- 跳转时写完整路径 -->
               <li>
                  <router-link class="list-group-item"  active-class="active" to="/home/news">News</router-link>
                </li>
                <li>
                  <router-link class="list-group-item"  active-class="active" to="/home/message">Message</router-link>
                </li>
            </ul>

            <!-- 如果不写include就会把里面的所有都缓存 -->
            <!-- include里面写的是 -->
            <keep-alive>
               <router-view></router-view>
            </keep-alive>

          </div>
    </div>
</template>

<script>
export default {
    name:'HomeInfo'
}
</script>

<style>

</style>