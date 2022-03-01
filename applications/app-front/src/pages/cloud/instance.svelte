<script>
    import { onMount } from "svelte";
    import api from "../../api";

    export let params = {};

    let instances = [];

    async function fetchInstance() {
        let fetchedInstances = [];
        const json = await api.get(
            `http://localhost:8761/services/${params.id}`
        );

        fetchedInstances.push(...json);

        instances = fetchedInstances;

        console.log(instances);
    }

    onMount(async () => {
        await fetchInstance();
    });
</script>

<table border="1" frame="void" rules="all">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>URL</th>
        </tr>
    </thead>
    <tbody>
        {#each instances as instance}
            <tr>
                <td>{instance.id}</td>
                <td>{instance.name}</td>
                <td>{instance.url}</td>
            </tr>
        {/each}
    </tbody>
</table>

<style>
</style>
