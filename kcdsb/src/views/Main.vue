<template xmlns="el">
<div>
    <el-container style="height: 100%; border: 1px solid #409EFF"  class="bgBackground">
        <!-- 侧边导航栏 -->
        <el-aside>
            <Aside></Aside>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px;color:#fff"></i>
                    <el-dropdown-menu slot="default">
                        <el-dropdown-item><router-link :to="{path: '/login'}">退出登录</router-link></el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>{{manager.username}}</span>
            </el-header>

            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>

</div>

</template>

<script>
    import Aside from "../components/Aside";
    export default {
        name: "Main",
    components: { Aside },


        data(){
            return{
                manager:localStorage.getItem("manager")?JSON.parse(localStorage.getItem("manager")):{},
                device:localStorage.getItem("device")?JSON.parse(localStorage.getItem("device")):{}
            }
        },
    }


</script>

<style scoped>
@import url(../assets/css/login.css);
.bgBackground{
    background: url(../assets/imgs/light1-3.jpg) no-repeat ;
    background-size: cover;
    width:1590px;
    height:820px;
}
    .el-menu{
        background-color: #a3a3a300;
        color: #fff;
    }
    .el-menu h3{
        color: #fff;
        height: 60px;
        line-height: 60px;
        text-align: center;
        font-size: 28px;
    }
    .el-menu-item{
        text-align: center;
        line-height: 60px;
        height: 60px;
        border-bottom: 1px solid #c6e2ff;
        margin: 0px 30px 20px 20px;
        padding-left: -3px;
        text-indent: 0px;
        font-size: 20px;
        color: #fff;
    }
    .el-menu-item.is-active{
        color: #ec5b18;
    }
    .el-menu-item:last-child{
        /* border: 0; */
        margin-bottom: 0;
    }
    .el-header {
    background-color: #a3a3a300;
    color: rgb(255, 255, 255);
    line-height: 60px;
    box-shadow: 0 20px 40px rgba(0, 0, 0, .2), 0 0 6px rgba(0, 0, 0, .04);
  }

 /* 侧边栏容器 */
  .el-aside {
    width: 300px;
    color: #333;
    background-color: #1a26307c;
  }

a{
    text-decoration-line: none;
    color: #42b983;
}
</style>
