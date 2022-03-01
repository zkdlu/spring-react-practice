<script>
    import { link } from "svelte-spa-router";
    import active from "svelte-spa-router/active";
</script>

<div class="container">
    <a class="tile" href="/jpa" use:link use:active> JPA </a>
    <a class="tile" href="/jpa" use:link use:active> Redis </a>
    <a class="tile" href="/jpa" use:link use:active> MongoDB </a>
</div>

<style>
</style>
