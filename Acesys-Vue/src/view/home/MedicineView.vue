<template>
  <div>
    <div id="content">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>我的位置 &gt;&gt; 医药商务管理</td>
        </tr>
        <tr>
          <td><hr noshade="noshade" /></td>
        </tr>
        <tr>
          <td>商品信息</td>
        </tr>
      </table>
      <br />
      <div class="md_wenzi">
        某某提供全世界配药，生物科技和agroche
        mical药物研究&amp;发展的先进和新颖的中间体。
        我们的编目是最新与1500年药物象产品。
        超过五十种新的化合物每个月增加到产品名单。我们先进的中间体的宽广的类型，
        包括积木，新颖的胺物、被保护的胺物、不自然的氨基酸、酮、醋醛、heterocycles、isatoic酐、boroinc酸和手性
        的中间体可能加速您的药物研究过程。某某也提供半大块中间体(10公斤)，大块中间体(对吨)，使原材料和他们的
        中间体服麻醉剂进入合理的价格和优良品质。 请参观<a
          href="../product/products_showyk.html"
          >浏览产品页</a
        >。 <br />
        编目可以在网上被观看或者由<a href="../product/Product_Searchyk.html"
          >查询产品浏览产品</a
        >
        或您喜欢电子上接受我们的编目的(以PDF或SD格式)，请电子邮件我们.
      </div>
      <p>&nbsp;</p>
    </div>
    <div id="subcontent">
      <form name="form" method="post" action="./products1.html">
        <div class="small box">
          <login></login>
        </div>
      </form>
      <h2>最新商品列表</h2>
      <ul class="menublock">
        <li>
          <a href="#">西药</a
          ><a href="#"
            ><img src="./images/buy.gif" width="20" height="16" border="0"
          /></a>
        </li>
        <li>
          <a href="#">生化药</a
          ><a href="#"
            ><img src="./images/buy.gif" width="20" height="16" border="0"
          /></a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import login from "./login.vue";
export default {
  components: {
    login,
  },
};
</script>

<style lang="less" scoped>
</style>