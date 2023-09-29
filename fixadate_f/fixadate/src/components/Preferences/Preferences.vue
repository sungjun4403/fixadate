<template>
    <div>
        <br>

        <button @click="oauthLogout();">LOGOUT</button>
    </div>
</template>

<script>
import axios from 'axios'

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
        }
    }
}
</script>

<style scoped>

</style>