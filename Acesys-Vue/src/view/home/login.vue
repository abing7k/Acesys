<template>
  <div>
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      class="demo-ruleForm"
      label-width="80px"
      size="mini"
      v-if="showlogin"
    >
      <el-form-item label="Username:" prop="username" class="item">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="Password:" prop="password" class="item">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item label="code:" prop="code" class="item">
        <el-input v-model="ruleForm.code"></el-input>
      </el-form-item>
      <div>
        <span>点击</span>
        <span style="color: #748fb3; font-weight: bold" @click="toregister()"
          >注册</span
        >
        <el-image
          style="
            width: 80px;
            height: 50px;
            margin-left: 60px;
            margin-top: -30px;
          "
          :src="captchUrl"
          fit="contain"
          @click="updateCaptcha"
        ></el-image>
      </div>

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

      <!-- #748fb3 -->
    </el-form>
  </div>
</template>

<script>
export default {
  inject: ["reload"],
  data() {
    return {
      captchUrl: "api/captcha?time=" + new Date(),
      showlogin: true,
      ruleForm: {
        username: "",
        password: "",
        code: "",
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          //   { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "change" },
        ],
        code: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 4, max: 4, message: "长度为4个字符", trigger: "blur" },
        ],
      },
    };
  },
  mounted() {
    const userdata = JSON.parse(localStorage.getItem("userdata"));
    if (userdata) {
      this.showlogin = false;
    }
  },
  methods: {
    // 点击切换验证码
    updateCaptcha() {
      // this.captchUrl = "http://10.37.196.194:8080/captcha?time="+new Date();
      this.captchUrl = "api/captcha?time=" + new Date();
      // this.reload()
    },
    submitForm(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          // alert("submit!");
          const result = await this.$http.post("/login", this.ruleForm);
          console.log(result.data + "登录");
          if (result.data.code == 200) {
            this.$message.success(result.data.messges);
            // this.$router.push("/medicine");
            localStorage.setItem("tokenHead", result.data.obj.tokenHead);
            localStorage.setItem("token", result.data.obj.token);
            const res = await this.$http.get("/usr/getInfo");
            console.log(res.data + "用户信息");
            localStorage.setItem("userdata", JSON.stringify(res.data));
            console.log(JSON.parse(localStorage.getItem("userdata")));
            if (res.data.roles == "管理员") {
              this.$router.push("/admin");
            } else if (res.data.roles == "会员") {
              this.$router.push("/user");
            } else {
              this.$router.push("/tourist");
            }
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
    toregister() {
      this.$router.push("/register");
    },
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
  font-size: 5px;
  font-weight: 500;
}
</style>