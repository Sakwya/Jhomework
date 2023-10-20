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
				<query-list></query-list>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	export default {
		data() {
			return {
			}
		},
		methods: {
		}
	}
</script>

<style>
</style>