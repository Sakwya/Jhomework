import {
	createRouter,
	createWebHistory
} from 'vue-router'
import Index from '../components/index.vue'
import User from '../components/user.vue'
import Role from '../components/role.vue'

const routes = [{
	path: '/',
	name: 'index',
	component: Index,
}, {
	path: '/user',
	name: 'user',
	component: User,
},{
	path: '/role',
	name:'role',
	component: Role,
}]

const router = createRouter(({
	history: createWebHistory(),
	routes: routes
}))
export default router