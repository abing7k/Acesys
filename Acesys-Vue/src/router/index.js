import Vue from "vue";
import VueRouter from "vue-router";
Vue.use(VueRouter);
// 路由目录
const routes = [
  {
    path: "/",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "pageheader",
        component: () => import("@/view/home/page.vue"),
      },
      {
        path: "/IT",
        name: "IT",
        component: () => import("@/view/home/ITView.vue"),
      },
      {
        path: "/staff",
        name: "staff",
        component: () => import("@/view/home/StaffView.vue"),
      },
      {
        path: "/medicine",
        name: "medicine",
        component: () => import("@/view/home/MedicineView.vue"),
      },
      {
        path: "/about",
        name: "about",
        component: () => import("@/view/home/AboutView.vue"),
      },
      {
        path: "/register",
        name: "register",
        component: () => import("@/view/home/register.vue"),
      },
    ],
  },
  {
    path: "/admin",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "userlist",
        component: () => import("@/view/admin/index.vue"),
      },
    ],
  },
  {
    path: "/admin/adminorderitem",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "adminorderitem",
        component: () => import("@/view/admin/adminorderitem.vue"),
      },
    ],
  },
  {
    path: "/admin/updateproductuser",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "updateproductuser",
        component: () => import("@/view/admin/updateproductuser.vue"),
      },
    ],
  },
  {
    path: "/admin/updateproducts",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "updateproducts",
        component: () => import("@/view/admin/updateproducts.vue"),
      },
    ],
  },
  {
    path: "/user",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "user",
        component: () => import("@/view/user/UserlistView.vue"),
      },
    ],
  },
  {
    path: "/user/search",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "search",
        component: () => import("@/view/user/searchList.vue"),
      },
    ],
  },
  {
    path: "/user/orderdetail",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "orderlistdetail",
        component: () => import("@/view/user/orderlistdetail.vue"),
      },
    ],
  },
  {
    path: "/tourist",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "tourist",
        component: () => import("@/view/tourist/ProductView.vue"),
      },
    ],
  },
];
const routers = new VueRouter({
  routes,
});
// 全局守卫，前置守卫（在路由跳转之前判断）
// routers.beforeEach(async (to, from, next) => {
//   var userinfo = JSON.parse(localStorage.getItem("userdata"));
//   console.log(userinfo);
//   if (userinfo) {
//     // 用户已经登录了，但是想去登录页面和注册页面不行，只能退出登录
//     if (to.path === "/login" || to.path === "/register") {
//       next("/page");
//     } else {
//       next();
//     }
//   } else {
//     const toPath = to.path;
//     if (
//       toPath.indexOf("/post") !== -1 ||
//       toPath.indexOf("/article") !== -1 ||
//       toPath.indexOf("/person") !== -1 ||
//       toPath.indexOf("/videoplay") !== -1 ||
//       toPath.indexOf("/myarticle") !== -1 ||
//       toPath.indexOf("/myplayer") !== -1 ||
//       toPath.indexOf("/edit") !== -1
//     ) {
//       next("/login?redirect=" + toPath);
//       // next()
//     } else {
//       next();
//     }
//   }
// });
export default routers;
