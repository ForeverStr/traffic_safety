<template xmlns="el">
    <div class="bgc">
        <div class="back_box">
            <a href="#/front">
                <span class="test">返回首页</span>
            </a>
        </div>

        <div class="box-content">
            <div class="box">
                <el-form :model="manager"  ref="userForm" class="br">
                    <h3 class="br_header">LOGIN</h3>
                    <el-form-item label="账号" prop="name" class="form_input">
                        <el-input type="text" placeholder="请输入用户名" v-model="manager.name"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="pwd" class="form_input">
                        <el-input type="text" placeholder="请输入密码" show-password v-model="manager.pwd"></el-input>
                    </el-form-item>
                    <el-form-item class="btn">
                        <el-button type="primary" autocomplete="off" @click="login" >登录</el-button>
                    </el-form-item>
                    <div class="creat">
                        <span>还没有账户，赶快</span>
                        <a href="#/register">注册</a>
                    </div>
                </el-form>
            </div>
        </div>
   </div>
</template>

<script>

export default {
    name: "Login",
    data() {
        return {
            manager: {},
        }
    },
    methods: {
        login() {
                if (this.manager) {
                    this.request.post("/user/login",this.manager).then(res => {
                        console.log(res);
                        if(res.code === "0") {
                            localStorage.setItem("manager",JSON.stringify(res.data))
                            this.$router.push("/main")
                            this.$message.success("登陆成功")
                        } else {
                            this.$message.warning(res.msg)
                        }
                    })
                } else {
                    return false;
                }
        }
    }
}
</script>

<style scoped>
@import url(../assets/css/login.css);
</style>
