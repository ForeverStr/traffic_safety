<template xmlns="el">
    <div class="home_div">
        <div style="margin-bottom: 10px">
            <el-input style="width: 300px; margin-right: 10px" v-model="params.device_id" placeholder="请输入设备id"></el-input>
            <el-button type="primary" style="margin-left: 10px" @click="findByDevice">查询</el-button>
            <el-button type="primary" style="margin-left: 10px" @click="reset">重置</el-button>
        </div>

        <el-table :data="tableData" style="width: 100%;" :cell-style="rowStyle" >
            <el-table-column prop="deviceId" label="记录设备" align="center"> </el-table-column>
            <el-table-column prop="personPicture" label="违规行人图片" align="center">
                <template slot-scope="scope">
                    <img :src="'http://122.51.67.189:8089/image/' +scope.row.personPicture"
                         alt="logo"
                         @click="upload(scope.row.personPicture)"
                         style="width: 100px; height: auto;">
                </template>
            </el-table-column>
            <el-table-column prop="plate" label="违规车牌号" align="center"> </el-table-column>
            <el-table-column prop="carPicture" label="违规车辆照片" align="center">
                <template slot-scope="scope">
                    <img :src="'http://122.51.67.189:8089/image/' +scope.row.carPicture"
                         alt="logo"
                         @click="upload(scope.row.carPicture)"
                         style="width: 100px; height: auto;">
                </template>
            </el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope ="scope">
                    <el-button type="primary" @click="edit(scope.row)">查看</el-button>
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
            <el-dialog  :visible.sync="dialogFormVisible" width="30%">
                <el-form :model="form">
                    <el-form-item label="记录设备" label-width="15%">
                        <el-input v-model="form.deviceId" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                    <el-form-item label="违规行人图片" label-width="15%">
                        <img v-model="form.personPicture" alt="log"
                             :src="'http://122.51.67.189:8089/image/' +form.personPicture"
                             style="width: 100px; height: auto;">
                    </el-form-item>
                    <el-form-item label="违规车牌号" label-width="15%">
                        <el-input v-model="form.plate" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                    <el-form-item label="违规车辆照片" label-width="15%">
                        <img v-model="form.carPicture" alt="log" :src="'http://122.51.67.189:8089/image/' +form.carPicture" style="width: 100px; height: auto;">
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
                </div>

            </el-dialog>
        </div>

    </div>
</template>

<script>
import request from "../utils/request";
export default {
    name: "fault.vue",
    data() {
        return {
            params:{
                device_id:"",
                pageNum: 1,
                pageSize: 6,
            },
            tableData: [],
            total: 0,
            form: {
            },
            dialogFormVisible: false,
        }
    },
    created(){
        this.findByDevice();
    },
    methods:{
        findByDevice() {
            request.get("/ill/getByDevice",{
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
            this.params.device_id = ""
            this.findByDevice()
        },
        handleSizeChange(pageSize) {
            this.params.pageSize = pageSize;
            this.findByDevice()
        },

        edit(obj){
            this.form = obj;
            this.dialogFormVisible = true
        },
        handleCurrentChange(pageNum) {
            this.params.pageNum = pageNum;
            this.findByDevice()
        },
        rowStyle() {
            return "text-align:center";
        },
        upload(pic) {
            window.open('http://122.51.67.189:8089/image/' + pic, '_blank')
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
