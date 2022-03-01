<script>
    import { onMount } from "svelte";
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


{#each services as serviceName}
    <a class="tile" href="#/discovery/{serviceName}">{serviceName}</a>
{/each}

<style>
   	.tile {
        width: 200px;
        height: 100px;
    }
</style>
