<template>
	<div :style="frame">
		<div :style="line"></div>
		<div :style="entry">
			<span v-on:click="opener"><i></i>权限管理</span>
			<ul :style="list">
				<li :style="link" class="qhduioqwhiu">
					<a>用户维护</a>
				</li>
				<li :style="link" class="qhduioqwhiu">
					角色维护
				</li>
				<li :style="link" class="qhduioqwhiu">
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
					border: '1px solid #dddddd',
					backgroundColor: '#ffffff',
					borderRadius: '10px',
					padding: '20px',
				},
				entry: {
					textAlign: 'left',
					width: '100%',
					display: 'inline-block',

				},
				list: {
					listStyle: 'none',
				},
				link: {
					paddingLeft: '30px',

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
	* {}
	.qhduioqwhiu{
		transition: background-color 0.2s ease-in-out;
	}
	.qhduioqwhiu:hover {
		background-color: #dddddd;
	}
</style>