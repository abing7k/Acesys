<template>
  <div>
    <div id="content2" style="margin: 0px; width: 650px">
      <div v-if="show">
        <div>管理员邮箱:</div>
        <div>发件地址:{{ mail.fromaddress }}</div>
        <div>收件地址:{{ mail.toaddress }}</div>
        <div>如果想修改，请进行下面的操作</div>
      </div>
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="150px"
        class="demo-ruleForm"
        size="mini"
      >
        <el-form-item label="发件Email地址" prop="fromaddress">
          <el-input v-model="ruleForm.fromaddress"></el-input>
        </el-form-item>
        <el-form-item label="发件Email密码" prop="frompassword">
          <el-input v-model="ruleForm.frompassword"></el-input>
        </el-form-item>
        <el-form-item label="收件Email地址" prop="toaddress">
          <el-input v-model="ruleForm.toaddress"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')"
            >提交</el-button
          >
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
      <div>
        <br />
        帮助：<br />
        &lt;1&gt;请正确的设置发件箱地址及密码，该邮件是负责发送邮件的地址<br />
        &lt;2&gt;请正确的设置收件箱地址，该邮件是接收邮件的地址，当客户在<br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结算中心提交后，邮件会发送到该邮件<br />
        &lt;3&gt;试运行时请重新设置自己的邮箱，库中邮件地址您无法查看测试
      </div>
      <br />
      <div class="table_wz"></div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: true,
      mail: {
        fromaddress: "", //发件地址
        frompassword: "", //发件密码
        toaddress: "",
      },
      ruleForm: {
        fromaddress: "", //发件地址
        frompassword: "", //发件密码
        toaddress: "",
        id: JSON.parse(localStorage.getItem("userdata")).id,
      },
      rules: {
        fromaddress: [
          { required: true, message: "请输入发件地址", trigger: "blur" },
          {
            pattern:
              /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g,
            message: "请输入正确的邮箱",
            trigger: "blur",
          },
        ],
        frompassword: [
          { required: true, message: "请输入发件密码", trigger: "change" },
          // {
          //   pattern:
          //     /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g,
          //   message: "请输入正确的邮箱",
          //   trigger: "blur",
          // },
        ],
        toaddress: [
          { required: true, message: "请输入收件地址", trigger: "change" },
          {
            pattern:
              /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g,
            message: "请输入正确的邮箱",
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    submitForm(ruleForm) {
      this.$refs[ruleForm].validate(async (valid) => {
        if (valid) {
          const result = await this.$http.post("/admin/updateEmail", this.ruleForm);
          console.log(result.data + "修改邮箱");
          if (result.data.code == 200) {
            this.$message.success(result.data.messges);
            this.getMailManage();
          } else {
            this.$message.error(result.data.messges);
          }
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(ruleForm) {
      this.$refs.ruleForm.resetFields();
    },
    async getMailManage() {
      const result = await this.$http.get("/admin/showEmail");
      // console.log(result.data + "遍历邮箱");
      if (result.data.code == 200) {
        this.mail = result.data.obj[0];
      } else {
        this.$message.error(result.data.messges);
      }
    },
  },
  mounted() {
    this.getMailManage();
    console.log(this.mail)
    if (this.mail) {
      this.show = true;
    }
  },
};
</script>

<style scoped lang="less">
.demo-ruleForm {
  margin-top: 10px;
  .el-input {
    width: 200px;
  }
}
</style>