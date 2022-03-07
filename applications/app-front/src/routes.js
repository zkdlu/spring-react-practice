import Home from './pages/home/main.svelte'
import Login from './pages/home/login.svelte'
import Chat from './pages/chat/index.svelte'

const routes = {
  '/': Home,
  '/login': Login,
  '/chat': Chat,
}

export default routes