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
        >用户列表</el-breadcrumb-item
      >
      <el-breadcrumb-item class="breadcrumb-text">{{
        activeName
      }}</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 表单 -->
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
      <el-form-item label="全名" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="城市" prop="city">
        <el-input v-model="ruleForm.city"></el-input>
      </el-form-item>
      <el-form-item label="称呼" prop="title">
        <el-input v-model="ruleForm.title"></el-input>
      </el-form-item>
      <el-form-item label="电话" prop="tel">
        <el-input v-model="ruleForm.tel"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item label="邮政编码" prop="zip">
        <el-input v-model="ruleForm.zip"></el-input>
      </el-form-item>
      <el-form-item label="职务" prop="job">
        <el-input v-model="ruleForm.job"></el-input>
      </el-form-item>
      <el-form-item label="电子邮件" prop="email">
        <el-input v-model="ruleForm.email"></el-input>
      </el-form-item>
      <el-form-item label="国家" prop="country">
        <el-input v-model="ruleForm.country"></el-input>
      </el-form-item>
      <el-form-item label="公司名称" prop="companyname">
        <el-input v-model="ruleForm.companyname"></el-input>
      </el-form-item>
      <el-form-item label="公司地址" prop="companyaddress">
        <el-input v-model="ruleForm.companyaddress"></el-input>
      </el-form-item>
      <el-form-item label="角色">
        <el-select v-model="ruleForm.roles" placeholder="请选择权限">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          >
          </el-option>
        </el-select>
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
    console.log(this.$route.query.updateuser);
    this.ruleForm = this.$route.query.updateuser;
    this.ruleForm.password = "";
  },
  data() {
    return {
      activeName: "用户信息",
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
        id: null,
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
          { required: true, message: "请输入用户名", trigger: "blur" },
          //   { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
        // fullname: [{ required: true, message: "请输入全名", trigger: "blur" }],
        // city: [{ required: true, message: "请输入城市", trigger: "blur" }],
        // title: [{ required: true, message: "请输入称呼", trigger: "blur" }],
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
          // { required: true, message: "请输入邮政编码", trigger: "change" },
          { min: 6, max: 6, message: "长度为6个字符", trigger: "blur" },
        ],
        job: [
          // { required: true, message: "请输入职务", trigger: "blur" }
        ],
        email: [
          // { required: true, message: "请输入电子邮件", trigger: "blur" },
          {
            pattern:
              /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g,
            message: "请输入正确的邮箱",
            trigger: "blur",
          },
        ],
        country: [
          // { required: true, message: "请输入国家", trigger: "blur" }
        ],
        companyname: [
          // { required: true, message: "请输入公司名称", trigger: "blur" },
        ],
        companyaddress: [
          // { required: true, message: "请输入公司地址", trigger: "blur" },
        ],
        note: [
          // { required: true, message: "请填写备注", trigger: "blur" }
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          const result = await this.$http.post("/admin/updateUsr", this.ruleForm);
          console.log(result.data + "修改用户信息");
          if (result.data.code == 200) {
            this.$message.success(result.data.messges);
            this.$router.go(-1);
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