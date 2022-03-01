<script>
	import Router from "svelte-spa-router";
	import Header from "./components/Header.svelte";
	import routes from "./routes";
</script>

<main>
	<Header />
	<Router {routes} />
</main>

<style>
	:global(.tile) {
        border: 1px solid black;
        background-color:cornsilk;
        width: 100px;
        height: 100px;
        text-align: center;
        display: block;
    }
    
    :global(.tile:hover) {
        border: 2px solid black;
        background-color:bisque;
    }
</style>
