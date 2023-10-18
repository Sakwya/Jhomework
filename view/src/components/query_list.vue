<template>
	<el-card :style="{borderRadius:'10px'}">
		<template #header>
			<div :style="{display:'flex'}">
				<el-text>
					<el-icon>
						<Grid />
					</el-icon>
					数据列表
				</el-text>
			</div>
		</template>
		<div :style="{display:'flex',justifyContent:'space-between'}">
			<div>
				<el-input v-model="query">
					<template #prepend>查询条件</template>
				</el-input>
			</div>
			<el-button type="warning" @click="get" style="margin-left: 12px;"><el-icon>
					<Search />
				</el-icon>
				查询</el-button>
			<div style="flex-grow: 1;" /><el-button type="primary" @click=""><el-icon>
					<Plus />
				</el-icon>
				新增</el-button>
			<el-button type="danger" @click=""><el-icon>
					<Close />
				</el-icon>
				删除</el-button>
		</div>
		<el-divider />
		<el-table :data="tableData" border stripe>
			<el-table-column prop="user_id" label="#" width="40" />
			<el-table-column type="selection" width="40" />
			<el-table-column prop="account" label="账号" />
			<el-table-column prop="user_name" label="名称" />
			<el-table-column prop="email" label="邮箱地址" />
			<!-- <el-table-column label="操作" /> -->
		</el-table>
	</el-card>
</template>

<script>
	// interface Employee{
	// 	user_id:String
	// 	account:String
	// 	user_name:String
	// 	email:String
	// }
	import {
		ref
	} from 'vue'
	export default {
		data() {
			return {
				query: '/employee/get/1',
				response: '',
				tableData: '',
			}
		},
		methods: {
			get() {
				window.$ = this
				var _this = this
				console.log(_this)
				console.log('do...')
				var request = '/employee/get/1'
				if (this.query != '') {
					request = this.query
				}
				this.$axios
					.get(request, {})
					.then(successResponse => {
						if (successResponse.status === 200) {
							console.log('success')
							_this.response = successResponse.data
							console.log(_this.response)
							this.set_tableData()
						}
					})
					.catch(failResponse => {

					})
			},
			set_tableData() {
				console.log(this.response)
				var rawData = this.response
				var tableData = []
				if (rawData.length == undefined) {
					//object
					tableData.push({
						user_id: rawData.user_id,
						account: rawData.account,
						user_name: rawData.user_name,
						email: rawData.email,
					})
				} else {
					//array
					for (let i = 0; i < rawData.length; i++) {
						tableData.push({
							user_id: rawData[i].user_id,
							account: rawData[i].account,
							user_name: rawData[i].user_name,
							email: rawData[i].email,
						})
					}
				}
				this.tableData = tableData
			}
		}
	}
</script>

<style>
</style>