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
			<div style="flex-grow: 1;" /><el-button type="primary" @click="dialogVisable=true"><el-icon>
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
			<el-table-column v-for="(c,index) in attrs" :key="index" :type="c.type" :prop="c.prop" :label="c.label"
				:width="c.width"></el-table-column>
			<!-- <el-table-column label="操作" /> -->
		</el-table>
	</el-card>
	<el-dialog title="新增数据" v-model="dialogVisable" width="600px" :style="{borderRadius:'10px'}">
		<el-form :model="formData" label-width="auto" label-suffix=":">
			<el-form-item v-for="(f,index) in attrs_" :key="index" :prop="f.prop" :label="f.label">
				<el-input v-model="formData[f.prop]"></el-input>
			</el-form-item>
		</el-form>
		<template #footer>
			<span>
				<el-button @click="dialogVisable = false">取消</el-button>
				<el-button type="primary" @click="insert();dialogVisable = false">
					提交
				</el-button>
			</span>
		</template>
	</el-dialog>
</template>

<script>
import { ElMessage } from 'element-plus'
	export default {
		name: "query_list",
		props: ['attrs', 'attrs_', 'api'],
		data() {
			return {
				formData: {},
				dialogVisable: false,
				query: '/show',
				response: '',
				tableData: '',
			}
		},
		methods: {
			get() {
				var _this = this
				var request = this.api + this.query
				this.$axios
					.get(request, {})
					.then(successResponse => {
						if (successResponse.status === 200) {
							_this.response = successResponse.data
							console.log(_this.response)
							this.set_tableData()
							ElMessage({
								showClose:true,
								message:'刷新数据',
								type:'success',
							})
						}
					})
					.catch(failResponse => {

					})
			},
			insert() {
				var request = this.api + '/insert'
				console.log(request)
				console.log(this.formData)
				this.$axios
				.post(request,this.formData)
				.then(successResponse => {
						if (successResponse.status === 200) {
							ElMessage({
								showClose:true,
								message:'新增数据成功',
								type:'success',
							})
							this.get()
							console.log(successResponse)
							console.log(successResponse.data)
						}
					})
					.catch(failResponse => {
						
					})
			},
			set_tableData() {
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
		},
		mounted() {
			window.$ = this
			this.get()
		},
	}
</script>

<style>
</style>