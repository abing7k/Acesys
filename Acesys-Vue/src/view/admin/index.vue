<template>
  <div style="margin: 40px">
    <username></username>
    <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
      <el-breadcrumb-item :to="{ path: '/' }" class="breadcrumb-text"
        >我的位置</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text"
        >医药商务管理</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text">{{
        activeName
      }}</el-breadcrumb-item>
    </el-breadcrumb>
    <el-tabs
      v-model="activeName"
      @tab-click="handleClick"
      class="el-tabs__nav"
      style="float: left"
    >
      <el-tab-pane label="用户列表" name="用户列表">
        <userlist></userlist>
      </el-tab-pane>
      <el-tab-pane label="商品列表" name="商品列表">
        <products></products>
      </el-tab-pane>
      <el-tab-pane label="邮件管理" name="邮件管理">
        <mailmanager></mailmanager>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import products from "./products.vue";
import userlist from "./userlist.vue";
import mailmanager from "./mailmanager.vue";
import { getCookie, setCookie, removeCookie } from "@/router/Cookie";
export default {
  components: {
    products,
    userlist,
    mailmanager,
  },
  data() {
    return {
      username: "",
      activeName: "用户列表",
      //   表格数据
      tableData: [
        {
          username: "用户名",
          id: "1",
          email: "@qq.com",
          tel: "13411111111",
          companyname: "公司名称",
          superuser: "1", //'表示用户权限标志1.普通注册用户2.高权限用户3.管理员',
          del_flag: "1", //'1代表删除, 0代表未删除'
        },
        {
          username: "用户名",
          id: "1",
          email: "@qq.com",
          tel: "13411111111",
          companyname: "公司名称",
          superuser: "1", //'表示用户权限标志1.普通注册用户2.高权限用户3.管理员',
          del_flag: "1", //'1代表删除, 0代表未删除'
        },
      ],
    };
  },
  created() {
    if (getCookie("activeName")) {
      this.activeName = getCookie("activeName");
    }
  },
  methods: {
    handleClick(tab, event) {
      setCookie("activeName", tab.paneName);
    },
    //设置表头颜色
    rowClass({ row, rowIndex }) {
      //   console.log(rowIndex); //表头行标号为0
      return "background:#fba661;color:black;font-size:12px;";
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