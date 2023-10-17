import {
	createRouter,
	createWebHistory
} from 'vue-router'
import User from '@/components/user.vue'


const routes = [{
	path: '/user',
	name: 'user',
	component: User
}]
const router = createRouter(({
	history: createWebHistory(),
	routes: routes
}))
export default router