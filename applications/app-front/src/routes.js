import Home from './pages/home/main.svelte'
import Cloud from './pages/cloud/main.svelte'
import Discovery from './pages/cloud/discovery.svelte'
import Instance from './pages/cloud/instance.svelte'

const routes = {
    '/': Home,
    '/cloud': Cloud,
    '/discovery': Discovery,
    '/discovery/:id': Instance,
  }
  
export default routes