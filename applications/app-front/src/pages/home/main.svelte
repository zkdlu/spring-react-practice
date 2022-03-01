<script>
    import { link } from "svelte-spa-router";
    import active from "svelte-spa-router/active";
</script>

<div class="container">
    <a class="tile" href="/cloud" use:link use:active> Cloud </a>
    <a class="tile" href="/data" use:link use:active> Data </a>

    <a class="tile" href="/web" use:link use:active> Web </a>
    <a class="tile" href="/security" use:link use:active> Security </a>
    <a class="tile" href="/reactive" use:link use:active> Reactive </a>
    <a class="tile" href="/batch" use:link use:active> Batch </a>
    <a class="tile" href="/messaging" use:link use:active> Messaging </a>
</div>

<style>
   
</style>