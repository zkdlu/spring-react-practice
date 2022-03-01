import Home from './pages/home/main.svelte'
import Cloud from './pages/cloud/main.svelte'
import Discovery from './pages/cloud/discovery.svelte'

const routes = {
    '/': Home,
    '/cloud': Cloud,
    '/discovery': Discovery,
  }
  
export default routes