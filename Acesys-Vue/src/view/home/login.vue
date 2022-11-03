<template>
  <div>
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      class="demo-ruleForm"
      label-width="80px"
      size="mini"
    >
      <el-form-item label="Username:" prop="username" class="item">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="Password:" prop="password" class="item">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>
      <span >点击这里</span>
      <span style="color:#748fb3;font-weight:bold" @click="toregister()">注册</span>
      <!-- #748fb3 -->
      <el-form-item>
        <el-button
          type="primary"
          @click="submitForm('ruleForm')"
          round
          style="background-color: #748fb3"
          size="mini"
          >Login</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        username: "",
        password: "",
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          //   { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "change" },
        ],
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
    toregister(){
        this.$router.push("/register")
    }
  },
};
</script>

<style lang="less" scoped>
.demo-ruleForm {
  font-size: 10px;
  .el-input {
    width: 70px;
  }
}
/deep/ .item .el-form-item__label {
//   color: red;
    font-size:5px;
    font-weight: 500;
}
</style>