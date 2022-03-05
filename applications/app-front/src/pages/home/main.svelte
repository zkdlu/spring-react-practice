<script>
    import { onMount } from "svelte";

    import { link } from "svelte-spa-router";
    import active from "svelte-spa-router/active";

    onMount(() => {
        const socket = new WebSocket("ws://localhost:8080/ws-stomp");
        socket.onopen = () => {
            console.log("Opened");
            socket.send("hihi");
        };
        socket.onmessage = (message) => {
            console.log(message);
        };
    });

    import api from "../../api";

    let services = [];

    async function fetchServices() {
        let fetchedServices = [];
        const json = await api.get("services");

        fetchedServices.push(...json);

        services = fetchedServices;
    }

    onMount(async () => {
        await fetchServices();
    });
</script>

<div class="container">
    {#each services as serviceName}
        <a class="tile" href="#/discovery/{serviceName}">{serviceName}</a>
    {/each}
</div>

<style>
    .tile {
        width: 200px;
        height: 100px;
    }
</style>
