<template>
  <div style="margin: 40px">
    <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
      <el-breadcrumb-item :to="{ path: '/' }" class="breadcrumb-text"
        >我的位置</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text" :to="{ path: '/admin' }"
        >医药商务管理</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text" :to="{ path: '/admin' }"
        >订单管理</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text">{{
        activeName
      }}</el-breadcrumb-item>
    </el-breadcrumb>

    <div>
      <el-table
        :data="tableData"
        border
        style="width: 100%; margin-top: 10px"
        :header-cell-style="rowClass"
        class="el-table"
      >
        <el-table-column fixed prop="product_id" label="编号" width="50">
        </el-table-column>
        <el-table-column prop="productname" label="名称" width="100">
        </el-table-column>
        <el-table-column prop="mdlint" label="药品分类" width="70">
        </el-table-column>
        <el-table-column prop="cas" label="MDL编号" width="100">
        </el-table-column>
        <el-table-column prop="price1" label="价格" width="100">
        </el-table-column>
        <el-table-column prop="stock" label="库存" width="80">
        </el-table-column>
        <el-table-column prop="image" label="图片" width="115">
          <template slot-scope="scope">
            <el-image
              style="width: 90px; height: 100px"
              :src="scope.row.image"
              fit="contain"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="60">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeName: "订单详情",
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
  methods: {
    //设置表头颜色
    rowClass({ row, rowIndex }) {
      //   console.log(rowIndex); //表头行标号为0
      return "background:#fba661;color:black;font-size:12px;";
    },
    handleClick(data) {
      console.log(data);
      this.$confirm("此操作将永久删除该订单, 是否继续?", "提示", {
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
  mounted() {
    console.log(this.$route.query.id);
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