<template>
  <div style="margin: 40px">
    <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
      <el-breadcrumb-item :to="{ path: '/' }" class="breadcrumb-text"
        >我的位置</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text"
        >医药商务管理</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text">商品列表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-tabs v-model="activeName" @tab-click="handleClick" class="el-tabs__nav">
      <el-tab-pane label="商品查询" name="first">
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
          <el-table-column prop="stock" label="库存" width="100">
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
              <el-button
                @click="handleClick(scope.row)"
                type="text"
                size="small"
                >购买</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="查看订单" name="second">查看订单</el-tab-pane>
      <el-tab-pane label="查看购物车" name="third">查看购物车</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeName: "first",
      //   表格数据
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
    handleClick(tab, event) {
      //   console.log(tab, event);
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
.breadcrumb {
  //   margin-top: 10px;
}
.breadcrumb-text {
  font-size: 12px !important;
}
/deep/ .el-tabs__nav .el-tabs__item {
  font-size: 12px;
  color: #467aa7;
  font-weight: bold;
}
/deep/ .el-tabs__active-bar {
  background-color: #467aa7;
}
/deep/ .el-table .cell{
	font-size: 12px;
}
</style>