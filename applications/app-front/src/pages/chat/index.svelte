<script>
    import { onMount } from "svelte";

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
</script>

<div>
    채팅
</div>

<style>
  
</style>
