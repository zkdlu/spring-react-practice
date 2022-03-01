<script>
    import { onMount } from "svelte";

    import api from "../../api";

    let members = [];

    async function insert() {
        await api.get("data/jpa/insert");

        await fetchMember();
    }

    async function fetchMember() {
        const fetchedMembers = [];
        const json = await api.get("data/jpa/list");
        fetchedMembers.push(...json);

        members = fetchedMembers;
    }

    onMount(() => {
        fetchMember();
    });
</script>

<button on:click={insert}>insert</button>

<table border="1" frame="void" rules="all">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
    </thead>
    <tbody>
        {#each members as member}
            <tr>
                <td>{member.id}</td>
                <td>{member.name}</td>
            </tr>
        {/each}
    </tbody>
</table>

<style>
</style>
