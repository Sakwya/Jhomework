import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import * as axios from 'axios'
import side_bar from './components/side_bar.vue'
import head_bar from './components/head_bar.vue'
import query_list from './components/query_list.vue'

axios.defaults.baseURL = 'http://localhost:8081/api'


const app = createApp(App).use(router).use(ElementPlus)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}
app.config.globalProperties.$axios = axios
app.mount('#app')
app.component('side-bar',side_bar)
app.component('head-bar',head_bar)
app.component('query-list',query_list)