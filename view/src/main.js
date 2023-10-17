import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import * as axios from 'axios'
import side_bar from './components/side_bar.vue'

axios.defaults.baseURL = 'http://localhost:8081/api'


const app = createApp(App).use(router)
app.config.globalProperties.$axios = axios
app.mount('#app')
app.component('side_bar',side_bar)