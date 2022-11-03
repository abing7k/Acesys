<template>
  <div style="margin: 0px">
    <el-tabs v-model="bctiveName" @tab-click="handleClick" class="el-tabs__nav">
      <el-tab-pane label="商品列表" name="商品列表">
        <!-- 表格 -->
        <el-table
          :data="tableData"
          border
          style="width: 100%"
          :header-cell-style="rowClass"
          class="el-table"
        >
          <el-table-column fixed prop="product_id" label="编号" width="50">
          </el-table-column>
          <el-table-column prop="productname" label="名称" width="100">
          </el-table-column>
          <el-table-column prop="mdlint" label="药品分类" width="50">
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
          <el-table-column label="修改" width="60">
            <template slot-scope="scope">
              <el-button
                @click="handleupdate(scope.row)"
                type="text"
                size="small"
                >修改</el-button
              >
            </template>
          </el-table-column>
          <el-table-column fixed="right" label="操作" width="60">
            <template slot-scope="scope">
              <el-button
                @click="handledelete1(scope.row)"
                type="text"
                size="small"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="订单" name="订单">
        <el-table
          :data="tableData1"
          border
          style="width: 100%"
          :header-cell-style="rowClass"
          class="el-table"
        >
          <el-table-column fixed prop="ordersid" label="编号" width="100">
          </el-table-column>
          <el-table-column prop="usrid" label="用户ID" width="100">
          </el-table-column>
          <el-table-column prop="username" label="用户名称" width="150">
          </el-table-column>
          <el-table-column prop="email" label="Email" width="200">
          </el-table-column>
          <el-table-column fixed="right" label="查看" width="60">
            <template slot-scope="scope">
              <el-button
                @click="handleadminorderitem(scope.row)"
                type="text"
                size="small"
                >查看</el-button
              >
            </template>
          </el-table-column>
          <el-table-column fixed="right" label="操作" width="60">
            <template slot-scope="scope">
              <el-button
                @click="handledelete(scope.row)"
                type="text"
                size="small"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="添加商品" name="添加商品">
        <addproducts></addproducts>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import { getCookie, setCookie, removeCookie } from "@/router/Cookie";
import addproducts from "./addproducts.vue";
export default {
  components: {
    addproducts,
  },
  created() {
    if (getCookie("bctiveName")) {
      this.bctiveName = getCookie("bctiveName");
    }
  },
  name: "products",
  data() {
    return {
      bctiveName: "商品列表",
      //   商品列表数据
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
      // 订单列表数据
      tableData1: [
        {
          username: "用户名",
          id: "1",
          email: "1111111111@qq.com",
          ordersid: 1,
          usrid: 1,
        },
      ],
    };
  },
  methods: {
    handleadminorderitem(order) {
      this.$router.push({
        path: "/admin/adminorderitem",
        query: { id: order.ordersid },
      });
    },
    //设置表头颜色
    rowClass({ row, rowIndex }) {
      //   console.log(rowIndex); //表头行标号为0
      return "background:#fba661;color:black;font-size:12px;";
    },
    handleClick(tab, event) {
      setCookie("bctiveName", tab.paneName);
    },
    // 删除商品
    handledelete1(data) {
      this.$confirm("此操作将永久删除该商品, 是否继续?", "提示", {
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
    // 删除订单
    handledelete(data) {
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
    // 点击跳转商品列表数据
    handleupdate(data) {
      console.log(data);
      this.$router.push({
        path: "/admin/updateproducts",
        query: { id: data.id },
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
  float: left !important;
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