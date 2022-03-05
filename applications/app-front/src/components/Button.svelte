<script>
    export let name = 'Button';
    export let url = '/';

    function onclick() {
        window.location.href = `#/${url}`;
    }
</script>

<div class="tile" on:click="{onclick}">
    {name}
</div>

<style>
    .tile {
        border: 1px solid black;
        background-color:cornsilk;
        width: 100px;
        height: 100px;
        text-align: center;
        display: block;
    }

    .tile:hover {
        border: 2px solid black;
        background-color:bisque;
    }

</style>