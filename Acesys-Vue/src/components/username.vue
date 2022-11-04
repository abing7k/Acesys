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
      username: "123",
    };
  },
  methods: {
    open() {},
    userdata() {
        // 未登录显示游客的字眼
        // 登录之后，显示用户名
    },
  },
};
</script>

<style>
</style>