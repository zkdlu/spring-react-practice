<script>
	import Router from "svelte-spa-router";
	import Header from "./components/Header.svelte";
	import routes from "./routes";
</script>

<Header />
<Router {routes} />

<style>
</style>
