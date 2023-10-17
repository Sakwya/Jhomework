<template>
	<div :style="frame">
		<div :style="line"></div>
		<div :style="entry">
			<span  v-on:click="opener">权限管理</span>
			<ul :style="list">
				<li :style="link">
					<a>用户维护</a>
				</li>
				<li :style="link">
					角色维护
				</li>
				<li :style="link">
					权限维护
				</li>
			</ul>
		</div>

		<div :style="line"></div>
		<div :style="line"></div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				frame: {
					width: '300px',
					display: 'inline-block',
					border: '1px solid #dddddd',
					backgroundColor: '#ffffff',
					borderRadius: '10px',
					padding: '20px',
				},
				entry:{
					padding:'10px',
					
					
				},
				list: {
					paddingLeft:'30px',
					listStyle: 'none',
				},
				link: {

				},
				line: {
					width: '100%',
					height: '1px',
					backgroundColor: '#dddddd',
				}
			}
		}
	}
</script>

<style>
</style>