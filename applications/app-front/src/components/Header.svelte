<script>
    import { link } from "svelte-spa-router";
    import active from "svelte-spa-router/active";
</script>

<header>
    <a href="/" use:link use:active> Home </a>
    <a href="/cloud" use:link use:active> Cloud </a>
</header>

<style>
    :global(header a.active) {
        font-weight: bold;
        text-decoration: underline;
    }
</style>