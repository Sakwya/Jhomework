import {
	defineConfig
} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
	plugins: [vue()],
	server: {
		host: 'localhost',
		port: 8080,
		strictPort: true,
		https:  false,
		open: true,
		proxy: { // 配置自定义代理规则
			'/api': {
				target: 'localhost',
				port: 8081,
				changeOrigin: true,
				rewrite: (path) => path.replace(/^\/api/, ''),
				ws: true, //WebSocket
			}
		}
	}

})