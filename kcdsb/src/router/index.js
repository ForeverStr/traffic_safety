import Vue from 'vue'
import Router from 'vue-router'
import Main from '../views/Main'
import equipment from '../views/equipment.vue'
import environment from '../views/vehicle.vue'
import way from '../views/way'
import exception from '../views/features.vue'
import Login from '../views/Login'
import Front from '../views/Front'
import BaiduMap from 'vue-baidu-map'
import Register from '../views/Register'
import map from "../views/map.vue";
import ill from "../views/fault.vue";
import About from "../views/About.vue";
Vue.use(Router);
Vue.use(BaiduMap, {
    // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
    ak: 'ztu4kVBu2FhG1F2xRmcdilimgVlNiSo9'
})

export default new Router({
    routes: [{
        // 首页
        path: '/main',
        name: 'Main',
        component: Main,
        children: [
            {
                // 设备信息页
                path: '/equipment',
                name: 'equipment',
                component: equipment
            },
            {
                // 管理人员页
                path: '/environment',
                name: 'environment',
                component: environment
            },
            {  //流量信息页
                path: '/way',
                name: 'way',
                component: way
            },
            {
                // 违规记录页
                path: '/ill',
                name: 'ill',
                component: ill
            },
            {
                // 申请记录页
                path: '/exception',
                name: 'exception',
                component: exception
            },
            {   //地图导航页
                path: '/map',
                name: 'map',
                component: map
            },

        ]
        },

        {
        // 登录界面
        path: '/login',
        name: 'Login',
        component: Login,
        },
        {
        //首页
        path: '/front',
        name: 'Front',
        component: Front,
        },
        {
            path:'/',
            redirect:'/front'　　//默认显示
        },
        {
            // 注册界面
            path: '/register',
            name: 'register',
            component: Register,
        },
        {
          path: '/about',
          name: 'about',
          component: About
        },
    ]
})
