import Vue from "vue";
import VueRouter from "vue-router";
import { Message } from 'element-ui';
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
        meta: { requireAuth: false, roles: ["会员", "管理员", "游客"] },
      },
      {
        path: "/IT",
        name: "IT",
        component: () => import("@/view/home/ITView.vue"),
        meta: { requireAuth: false, roles: ["会员", "管理员", "游客"] },
      },
      {
        path: "/staff",
        name: "staff",
        component: () => import("@/view/home/StaffView.vue"),
        meta: { requireAuth: false, roles: ["会员", "管理员", "游客"] },
      },
      {
        path: "/medicine",
        name: "medicine",
        component: () => import("@/view/home/MedicineView.vue"),
        meta: { requireAuth: false, roles: ["会员", "管理员", "游客"] },
      },
      {
        path: "/about",
        name: "about",
        component: () => import("@/view/home/AboutView.vue"),
        meta: { requireAuth: false, roles: ["会员", "管理员", "游客"] },
      },
      {
        path: "/register",
        name: "register",
        component: () => import("@/view/home/register.vue"),
        meta: { requireAuth: false, roles: ["会员", "管理员", "游客"] },
      },
    ],
    meta: { requireAuth: false, roles: ["会员", "管理员", "游客"] },
  },
  {
    path: "/admin",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "userlist",
        component: () => import("@/view/admin/index.vue"),
        meta: { requireAuth: true, roles: ["管理员"] },
      },
    ],
    meta: { requireAuth: true, roles: ["管理员"] },
  },
  {
    path: "/admin/adminorderitem",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "adminorderitem",
        component: () => import("@/view/admin/adminorderitem.vue"),
        meta: { requireAuth: true, roles: ["管理员"] },
      },
    ],
    meta: { requireAuth: true, roles: ["管理员"] },
  },
  {
    path: "/admin/updateproductuser",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "updateproductuser",
        component: () => import("@/view/admin/updateproductuser.vue"),
        meta: { requireAuth: true, roles: ["管理员"] },
      },
    ],
    meta: { requireAuth: true, roles: ["管理员"] },
  },
  {
    path: "/admin/updateproducts",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "updateproducts",
        component: () => import("@/view/admin/updateproducts.vue"),
        meta: { requireAuth: true, roles: ["管理员"] },
      },
      {
        path: "user",
        name: "userlist2",
        component: () => import("@/view/user/UserlistView.vue"),
        meta: { requireAuth: true, roles: ["管理员"] },
      },
    ],
    meta: { requireAuth: true, roles: ["管理员"] },
  },
  {
    path: "/user",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "user",
        component: () => import("@/view/user/UserlistView.vue"),
        meta: { requireAuth: true, roles: ["会员","管理员"] },
      },
    ],
    meta: { requireAuth: true, roles: ["会员","管理员"] },
  },
  {
    path: "/user/search",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "search",
        component: () => import("@/view/user/searchList.vue"),
        meta: { requireAuth: true, roles: ["会员","管理员"] },
      },
    ],
    meta: { requireAuth: true, roles: ["会员","管理员"] },
  },
  {
    path: "/user/orderdetail",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "orderlistdetail",
        component: () => import("@/view/user/orderlistdetail.vue"),
        meta: { requireAuth: true, roles: ["会员","管理员"] },
      },
    ],
    meta: { requireAuth: true, roles: ["会员","管理员"] },
  },
  {
    path: "/tourist",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "tourist",
        component: () => import("@/view/tourist/ProductView.vue"),
        meta: { requireAuth: false, roles: ["游客","管理员"] },
      },
    ],
    meta: { requireAuth: false, roles: ["游客","管理员"] },
  },
  {
    path: "/tourist/search",
    component: () => import("@/view/home"),
    children: [
      {
        path: "/",
        name: "search",
        component: () => import("@/view/tourist/searchList.vue"),
        meta: { requireAuth: false, roles: ["游客","管理员"] },
      },
    ],
    meta: { requireAuth: false, roles: ["游客","管理员"] },
  },
];
const routers = new VueRouter({
  routes,
});
// 全局守卫，前置守卫（在路由跳转之前判断）
// routers.beforeEach(async (to, from, next) => {
//   var userinfo =  JSON.parse(localStorage.getItem("userdata"))
//   console.log(userinfo);
//   if (userinfo) {
//     // 用户已经登录了，但是想去登录页面和注册页面不行，只能退出登录
//     if (to.path === "/register") {
//       next("/medicine");
//     } else {
//       next();
//       if(userinfo.roles=="管理员"){

//       }
//     }
//   } else {
//     const toPath = to.path;
//     if (
//       toPath.indexOf("/admin") !== -1 ||
//       toPath.indexOf("/user") !== -1 ||
//       toPath.indexOf("/tourist") !== -1 ||
//       toPath.indexOf("/admin/adminorderitem") !== -1 ||
//       toPath.indexOf("/admin/updateproductuser") !== -1 ||
//       toPath.indexOf("/admin/updateproducts") !== -1 ||
//       toPath.indexOf("/user/search") !== -1 ||
//       toPath.indexOf("/user/orderdetail") !== -1
//     ) {
//       next("/medicine?redirect=" + toPath);
//       // next()
//     } else {
//       next();
//     }
//   }
// });
routers.beforeEach((to, from, next) => {
  //router.beforeEach一般用来做一些进入页面的限制
  // console.log("上一个页面：", from);
  // console.log("下一个页面：", to);
  // let userToken = localStorage.getItem('userToken')
  const userdata = JSON.parse(localStorage.getItem("userdata"));
  console.log(JSON.parse("12",localStorage.getItem("userdata")));
  console.log(to.meta.roles);
  if (to.meta.requireAuth) {
    // 1)判断该路由是否需要登录权限
    if (userdata) {
      if (to.meta.roles.length !== 0) {
        //下一个页面的rules是否与当前token相等
        let role = JSON.parse(localStorage.getItem("userdata")).roles;
        for (let i = 0; i < to.meta.roles.length; i++) {
          if (role === to.meta.roles[i]) {
            // console.warn("333")
            next(); //角色匹配已登录，正常进入to.meta.roles[i]的页面
            break;
          } else if (i === to.meta.roles.length - 1) {
            // console.warn("444")
            next({ path: "/medicine" });
          }
        }
      } else {
        next();
      }
    } else {
      // next('/medicine?redirect=' + to.path)
      // console.warn("111")
      // this.$message.error("当前用户无权限")
      Message("当前用户无权限")
      next('/medicine?redirect=' + to.path)
    }
  } else {
    // console.warn("222")
    next();
    // next('/medicine?redirect=' + to.path)
  }
});
export default routers;
