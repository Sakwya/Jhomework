<template>
	<el-menu :default-active="activeIndex" mode="horizontal" :ellipsis="false">
		<el-menu-item class="is-active" index="0">
			用户权限管理系统
		</el-menu-item>
		<div style="flex-grow: 1;" />
		<el-sub-menu index="1">
			<template #title>张三</template>
			<el-menu-item index="1-1"><el-icon><Tools /></el-icon>个人设置</el-menu-item>
			<el-menu-item index="1-2"><el-icon><Message /></el-icon>消息</el-menu-item>
			<el-menu-item index="1-3"><el-icon><SwitchButton /></el-icon>退出系统</el-menu-item>
		</el-sub-menu>
		<el-menu-item index="2" >
			<el-icon>
				<QuestionFilled />
			</el-icon><span>反馈</span>
		</el-menu-item>
			
	</el-menu>
</template>

<script>
</script>

<style>
</style>