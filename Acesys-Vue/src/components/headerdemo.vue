<template>
  <div>
    <div id="header">
      <h1>加拿大·亚思晟科技</h1>
      <h2>Quality is everything!</h2>
    </div>

    <div id="navigation">
      <ul>
        <!-- <li class="selected"></li> -->
        <li @click="toheader('/')">首页</li>
        <li @click="toheader('/IT')">IT服务</li>
        <li @click="toheader('/staff')">医药商务系统</li>
        <li @click="toheader('/medicine')">员工招聘</li>
        <li @click="toheader('/about')">关于我们</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "headerdemo",
  methods: {
    toheader(data) {
      this.$router.push(data);
    },
  },
};
</script>

<style lang="less" scoped>
#navigation {
  height: 2.5em;
  line-height: 2.5em;
  width: 758px;
  margin: 0 1px;
  background: #578bb8;
  color: #ffffff;
}

#navigation li {
  float: left;
  list-style-type: none;
  border-right: 1px solid #ffffff;
  white-space: nowrap;
  min-width:50px;
  padding: 0.2em;
  text-align: center;
}

#navigation li a {
  display: block;
  padding: 0 10px;
  font-size: 0.8em;
  font-weight: normal;
  text-transform: uppercase;
  text-decoration: none;
  background-color: inherit;
  color: #ffffff;
}

* html #navigation a {
  width: 1%;
}

#navigation .selected,
#navigation a:hover {
  background: #80b0da;
  color: #ffffff;
  text-decoration: none;
  font-size: 12px;
}
</style>