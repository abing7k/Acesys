<template>
  <div style="margin: 40px">
    <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
      <el-breadcrumb-item :to="{ path: '/' }" class="breadcrumb-text"
        >首页</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text" :to="{ path: '/register' }"
        >注册</el-breadcrumb-item
      >
    </el-breadcrumb>
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
      <el-form-item label="全名">
        <el-input v-model="ruleForm.fullname"></el-input>
      </el-form-item>
      <el-form-item label="城市">
        <el-input v-model="ruleForm.city"></el-input>
      </el-form-item>
      <el-form-item label="称呼">
        <el-input v-model="ruleForm.title"></el-input>
      </el-form-item>
      <el-form-item label="电话" prop="tel">
        <el-input v-model="ruleForm.tel"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item prop="pass" label="确认密码">
        <el-input
          placeholder="请输入确认密码"
          type="password"
          v-model="ruleForm.pass"
        ></el-input>
      </el-form-item>
      <el-form-item label="邮政编码" prop="zip">
        <el-input v-model="ruleForm.zip"></el-input>
      </el-form-item>
      <el-form-item label="职务">
        <el-input v-model="ruleForm.job"></el-input>
      </el-form-item>
      <el-form-item label="电子邮件" prop="email">
        <el-input v-model="ruleForm.email"></el-input>
      </el-form-item>
      <el-form-item label="国家">
        <el-input v-model="ruleForm.country"></el-input>
      </el-form-item>
      <el-form-item label="公司名称">
        <el-input v-model="ruleForm.companyname"></el-input>
      </el-form-item>
      <el-form-item label="公司地址">
        <el-input v-model="ruleForm.companyaddress"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input
          type="textarea"
          v-model="ruleForm.note"
          style="width: 500px"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')"
          >立即注册</el-button
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
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.pass !== "") {
          this.$refs.ruleForm.validateField("code");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        username: "", //用户名
        fullname: "", //全名
        city: "", //城市
        title: "", //称呼
        tel: "", //电话
        password: "", //密码
        pass: "",
        zip: "", //邮政编码
        job: "", //职务
        email: "", //电子邮件
        country: "", //国家
        companyname: "", //公司名称
        companyaddress: "", //公司地址
        note: "", //备注
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
          //   { required: true, message: "请输入电话", trigger: "blur" },
          {
            pattern: /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/,
            message: "请输入合法手机号/电话号",
            trigger: "blur",
          },
        ],
        password: [{ validator: validatePass, trigger: "blur" }],
        pass: [{ validator: validatePass2, trigger: "blur" }],
        zip: [
          //   { required: true, message: "请输入邮政编码", trigger: "change" },
          { min: 6, max: 6, message: "长度为6个字符", trigger: "blur" },
        ],
        job: [{ required: true, message: "请输入职务", trigger: "blur" }],
        email: [
          //   { required: true, message: "请输入电子邮件", trigger: "blur" },
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
</style>