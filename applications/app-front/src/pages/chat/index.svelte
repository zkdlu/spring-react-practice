<script>
    import { onMount } from "svelte";

    let socket;
    let myMessage = '';
    $: messages = [];
    
    function sendMessage() {
        socket.send(myMessage);
        myMessage = '';
    }

    function handleEnter(event) {
        if (event.key === 'Enter') {
            sendMessage();
        }
    }

    onMount(() => {
        socket = new WebSocket("ws://localhost:8080/ws-stomp");
        socket.onopen = () => {
            console.log("Opened");
        };
        socket.onmessage = (payload) => {
            console.log(payload);
            messages = [...messages, payload.data];
        };
    });
</script>

<div class="chat">
    <ul>
        {#each messages as message}
        <li>{message}</li>
        {/each}
    </ul>
</div>
<div>
    <input type="text" placeholder="message" bind:value="{myMessage}" on:keypress="{handleEnter}"/>
    <button on:click="{sendMessage}">send</button>
</div>


<style>
    .chat {
        width: 100%;
        height: 85%;
        overflow: auto;
        background-color: blanchedalmond;
    }
</style>
