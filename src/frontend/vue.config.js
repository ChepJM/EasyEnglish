module.exports = {
  // https://cli.vuejs.org/config/#devserver-proxy
  devServer: {
    port: 81,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        ws: true,
        changeOrigin: true
      }
    }
  }
}