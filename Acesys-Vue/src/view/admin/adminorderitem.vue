<template>
  <div style="margin: 10px">
    <username></username>
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
        <el-table-column prop="pid" label="编号" width="100">
        </el-table-column>
        <el-table-column prop="uid" label="用户ID" width="100">
        </el-table-column>
        <el-table-column prop="uname" label="用户名称" width="150">
        </el-table-column>
        <el-table-column prop="pname" label="产品名称" width="186">
        </el-table-column>
        <el-table-column prop="number" label="数量" width="100">
        </el-table-column>
        <el-table-column prop="email" label="Email" width="100">
        </el-table-column>
        <!-- <el-table-column fixed prop="productId" label="编号" width="80">
        </el-table-column>
        <el-table-column prop="productname" label="名称" width="180">
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
        </el-table-column> -->
        <!-- <el-table-column fixed="right" label="操作" width="60">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small"
              >删除</el-button
            >
          </template>
        </el-table-column> -->
      </el-table>
    </div>
  </div>
</template>

<script>
import username from "@/components/username.vue";
export default {
  components: { username },
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
      console.log(data, "订单删除");
      this.$confirm("此操作将永久删除该订单, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          const result = await this.$http.delete(`/admin/deleteOrders/${id}`);
          if (result.data.code == 200) {
            this.$message.success(result.data.messges);
          } else {
            this.$message.error(result.data.messges);
          }
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    // 获取订单详情
    async getorderdetail() {
      console.log("获取订单详情");
      const result = await this.$http.post(
        `/admin/showOrdersByOid/${this.$route.query.orderdata.oid}`
      );
      if (result.data.code == 200) {
        // this.$message.success(result.data.messges);
        this.tableData = result.data.obj;
      } else {
        this.$message.error(result.data.messges);
      }
    },
  },
  mounted() {
    console.log(this.$route.query.orderdata);
    this.getorderdetail();
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