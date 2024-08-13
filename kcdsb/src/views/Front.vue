<template>
    <div class="front">
           <ul class="top">
               <li class="yue">
                   <img src=../assets/imgs/yue.png alt="">
               </li>
               <li class="top-title">
                       <span>月桐创新</span>
               </li>
               <li class="login">
                   <a>
                       <router-link to="/login">
                           <el-button>COMING</el-button>
                       </router-link>
                   </a>
               </li>
<!--               <li class="login1">-->
<!--                   <a>-->
<!--                       <router-link to="/about">-->
<!--                           <el-button>项目介绍</el-button>-->
<!--                       </router-link>-->
<!--                   </a>-->
<!--               </li>-->
<!--               <li class="login2">-->
<!--                   <a>-->
<!--                       <router-link to="/login">-->
<!--                           <el-button>关于我们</el-button>-->
<!--                       </router-link>-->
<!--                   </a>-->
<!--               </li>-->
<!--               <li class="login3">-->
<!--               <a>-->
<!--                   <router-link to="/login">-->
<!--                       <el-button>联系我们</el-button>-->
<!--                   </router-link>-->
<!--               </a>-->
<!--               </li>-->

           </ul>
        <div class="title">
                <h1>智慧交通步道系统</h1>
        </div>
        <div class="title1">
            <h1>———立足交通安全，保障人民生命安康！</h1>
        </div>

    </div>
</template>

<script>
export default {
    name: "Front",

}
</script>

<style scoped>
@import url(../assets/css/front.css);
</style>
