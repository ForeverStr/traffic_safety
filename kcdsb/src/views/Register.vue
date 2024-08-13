<template xmlns="el">
    <!-- <div :style="background" class="bgBackground"> -->
    <div class="bgc">
            <div class="back_box">
                <a href="#/front">
                    <span>返回首页</span>
                </a>
            </div>
            <div class="box-content">
                <div class="">
                    <el-form :model="manager" ref="userForm" class="br" >
                        <h3 class="br_header">Register</h3>
                        <el-form-item label="账号" prop="name" class="form_input">
                            <el-input
                                type="text"
                                placeholder="请输入用户名"
                                v-model="manager.name"
                            ></el-input>
                        </el-form-item>
                        <el-form-item label="密码" prop="pwd" class="form_input">
                            <el-input
                                type="text"
                                placeholder="请输入密码"
                                show-password
                                v-model="manager.pwd"
                            ></el-input>
                        </el-form-item>
                        <el-form-item class="btn">
                            <el-button type="primary" autocomplete="off" @click="register" >注册</el-button>
                        </el-form-item>
                        <div class="creat">
                            <span>已经注册，赶快</span>
                            <a href="#/login">登录</a>
                        </div>
                    </el-form>
                </div>
            </div>
    </div>
</template>

<script>

export default {
    name: "Register",
    data() {
        return {
            manager: {},
        }
    },
    methods: {
        register() {
                if (this.manager) {  // 表单校验合法
                    this.request.post("/user/register", this.manager).then(res => {
                        if(res.code === "0") {
                            localStorage.setItem("manager",JSON.stringify(res.data))
                            this.$router.push("/login")
                            this.$message.success("注册成功")
                        } else {
                            this.$message.error(res.msg)
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
