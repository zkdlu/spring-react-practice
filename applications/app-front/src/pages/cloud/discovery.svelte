<script>
    import { onMount } from "svelte";
    import api from "../../api";

    let services = [];

    async function fetchServices() {
        let fetchedServices = [];
        const json = await api.get("http://localhost:8761/services");

        fetchedServices.push(...json);

        services = fetchedServices;
    }

    onMount(async () => {
        await fetchServices();
    });
</script>


    <ul>
        {#each services as serviceName}
            <li> {serviceName} </li>
        {/each}
    </ul>

<style>
   
</style>
