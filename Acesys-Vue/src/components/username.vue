<template>
  <div>
    <span>| 欢迎，{{ username }} | </span>
    <el-button type="text" @click="open"> 注销 </el-button>
  </div>
</template>

<script>
export default {
  name: "username",
  data() {
    return {
      username: "游客",
    };
  },
  mounted(){
    const userdata = JSON.parse(localStorage.getItem("userdata"))
    console.log(JSON.parse(localStorage.getItem("userdata")))
    this.username = userdata.username
  },
  methods: {
    open() {
      localStorage.removeItem("userdata")
      localStorage.removeItem("tokenHead")
      localStorage.removeItem("token")
      this.$router.push("/")
    },
    userdata() {
        // 未登录显示游客的字眼
        // 登录之后，显示用户名
    },
  },
};
</script>

<style>
</style>