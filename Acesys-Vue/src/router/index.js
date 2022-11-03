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
];
const routers = new VueRouter({
  routes,
});
// 全局守卫，前置守卫（在路由跳转之前判断）
// routers.beforeEach(async (to, from, next) => {
//   // to:获取到要跳转到的路由信息
//   // console.warn(from)
//   // from：获取到从哪个路由跳转过来来的信息
//   // next: next() 放行  next(path) 放行
//   // console.log(next())
//   // console.log(to.path)
//   const token = store.state.user.token
//   // await store.dispatch('getUserInfo', token)
//   const name = store.state.user.userInfo.name
//   console.log(token)
//   console.log(name)
//   if (name) {
//     // console.log('用户已经登录')
//     // 用户已经登录了，但是想去登录页面和注册页面不行，只能退出登录
//     if (to.path === '/login' || to.path === '/register') {
//       next('/my')
//       // next()
//     } else {
//       // 登陆了且没有用户信息
//       // 在路由跳转之前获取用户信息且放行
//       try {
//         await store.dispatch('getUserInfo', token)
//         next()
//       } catch (error) {
//         // token失效从新登录
//         await store.dispatch('userLogout', token)
//         next('/login')
//         // next()
//       }
//       // next()// 放行
//     }
//     // next()
//   } else {
//     console.log('用户未登录')
//     // 未登录：不能去【/publish(我发布的)|/edituser（编辑个人资料页面）|/attention(我的关注页面)|/submitpublish（发布文章页面）|/collect(我的收藏)/changepwd(修改密码)】
//     // 并跳转至登录路由
//     const toPath = to.path
//     // console.log(toPath)
//     // 路径中有这种路由，则跳转至登录页面，否则放行
//     if (
//       toPath.indexOf('/publish') !== -1 ||
//       toPath.indexOf('/edituser') !== -1 ||
//       toPath.indexOf('/attention') !== -1 ||
//       toPath.indexOf('/submitpublish') !== -1 ||
//       toPath.indexOf('/collect') !== -1 ||
//       toPath.indexOf('/changepwd') !== -1 ||
//       toPath.indexOf('/articlesdetail') !== -1
//     ) {
//       next('/login?redirect=' + toPath)
//       // next()
//     } else {
//       next()
//     }
//   }
// })
export default routers;
