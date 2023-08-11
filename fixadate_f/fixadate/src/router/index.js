import { createWebHistory, createRouter } from 'vue-router'

import Adate from '../components/Adate/Adate.vue'
import Dates from '../components/Dates/Dates.vue'
import Appointment from '../components/Appointment/Appointment.vue'
import Preferences from '../components/Preferences/Preferences.vue'
import AlertCentre from '../components/AlertCentre/AlertCentre.vue'
import Home from '../components/Home/Home.vue'
import Login from '../components/Login/Login.vue'

const routes= [
    { path: "/", name: "Home", component: Home },
    { path: "/adate", name: "Adate", component: Adate },
    { path: "/dates", name: "Dates", component: Dates },
    { path: "/appointment", name: "Appointment", component: Appointment},
    { path: "/preferences", name: "Preferences", component: Preferences },
    { path: "/alertcentre", name: "AlertCentre", component: AlertCentre }, 
    { path: "/login", name: "Login", component: Login }, 
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})


export default router;