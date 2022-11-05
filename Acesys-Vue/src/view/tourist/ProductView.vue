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
      <el-breadcrumb-item class="breadcrumb-text">商品列表</el-breadcrumb-item>
      <el-breadcrumb-item class="breadcrumb-text">查看结果</el-breadcrumb-item>
    </el-breadcrumb>
    <el-tabs v-model="dctiveName" @tab-click="handleClick" class="el-tabs__nav">
      <el-tab-pane label="商品列表" name="zero">
        <el-table
          :data="tableData"
          border
          style="width: 100%"
          :header-cell-style="rowClass"
          class="el-table"
        >
          <el-table-column fixed prop="productId" label="编号" width="50">
          </el-table-column>
          <el-table-column prop="productname" label="名称" width="100">
          </el-table-column>
          <el-table-column prop="mdlint" label="药品分类" width="100">
          </el-table-column>
          <el-table-column prop="cas" label="MDL编号" width="100">
          </el-table-column>
          <el-table-column prop="price1" label="价格" width="50">
          </el-table-column>
          <el-table-column prop="stock" label="库存" width="50">
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
           <el-table-column label="购买数量" width="100">
            <template slot-scope="scope">
              <el-input v-model="scope.row.number"></el-input>
            </template>
          </el-table-column>
          <el-table-column fixed="right" label="购买" width="60">
            <template slot-scope="scope">
              <el-button
                @click="handleClick2(scope.row)"
                type="text"
                size="small"
                >购买</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="商品查询" name="first">
        <div id="select">
          <el-form
            :inline="true"
            :model="formInline"
            class="demo-form-inline"
            style="margin-top: 10px"
          >
            <el-form-item label="请选择">
              <el-select v-model="formInline.type" placeholder="类别">
                <el-option label="西药" value="西药"></el-option>
                <el-option label="中药" value="中药"></el-option>
                <el-option label="生化药" value="生化药"></el-option>
                <el-option label="维生素" value="维生素"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="内容">
              <el-input v-model="formInline.like" placeholder="内容"></el-input>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-tab-pane>
      <!-- <el-tab-pane label="查看订单" name="second">
        <el-table
          :data="orderData"
          border
          style="width: 100%"
          :header-cell-style="rowClass"
          class="el-table"
        >
          <el-table-column fixed prop="order_id" label="编号" width="350">
          </el-table-column>
          <el-table-column fixed prop="order_select" label="查看" width="350">
            <el-button @click="handleClick3" type="text" size="small"
              >查看</el-button
            >
          </el-table-column>
        </el-table>
      </el-tab-pane> -->
      <!-- <el-tab-pane label="结算中心" name="fifth">
        <el-table
          :data="purchaseData"
          border
          style="width: 100%"
          :header-cell-style="rowClass"
          class="el-table"
        >
          <el-table-column fixed prop="productId" label="编号" width="100">
          </el-table-column>
          <el-table-column prop="productname" label="名称" width="100">
          </el-table-column>
          <el-table-column prop="mdlint" label="药品分类" width="100">
          </el-table-column>
          <el-table-column prop="cas" label="MDL编号" width="100">
          </el-table-column>
          <el-table-column prop="price1" label="价格" width="100">
          </el-table-column>
          <el-table-column prop="number" label="价格" width="100">
          </el-table-column>
          <el-table-column fixed="right" label="删除" width="100">
            <template slot-scope="scope">
              <el-button
                @click="handleClick4(scope.row)"
                type="text"
                size="small"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>
        <div style="background-color: #f3f3f3">
          <span>用户信息</span>
          <span style="color: red"
            >(注册用户可以登陆后再来结算/未注册用户可以注册登陆或直接填写信息)</span
          >
        </div>
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          class="demo-ruleForm"
          label-width="100px"
          size="mini"
        >
          <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="tel">
            <el-input v-model="ruleForm.tel"></el-input>
          </el-form-item>
          <el-form-item label="电子邮件" prop="email">
            <el-input v-model="ruleForm.email"></el-input>
          </el-form-item>
          <el-form-item label="公司名称" prop="companyname">
            <el-input v-model="ruleForm.companyname"></el-input>
          </el-form-item>
          <el-form-item label="公司地址" prop="companyaddress">
            <el-input v-model="ruleForm.companyaddress"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')"
              >立即提交</el-button
            >
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane> -->
    </el-tabs>
  </div>
</template>
  
  <script>
import { getCookie, setCookie, removeCookie } from "@/router/Cookie";
export default {
  name: "tourist",
  data() {
    return {
      dctiveName: "zero",
      username: "user",
      phone: "123-2222-3333",
      email: "10086@100.com",
      companyName: "",
      companyAddress: "",
      keyword: "",
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
      purchaseData: [
        {
          productId: "编号",
          productname:
            "名称药品分类药品分类药品分类药品分类药品分类药品分类药品分类药品分类",
          mdlint: "001",
          cas: "MDL编号",
          price1: "价格",
          number: "100",
        },
        {
          product_id: "编号",
          productname:
            "名称药品分类药品分类药品分类药品分类药品分类药品分类药品分类药品分类",
          mdlint: "001",
          cas: "MDL编号",
          price1: "价格",
          stock: "100",
        },
      ],
      options: [
        {
          value: "选项1",
          label: "编号",
        },
        {
          value: "选项2",
          label: "西药",
        },
        {
          value: "选项3",
          label: "中药",
        },
        {
          value: "选项4",
          label: "西化药",
        },
        {
          value: "选项5",
          label: "维生素",
        },
      ],
      value: "选项1",
      input: "",
      formInline: {
        type: "",
        like: "",
      },
      // 购物车结算，提交表单数据
      ruleForm: {
        id: "",
        username: "", //用户名
        fullname: "", //全名
        city: "", //城市
        title: "", //称呼
        tel: "", //电话
        password: "", //密码
        zip: "", //邮政编码
        job: "", //职务
        email: "", //电子邮件
        country: "", //国家
        companyname: "", //公司名称
        companyaddress: "", //公司地址
        note: "", //备注
        roles: "",
      },
      rules: {
        username: [
          // { required: true, message: "请输入用户名", trigger: "blur" },
          //   { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
        fullname: [
          // { required: true, message: "请输入全名", trigger: "blur" }
          ],
        city: [
          // { required: true, message: "请输入城市", trigger: "blur" }
          ],
        title: [
          // { required: true, message: "请输入称呼", trigger: "blur" }
          ],
        tel: [
          // { required: true, message: "请输入电话", trigger: "blur" },
          {
            pattern: /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/,
            message: "请输入合法手机号/电话号",
            trigger: "blur",
          },
        ],
        password: [
          // { required: true, message: "请输入密码", trigger: "blur" }
          ],
        zip: [
          { required: true, message: "请输入邮政编码", trigger: "change" },
          { min: 6, max: 6, message: "长度为6个字符", trigger: "blur" },
        ],
        job: [{ required: true, message: "请输入职务", trigger: "blur" }],
        email: [
          // { required: true, message: "请输入电子邮件", trigger: "blur" },
          {
            pattern:
              /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g,
            message: "请输入正确的邮箱",
            trigger: "blur",
          },
        ],
        // country: [{ required: true, message: "请输入国家", trigger: "blur" }],
        companyname: [
          // { required: true, message: "请输入公司名称", trigger: "blur" },
        ],
        companyaddress: [
          // { required: true, message: "请输入公司地址", trigger: "blur" },
        ],
        // note: [{ required: true, message: "请填写备注", trigger: "blur" }],
      },
      number:"",
      orderData:[]
    };
  },
  created() {
    if (getCookie("dctiveName")) {
      this.dctiveName = getCookie("dctiveName");
    }
  },
  methods: {
    // 提交商品查询
    onSubmit() {
      console.log(this.formInline);
      this.$router.push({
        path: "/tourist/search",
        query: { search: this.formInline },
      });
    },
    submit() {},
    handleClick(tab, event) {
      setCookie("dctiveName", tab.paneName);
    },
   async handleClick2(data) {
     console.log(data,"商品数量")
    const result = await this.$http.post("/buyProduct", {pid:data.id,number:data.number});
      console.log(result.data + "购买");
      if (result.data.code == 200) {
        this.$message.success(result.data.messges);
        // this.$router.go(-1)
      } else {
        this.$message.error(result.data.messges);
      }
    },
    handleClick4() {
      this.$message({
        message: "删除成功",
        type: "success",
      });
    },
    handleClick3(tab, event) {
      this.$router.push("/user/orderdetail");
    },
    checkValue() {
      if (this.keyword) {
        this.$message({
          message: "请输入搜索内容",
          type: "warning",
        });
      }
    },
    open() {
      this.$confirm("确定注销吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$message({
            type: "success",
            message: "注销成功!",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消注销",
          });
        });
    },
    // 提交购物车结算
    submitForm(formName) {
      console.log(this.purchaseData);
      console.log(this.ruleForm);
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //设置表头颜色
    rowClass({ row, rowIndex }) {
      //   console.log(rowIndex); //表头行标号为0
      return "background:#fba661;color:black;font-size:12px;";
    },
    // 获取商品列表信息
    async getProductList() {
      console.log("获取商品列表数据");
      const result = await this.$http.post("/product/likeProduct", {
        like: "",
        type: "",
      });
      if (result.data.code == 200) {
        this.tableData = result.data.obj;
      } else {
        this.$message.error(result.data.messges);
      }
    },
  },
  mounted() {
    this.getProductList();
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