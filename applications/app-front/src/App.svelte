<script>
	import Router from "svelte-spa-router";
	import Header from "./components/Header.svelte";
	import routes from "./routes";
</script>

<main>
	<Header />
	<div class="container">
		<Router {routes} />
	</div>
</main>

<style>
	:global(.container) {
		display: grid;
		grid-template-columns: 120px 120px 120px;
		grid-template-rows: 120px 120px 120px;
	}
</style>
