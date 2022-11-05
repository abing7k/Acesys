<template>
  <div style="margin: 10px">
    <username></username>
    <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
      <el-breadcrumb-item :to="{ path: '/' }" class="breadcrumb-text"
        >我的位置</el-breadcrumb-item
      >

      <el-breadcrumb-item class="breadcrumb-text" :to="{ path: '/user' }"
        >医药商务管理</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text" :to="{ path: prePath }"
        >商品列表</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text">查询结果</el-breadcrumb-item>
    </el-breadcrumb>

    <el-table
      :data="tableData"
      border
      style="width: 100%; margin-top: 10px"
      :header-cell-style="rowClass"
      class="el-table"
    >
      <el-table-column fixed prop="productId" label="编号" width="50">
      </el-table-column>
      <el-table-column prop="productname" label="名称" width="100">
      </el-table-column>
      <el-table-column prop="mdlint" label="药品分类" width="50">
      </el-table-column>
      <el-table-column prop="cas" label="MDL编号" width="100">
      </el-table-column>
      <el-table-column prop="price1" label="价格" width="100">
      </el-table-column>
      <el-table-column prop="stock" label="库存" width="50"> </el-table-column>
      <el-table-column prop="image" label="图片" width="115">
        <template slot-scope="scope">
          <el-image
            style="width: 90px; height: 100px"
            :src="scope.row.image"
            fit="contain"
          ></el-image>
        </template>
      </el-table-column>
      <el-table-column label="购买数量" width="100">
        <template slot-scope="scope">
          <el-input v-model="scope.row.number"></el-input>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="购买" width="60">
        <template slot-scope="scope">
          <el-button @click="handleClick2(scope.row)" type="text" size="small"
            >购买</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "search",
  data() {
    return {
      prePath: "",
      tableData: [
        {
          productId: "编号",
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
      search: {},
    };
  },
  methods: {
    //设置表头颜色
    rowClass({ row, rowIndex }) {
      //   console.log(rowIndex); //表头行标号为0
      return "background:#fba661;color:black;font-size:12px;";
    },
    async handleClick2(data) {
      console.log(data, "商品数量");
      const result = await this.$http.post("/buyProduct", {
        pid: data.id,
        number: data.number,
      });
      console.log(result.data + "购买");
      if (result.data.code == 200) {
        this.$message.success(result.data.messges);
        // this.$router.go(-1)
      } else {
        this.$message.error(result.data.messges);
      }
    },
    // 获得搜索的结果
    async searchList() {
      const result = await this.$http.post("/product/likeProduct", this.search);
      if (result.data.code == 200) {
        this.tableData = result.data.obj;
      } else {
        this.$message.error(result.data.messges);
      }
    },
  },
  mounted() {
    console.log(this.$route.query.search);
    this.search = this.$route.query.search;
    console.log(this.search);
    this.searchList();
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