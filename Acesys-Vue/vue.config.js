// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })
module.exports = {
  publicPath: './', // 公共路径 默认为"/"，建议使用"./"相对路径
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
        target: 'http://192.168.43.41:9060/HeartKnow',
        pathRewrite: { '^/api': '' }// 重写路径
      }
    }
  }
}

