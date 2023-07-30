// import './assets/main.css'

import { createApp } from 'vue'
import SideBar from './NavBar.vue'
import router from './router'

const app = createApp(SideBar)

app.use(router).mount('#NavBar')
