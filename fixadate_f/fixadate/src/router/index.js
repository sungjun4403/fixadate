import { createWebHistory, createRouter } from 'vue-router'

import Adate from '../components/Adate/Adate.vue'
import Dates from '../components/Dates/Dates.vue'
import Appointment from '../components/Appointment/Appointment.vue'
import Preferences from '../components/Preferences/Preferences.vue'
import AlertCentre from '../components/AlertCentre/AlertCentre.vue'
import Home from '../components/Home/Home.vue'

import Login from '../components/Login/Login.vue'
import GoogleAfterLogin from '../components/Login/GoogleAfterLogin.vue'
import NaverAfterLogin from '../components/Login/NaverAfterLogin.vue'
import AppleAfterLogin from '../components/Login/AppleAfterLogin.vue'
import KakaoAfterLogin from '../components/Login/KakaoAfterLogin.vue'

const routes= [
    { path: "/", name: "Home", component: Home },
    { path: "/adate", name: "Adate", component: Adate },
    { path: "/dates", name: "Dates", component: Dates },
    { path: "/appointment", name: "Appointment", component: Appointment},
    { path: "/preferences", name: "Preferences", component: Preferences },
    { path: "/alertcentre", name: "AlertCentre", component: AlertCentre }, 
    { path: "/login", name: "Login", component: Login },
    { path: "/googleafterlogin", name: "GoogleAfterLogin", component: GoogleAfterLogin }, 
    { path: "/naverafterlogin", name: "NaverAfterLogin", component: NaverAfterLogin},
    { path: "/appleafterlogin", name: "AppleAfterLogin", component: AppleAfterLogin},
    { path: "/kakaoafterlogin", name: "KakaoAfterLogin", component: KakaoAfterLogin},

]

const router = createRouter({
    history: createWebHistory(),
    routes,
})


export default router;