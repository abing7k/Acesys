<template>
  <div style="margin: 10px">
    <username></username>
    <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
      <el-breadcrumb-item :to="{ path: '/' }" class="breadcrumb-text"
        >我的位置</el-breadcrumb-item
      >

      <el-breadcrumb-item class="breadcrumb-text" :to="{ path: '/medicine' }"
        >医药商务管理</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text" :to="{ path: prePath }"
        >商品列表</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text">订单详情</el-breadcrumb-item>
    </el-breadcrumb>
    <el-table
      :data="tableData"
      border
      style="width: 100%; margin-top: 10px"
      :header-cell-style="rowClass"
      class="el-table"
    >
      <el-table-column prop="pid" label="编号" width="100"> </el-table-column>
      <el-table-column prop="uid" label="用户ID" width="100"> </el-table-column>
      <el-table-column prop="uname" label="用户名称" width="150">
      </el-table-column>
      <el-table-column prop="pname" label="产品名称" width="150">
      </el-table-column>
      <el-table-column prop="number" label="数量" width="100">
      </el-table-column>
      <el-table-column prop="email" label="Email" width="100">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "orderlistdetail",
  data() {
    return {
      prePath: "",
      tableData: [
        {
          product_id: "编号",
          id: "1",
          productname:
            "名称药品分类药品分类药品分类药品分类药品分类药品分类药品分类药品分类",
          mdlint: "001",
          cas: "MDL编号",
          price1: "价格",
          stock: "100",
          image:
            "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
        },
        {
          product_id: "编号",
          id: "1",
          productname: "名称",
          mdlint: "药品分类",
          cas: "MDL编号",
          price1: "价格",
          stock: "100",
          image:
            "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
        },
      ],
    };
  },
  mounted() {
    this.getorderdetail();
  },
  methods: {
    //设置表头颜色
    rowClass({ row, rowIndex }) {
      //   console.log(rowIndex); //表头行标号为0
      return "background:#fba661;color:black;font-size:12px;";
    },
    // 获取订单的详细信息
    async getorderdetail() {
      console.log("获取订单详情");
      console.log(this.$route.query.orderdata)
      const result = await this.$http.post(
        `/vip/showOrdersByOid/${this.$route.query.orderdata}`
      );
      if (result.data.code == 200) {
        // this.$message.success(result.data.messges);
        this.tableData = result.data.obj;
      } else {
        this.$message.error(result.data.messges);
      }
    },
  },
  beforeRouteEnter(to, from, next) {
    /* must call `next` */
    console.log(from, "来了");
    next((data) => {
      data.prePath = from.fullPath;
      console.log(data.prePath, "地址");
    });
  },
};
</script>

 <style scoped lang="less">
#select {
  width: 675px;
  height: 200px;
  float: left;
  background-image: url(../../assets/images/search-product_09.jpg);
}
.breadcrumb-text {
  font-size: 12px !important;
}
td[data-v-43464b41][data-v-43464b41] {
  float: revert;
}
//   .select {
//     background-image: url(../images/search-product_09.jpg);
//     width: 535px;
//     height: 200px;
//     float: left;
// }
/deep/ .el-tabs__nav .el-tabs__item {
  font-size: 12px;
  color: #467aa7;
  font-weight: bold;
}
/deep/ .el-tabs__active-bar {
  background-color: #467aa7;
}
td[data-v-43464b41] {
  float: right;
}
/deep/ .el-table .cell {
  font-size: 12px;
}
.demo-ruleForm {
  // display: flex;
  // flex-wrap: wrap;
  margin-top: 10px;
  margin-left: 150px;
  .el-input {
    width: 200px;
  }
}
</style>