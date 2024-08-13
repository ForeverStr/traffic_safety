<template xmlns="el">
    <div class="home_div">
      <div style="margin-bottom: 10px">
        <el-input style="width: 300px; margin-right: 10px" v-model="params.id" placeholder="请输入设备id"></el-input>
        <el-button type="primary" style="margin-left: 10px" @click="findById">查询</el-button>
        <el-button type="primary" style="margin-left: 10px" @click="reset">重置</el-button>
      </div>

      <el-table :data="tableData" style="width: 100%;" :cell-style="rowStyle" >
        <el-table-column prop="deviceId" label="设备id" align="center"> </el-table-column>
        <el-table-column prop="time" label="时间段" align="center"> </el-table-column>
        <el-table-column prop="carFlow" label="车流量" align="center"> </el-table-column>
        <el-table-column prop="personFlow" label="人流量" align="center"></el-table-column>
          <el-table-column label="操作" align="center">
              <template slot-scope="scope">
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

                    <el-form-item label="设备id" label-width="15%">
                        <el-input v-model="form.deviceId" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                    <el-form-item label="时间段" label-width="15%">
                        <el-input v-model="form.time" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                    <el-form-item label="车流量" label-width="15%">
                        <el-input v-model="form.carFlow" autocomplete="off" style="width: 90%"></el-input>
                    </el-form-item>
                    <el-form-item label="人流量" label-width="15%">
                        <el-input v-model="form.personFlow" autocomplete="off" style="width: 90%"></el-input>
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
    name: "way.vue",
    data() {
        return {
            params:{
                id:"",
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
      this.findById();
    },
    methods:{
      findById() {
          request.get("/flow/getById",{
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
          this.params.id = ""
            this.findById()
        },
      handleSizeChange(pageSize) {
          this.params.pageSize = pageSize;
          this.findById()
      },

        edit(obj){
            this.form = obj;
            this.dialogFormVisible = true
        },
      handleCurrentChange(pageNum) {
          this.params.pageNum = pageNum;
          this.findById()
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
