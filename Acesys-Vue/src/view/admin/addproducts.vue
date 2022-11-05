<template>
  <div style="margin: 0px">
    <!-- 添加商品表单 -->
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      class="demo-ruleForm"
      label-width="120px"
      size="mini"
    >
      <el-form-item label="编号" prop="productId">
        <el-input v-model="ruleForm.productId"></el-input>
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
        <el-input v-model="ruleForm.weight" type="number"></el-input>
      </el-form-item>
      <el-form-item label="药品类别" prop="catalogno">
        <el-input v-model="ruleForm.catalogno"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="note">
        <el-input v-model="ruleForm.note"></el-input>
      </el-form-item>
      <el-form-item label="价格1" prop="price1">
        <el-input v-model="ruleForm.price1" type="number"></el-input>
      </el-form-item>
      <el-form-item label="库存" prop="stock">
        <el-input v-model="ruleForm.stock" type="number"></el-input>
      </el-form-item>
      <el-form-item label="价格2" prop="price2">
        <el-input v-model="ruleForm.price2" type="number"></el-input>
      </el-form-item>
      <el-form-item label="实际库存" prop="realstock">
        <el-input v-model="ruleForm.realstock" type="number"></el-input>
      </el-form-item>
      <el-form-item label="上传图片">
        <el-upload
          class="avatar-uploader"
          action="/api/admin/addProductImg"
          :headers="headers"
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
      activeName: "添加商品",
      headers:{Authorization:localStorage.getItem("tokenHead") +" "+ localStorage.getItem("token")},
      options: [
        {
          value: "管理员",
          label: "管理员",
        },
        {
          value: "会员",
          label: "会员",
        },
      ],
      ruleForm: {
        productId: "", //商品编号
        productname:
          "", //产品名称
        category: "", //药品分类
        mdlint: "", //MDL编号
        cas: "", //化学文摘登记号
        newproduct: 1, //是否是新产品（单选框）
        formula: "", //化学方程式
        weight: "", //重量
        catalogno: "", //药品类别
        note: "", //备注
        price1: "", //价格1
        stock: "", //库存
        price2: "", //价格2
        realstock: "", //实际库存
        image: "",
      },
      rules: {
        productId: [
          { required: true, message: "请输入商品编号", trigger: "blur" },
          {
            validator: function (rule, value, callback) {
              if (/^[A-Za-z0-9]+$/.test(value) == false) {
                callback(new Error("请输入英文或者数字"));
              } else {
                //校验通过
                callback();
              }
            },
            trigger: "blur",
          },
        ],
        productname: [
          { required: true, message: "请输入药品名称", trigger: "blur" },
        ],
        category: [
          { required: true, message: "请输入药品分类", trigger: "blur" },
        ],
        mdlint: [
          { required: true, message: "请输入MDL编号", trigger: "blur" },
          {
            validator: function (rule, value, callback) {
              if (/^[A-Za-z0-9]+$/.test(value) == false) {
                callback(new Error("请输入英文或者数字"));
              } else {
                //校验通过
                callback();
              }
            },
            trigger: "blur",
          },
        ],
        cas: [
          { required: true, message: "请输入化学文摘登记号", trigger: "blur" },
          // {
          //   validator: function (rule, value, callback) {
          //     if (/^[A-Za-z0-9-_\u4e00-\u9fa5]{4,30}$/.test(value) == false) {
          //       callback(new Error("限制只能输入中英文，数字，‘-’，‘_’"));
          //     } else {
          //       //校验通过
          //       callback();
          //     }
          //   },
          //   trigger: "blur",
          // },
        ],
        newproduct: [
          { required: true, message: "请输入是否是新产品", trigger: "blur" },
        ],
        formula: [
          { required: true, message: "请输入化学方程式", trigger: "blur" },
        ],
        weight: [{ required: true, message: "请输入重量", trigger: "blur" }],
        catalogno: [
          { required: true, message: "请输入药品类别", trigger: "blur" },
        ],
        note: [
          // { required: true, message: "请填写备注", trigger: "blur" }
          ],
        price1: [{ required: true, message: "请填写价格1", trigger: "blur" }],
        stock: [{ required: true, message: "请填写库存", trigger: "blur" }],
        price2: [{ required: true, message: "请填写价格2", trigger: "blur" }],
        realstock: [
          { required: true, message: "请填写实际库存", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(async(valid) => {
        if (valid) {
          const result = await this.$http.post("/admin/addProduct", this.ruleForm);
          // console.log(result.data+ "注册");
          if (result.data.code == 200) {
            this.$message.success(result.data.messges);
            // this.$router.go(-1)
          } else {
            this.$message.error(result.data.messges);
          }
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
      if(res.code==200){
        this.ruleForm.image= res.obj
      }else{
        this.$message.error(result.data.messges);
      }
    },
    beforeAvatarUpload(file) {
      console.log(file);
      const isJPG = file.type === "image/jpeg" || file.type === "image/png"|| file.type === "image/jpg";
      const isLt2M = file.size / 1024 / 1024 < 5;

      if (!isJPG) {
        this.$message.error("上传图片只能是 JPG/PNG 格式!");
        return false;
      }
      if (!isLt2M) {
        this.$message.error("上传图片大小不能超过 5MB!");
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