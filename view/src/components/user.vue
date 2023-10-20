<template>
	<el-container>
		<el-header :style="{padding:0}">
			<head-bar></head-bar>
		</el-header>
		<el-container>
			<el-aside :style="{padding:'20px'}">
				<side-bar></side-bar>
			</el-aside>
			<el-main>
				<query-list :api="api" :attrs="attrs" :attrs_="attrs_"></query-list>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	export default {
		data() {
			return {
				api: "/employee/",
				attrs: [{
						prop: "user_id",
						label: "#",
						width: "auto",
					}, {
						type: "selection",
						width: "auto",
					},
					{
						prop: "account",
						label: "账号",
					}, {
						prop: "user_name",
						label: "名称",
					}, {
						prop: "email",
						label: "邮箱地址",
					}
				],
				attrs_: [{
						prop: "account",
						label: "账号",
						data:"",
					}, {
						prop: "user_name",
						label: "名称",
						data:"",
					},
					{
						prop: "password",
						label: "密码",
						data:"",
					}, {
						prop: "email",
						label: "邮箱地址",
						data:"",
					}
				],
			}
		},
		methods: {}
	}
</script>

<style>
</style>