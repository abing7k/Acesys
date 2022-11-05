// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })
module.exports = {
  publicPath: './', // 公共路径 默认为"/"，建议使用"./"相对路径
  lintOnSave: false,
  pages: {
    index: {
      // 入口
      entry: 'src/main.js'
    }
  },
  // 配置src的@
  // configureWebpack: {
  //   resolve: {
  //     alias: {
  //       '@': 'src'
  //     }
  //   }
  // }
  // 配置代理跨域
  devServer: {
    proxy: {
      '/api': {
        // target: 'http://10.37.196.194:8080/',
        // target: 'http://47.99.49.255:8765/',
        target:"http://47.99.49.255:5678/",
        pathRewrite: { '^/api': '' }// 重写路径
      }
    }
  }
}

