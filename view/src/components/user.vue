<template>
	<el-container>
		<el-header :style="{padding:0}">
			<head-bar></head-bar>
		</el-header>
		<el-container>
			<el-aside>
			<side-bar></side-bar>
			</el-aside>
			<el-main>
				<input v-model="msg" type="text" />
				<button v-on:click="get">点我</button>
				<span>{{response}}</span>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	export default {
		name: 'get',
		data() {
			return {
				msg: '/employee/get/1',
				response: ''
			}
		},
		methods: {
			get() {
				var request = '/employee/get/1'
				if (this.msg != '') {
					request = this.msg
				}
				this.$axios
					.get(request, {})
					.then(successResponse => {
						if (successResponse.status === 200) {
							this.response = successResponse.data
							console.log(this.response)
						}
					})
					.catch(failResponse => {})
			}
		}
	}
</script>

<style>
</style>