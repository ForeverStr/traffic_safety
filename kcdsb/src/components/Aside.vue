<template xmlns="el">
    <el-aside >
        <el-menu >
            <h4>智慧交通步道系统</h4>
            <router-link to="/equipment">
                <el-menu-item index="1">
                    设备信息
                </el-menu-item>
            </router-link>
            <router-link to="/environment">
                <el-menu-item index="4">
                    管理人员
                </el-menu-item>
            </router-link>
            <router-link to="/way">
                <el-menu-item index="2">
                    流量信息
                </el-menu-item>
            </router-link>
            <router-link to="/ill">
                <el-menu-item index="3">
                    违规记录
                </el-menu-item>
            </router-link>
            <router-link to="exception">
                <el-menu-item index="6">
                    申请记录
                </el-menu-item>
            </router-link>
            <router-link to="/map">
                <el-menu-item index="5">
                    地图导航
                </el-menu-item>
            </router-link>
        </el-menu>
    </el-aside>
</template>

<script>
    export default {
        name: "Aside"
    }
</script>

<style scoped>
    .el-menu{
        margin-top: 30px;
        margin-bottom: 60px;
        background-color: #a3a3a300;
        color: #fff;
    }
    .el-menu h4{
        color: #fff;
        height: 120px;
        line-height: 50px;
        text-align: center;
        font-size: 28px;
    }
    .el-menu-item{
        text-align: center;
        line-height: 70px;
        height: 60px;
        margin: 10px 30px 10px 80px;
        padding-bottom: 20px;
        padding-top: 20px;
        font-size: 25px;
        color: rgb(255, 255, 255);
    }
    .el-menu-item.is-active{
        color: #ec5b18b8;
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
        height: 800px;
        color: #333;
        background-color: #1a26307c;
    }
    a{
        text-decoration: none;
    }
</style>
