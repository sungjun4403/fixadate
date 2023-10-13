<template>
    <div>
        <br>

        <button @click="oauthLogout();">LOGOUT</button> <br><br>

        <button @click="moveToProfileEdit();">Edit Profile</button>
    </div>
</template>

<script>
import axios from 'axios'
import router from '../../router'

export default {
    setup() {
    },

    methods: {
        oauthLogout() {
            if (localStorage.oauthPlatform == "kakao") {
                this.kakaoLogout()
            }
        },

        kakaoLogout() {
            axios({
                url: "",
                method: "post"
            })
        },
        
        moveToProfileEdit() {
            router.push("/profileedit")
        }
    }
}
</script>

<style scoped>

</style>