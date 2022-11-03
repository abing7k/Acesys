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
        >商品管理</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text">{{
        activeName
      }}</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 添加商品表单 -->
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      class="demo-ruleForm"
      label-width="100px"
      size="mini"
    >
      <el-form-item label="编号" prop="product_id">
        <el-input v-model="ruleForm.product_id"></el-input>
      </el-form-item>
      <el-form-item label="产品名称" prop="productname">
        <el-input v-model="ruleForm.productname"></el-input>
      </el-form-item>
      <el-form-item label="药品分类" prop="category">
        <el-input v-model="ruleForm.category"></el-input>
      </el-form-item>
      <el-form-item label="化学文摘登记号" prop="cas">
        <el-input v-model="ruleForm.cas"></el-input>
      </el-form-item>
      <el-form-item label="MDL编号" prop="mdlint">
        <el-input v-model="ruleForm.mdlint"></el-input>
      </el-form-item>
      <el-form-item label="新产品" prop="password">
        <el-radio v-model="ruleForm.newproduct" :label="1">是</el-radio>
        <el-radio v-model="ruleForm.newproduct" :label="2">否</el-radio>
      </el-form-item>
      <el-form-item label="化学方程式" prop="formula">
        <el-input v-model="ruleForm.formula"></el-input>
      </el-form-item>
      <el-form-item label="总重量" prop="weight">
        <el-input v-model="ruleForm.weight"></el-input>
      </el-form-item>
      <el-form-item label="药品类别" prop="catalogno">
        <el-input v-model="ruleForm.catalogno"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="note">
        <el-input v-model="ruleForm.note"></el-input>
      </el-form-item>
      <el-form-item label="价格1" prop="price1">
        <el-input v-model="ruleForm.price1"></el-input>
      </el-form-item>
      <el-form-item label="库存" prop="stock">
        <el-input v-model="ruleForm.stock"></el-input>
      </el-form-item>
      <el-form-item label="价格2" prop="price2">
        <el-input v-model="ruleForm.price2"></el-input>
      </el-form-item>
      <el-form-item label="realstock" prop="实际库存">
        <el-input v-model="ruleForm.realstock"></el-input>
      </el-form-item>
      <el-form-item label="realstock" prop="实际库存">
        <el-upload
          class="avatar-uploader"
          action=""
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
        >
          <img v-if="ruleForm.image" :src="ruleForm.image" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')"
          >提交</el-button
        >
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  mounted() {
    console.log(this.$route.query.id);
  },
  data() {
    return {
      activeName: "修改商品",
      ruleForm: {
        product_id: "编号", //商品编号
        productname:
          "名称药品分类药品分类药品分类药品分类药品分类药品分类药品分类药品分类", //产品名称
        category: "123", //药品分类
        mdlint: "001", //MDL编号
        cas: "MDL编号", //化学文摘登记号
        newproduct: 2, //是否是新产品（单选框）
        formula: "1", //化学方程式
        weight: "1", //重量
        catalogno: "1", //药品类别
        note: "1", //备注
        price1: "1", //价格1
        stock: "100", //库存
        price2: "1", //价格2
        realstock: "100", //实际库存
        image: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          //   { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
        fullname: [{ required: true, message: "请输入全名", trigger: "blur" }],
        city: [{ required: true, message: "请输入城市", trigger: "blur" }],
        title: [{ required: true, message: "请输入称呼", trigger: "blur" }],
        tel: [
          { required: true, message: "请输入电话", trigger: "blur" },
          {
            pattern: /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/,
            message: "请输入合法手机号/电话号",
            trigger: "blur",
          },
        ],
        newproduct: [{ required: true, message: "请输入密码", trigger: "blur" }],
        zip: [
          { required: true, message: "请输入邮政编码", trigger: "change" },
          { min: 6, max: 6, message: "长度为6个字符", trigger: "blur" },
        ],
        job: [{ required: true, message: "请输入职务", trigger: "blur" }],
        email: [
          { required: true, message: "请输入电子邮件", trigger: "blur" },
          {
            pattern:
              /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g,
            message: "请输入正确的邮箱",
            trigger: "blur",
          },
        ],
        country: [{ required: true, message: "请输入国家", trigger: "blur" }],
        companyname: [
          { required: true, message: "请输入公司名称", trigger: "blur" },
        ],
        companyaddress: [
          { required: true, message: "请输入公司地址", trigger: "blur" },
        ],
        note: [{ required: true, message: "请填写备注", trigger: "blur" }],
      },
    };
  },
  methods: {
    submitForm(formName) {
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
    handleAvatarSuccess(res, file) {
      console.log("上传图片成功", res, file);
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      console.log(file);
      const isJPG = file.type === "image/jpeg" || file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 5;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG/PNG 格式!");
        return false;
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 5MB!");
      }
      return isJPG && isLt2M;
    },
  },
};
</script>

<style lang="less" scoped>
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
.demo-ruleForm {
  display: flex;
  flex-wrap: wrap;
  margin-top: 10px;
  .el-input {
    width: 200px;
  }
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 60px;
  line-height: 60px;
  text-align: center;
}
.avatar {
  width: 100px;
  height: 60px;
  display: block;
}
</style>