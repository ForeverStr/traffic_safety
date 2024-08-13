<template xmlns="el">
    <div class="home_div">
        <div style="margin-bottom: 10px">
            <el-input style="width: 300px; margin-right: 10px" v-model="params.name" placeholder="请输入姓名"></el-input>
            <el-button type="primary" style="margin-left: 10px" @click="findPageName">查询</el-button>
            <el-button type="primary" style="margin-left: 10px" @click="reset">重置</el-button>
        </div>

        <el-table :data="tableData" style="width: 100%;" :cell-style="rowStyle" >
            <el-table-column prop="name" label="姓名" align="center"> </el-table-column>
            <el-table-column prop="gender" label="性别" align="center"> </el-table-column>
            <el-table-column prop="age" label="年龄" align="center"> </el-table-column>
            <el-table-column prop="phone" label="电话" align="center"> </el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope="scope">
                <el-button type="primary" @click="edit(scope.row)">编辑</el-button>
                <el-button type="danger" @click="editDel(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <div style="margin-top: 10px">
            <el-pagination @size-change="handleSizeChange"
                           @current-change="handleCurrentChange"
                           :current-page="params.pageNum"
                           :page-sizes="[6, 10, 15, 20]"
                           :page-size="params.pageSize"
                           layout="total, sizes, prev, pager, next"
                           :total="total">
            </el-pagination>
        </div>
        <div>
            <el-dialog title="请补全用户信息" :visible.sync="dialogFormVisible" width="30%">
                <el-form :model="form">
                    <el-form-item label="姓名" label-width="15%">
                        <el-input v-model="form.name" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                    <el-form-item label="年龄" label-width="15%">
                        <el-input v-model="form.age" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                    <el-form-item label="电话" label-width="15%">
                        <el-input v-model="form.phone" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" label-width="15%">
                        <el-radio v-model="form.gender" label="男">男</el-radio>
                        <el-radio v-model="form.gender" label="女">女</el-radio>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="cel">取 消</el-button>
                    <el-button type="primary" @click="update">确 定</el-button>
                </div>
            </el-dialog>
            <el-dialog title="是否确认删除该用户" :visible.sync="dialogFormVisibleDel" width="30%">
                <el-form :model="form">
                    <el-form-item label="姓名" label-width="15%">
                        <el-input v-model="form.name" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisibleDel = false">取 消</el-button>
                    <el-button type="danger" @click="del">确认删除</el-button>
                </div>
            </el-dialog>
        </div>
    </div>
</template>

<script>
import request from "../utils/request";
export default {
    name: "way.vue",
    data() {
        return {
            params:{
                pageNum: 1,
                pageSize: 6,
                name:''
            },
            manager:{
            },
            tableData: [],
            total: 0,
            dialogFormVisible: false,
            dialogFormVisibleDel:false,
            form: {
            },
        }
    },
    created(){
        this.load();
    },
    methods:{
        load() {
            request.get("/user/getAll",{
                params:this.params
            }).then(res =>{
                if (res.code === '0'){
                    this.tableData = res.data.list;
                    this.total = res.data.total;
                }else {
                    console.log(res.msg)
                }
            })
        },
        findPageName(){
            request.get("/user/getPageName",{
                params:this.params
            }).then(res =>{
                if (res.code === '0'){
                    this.tableData = res.data.list;
                    this.total = res.data.total;
                }else {
                    console.log(res.msg)
                }
            })
        },
        reset(){
            this.params.name = ""
            this.load()
        },
        handleSizeChange(pageSize) {
            this.params.pageSize = pageSize;
            this.load()
        },
        handleCurrentChange(pageNum) {
            this.params.pageNum = pageNum;
            this.load()
        },
        add(){
            this.dialogFormVisible = true
        },
        edit(obj){
            this.form = obj;
            this.dialogFormVisible = true
        },
        cel(){
            this.dialogFormVisible = false ;
            location.reload()
        },
        editDel(obj){
            this.form = obj;
            this.dialogFormVisibleDel = true
        },
        update(){
            request.post("user/update",this.form).then(res =>{
                if (res.code === '0'){
                    this.dialogFormVisible = false;
                }else {
                    console.log(res.msg)
                }
            })
        },
        del(){
            request.post("user/del",this.form).then(res => {
                if (res.code === '0'){
                    this.dialogFormVisibleDel = false
                    location.reload()
                }else {
                    console.log(res.msg)
                }
            })
        },
        rowStyle() {
            return "text-align:center";
        },
    },

}
</script>



<style scoped>
.home_div {
    height: 100%;
    width: 100%;
    padding: 0px;
    margin: 0px;
    position: relative;
}

#container {
    height: 75%;
    width: 100%;
    padding: 0px;
    margin: 0px;
    border-radius: 30px;

}
</style>
