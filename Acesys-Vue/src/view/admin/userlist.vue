<template>
  <div style="margin: 0px;width:100%;">
    <!-- 表格 -->
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      :header-cell-style="rowClass"
      class="el-table"
    >
      <el-table-column fixed prop="username" label="用户名" width="100">
      </el-table-column>
      <el-table-column prop="email" label="Email" width="110">
      </el-table-column>
      <el-table-column prop="tel" label="电话" width="110"> </el-table-column>
      <el-table-column prop="companyname" label="公司名称" width="135">
      </el-table-column>
      <el-table-column prop="roles" label="角色" width="85"> </el-table-column>
      <el-table-column label="修改" width="60">
        <template slot-scope="scope">
          <el-button @click="handleupdate(scope.row)" type="text" size="small"
            >修改</el-button
          >
        </template>
      </el-table-column>
      <!-- <el-table-column label="角色修改" width="70">
        <template slot-scope="scope">
          <i
            class="el-icon-s-custom"
            @click="handleClick(scope.row)"
            style="color: #66b1ff; font-size: 25px"
          ></i>
        </template>
      </el-table-column> -->
      <!-- <el-table-column
        fixed="right"
        prop="del_flag"
        label="状态"
        width="60"
        :formatter="delShow"
      >
      </el-table-column> -->
      <el-table-column label="状态" width="71" :formatter="delShow">
        <template slot-scope="scope">
          <el-button
            type="text"
            size="small"
            v-if="scope.row.del_flag == 1"
            style="color: black"
            >已删除</el-button
          >
          <el-button
            @click="handledelete(scope.row)"
            type="text"
            size="small"
            v-else-if="scope.row.del_flag == 0"
            >点击删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import products from "./products.vue";
export default {
  components: {
    products,
  },
  data() {
    return {
      activeName: "用户列表",
      //   表格数据
      tableData: [
        {
          username: "用户名",
          id: "1",
          email: "1111111111@qq.com",
          tel: "13411111111",
          companyname: "公司名称",
          superuser: 1, //'表示用户权限标志1.普通注册用户2.高权限用户3.管理员',
          del_flag: 1, //'1代表删除, 0代表未删除',
          roles: "管理员",
        },
        {
          username: "用户名",
          id: "1",
          email: "1111111111@qq.com",
          tel: "13411111111",
          companyname: "公司名称",
          superuser: 2, //'表示用户权限标志1.普通注册用户2.高权限用户3.管理员',
          del_flag: 1, //'1代表删除, 0代表未删除'
          roles: "会员",
        },
        {
          username: "用户名",
          id: "1",
          email: "@qq.com",
          tel: "13411111111",
          companyname: "公司名称",
          superuser: 3, //'表示用户权限标志1.普通注册用户2.高权限用户3.管理员',
          del_flag: 0, //'1代表删除, 0代表未删除'
          roles: "会员",
        },
      ],
    };
  },
  methods: {
    handleClick(tab, event) {
      //   console.log(tab, event);
    },
    //设置表头颜色
    rowClass({ row, rowIndex }) {
      //   console.log(rowIndex); //表头行标号为0
      return "background:#fba661;color:black;font-size:12px;";
    },
    // 设置用户权限标志
    // superuserShow(row, column, cellValue, index) {
    //   // console.log(row, column, cellValue, index);
    //   if (cellValue === 1) {
    //     return "普通用户";
    //   } else if (cellValue === 2) {
    //     return "高权限用户";
    //   } else {
    //     return "管理员";
    //   }
    // },
    delShow(row, column, cellValue, index) {
      if (cellValue === 1) {
        return "已删除";
      } else {
        return "删除";
      }
    },
    // 修改
    handleupdate(data) {
      this.$router.push({
        path: "/admin/updateproductuser",
        query: { id: data.id },
      });
    },
    // 删除
    handledelete(data) {
      console.log(data);
      this.$confirm("此操作将永久删除该用户信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$message({
            type: "success",
            message: "删除成功!",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
  },
};
</script>

<style scoped lang="less">
// .breadcrumb {
//   //   margin-top: 10px;
// }
.breadcrumb-text {
  font-size: 12px !important;
}
/deep/ .el-tabs__nav {
  float: right;
}
/deep/ .el-tabs__nav .el-tabs__item {
  font-size: 12px;
  color: #467aa7;
  font-weight: bold;
}
/deep/ .el-tabs__active-bar {
  background-color: #467aa7;
}
/deep/ .el-table .cell {
  font-size: 12px;
}
</style>