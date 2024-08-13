// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import router from './router'
import ElementUI, { Pagination } from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './components/Aside.vue'
import './assets/css/login.css';
import './assets/css/front.css';
import Vuex from 'vuex';
import request from "./utils/request";


Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(ElementUI);
Vue.use(Vuex);
Vue.prototype.request=request

//设置反向代理，前端请求默认发送到 http://前端ip地址:你的前端端口/api

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
