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
            axios({
                url: "http://localhost:8080/logout",
                method: "get",
                headers: {
                    'Authorization': 'Bearer ' + localStorage.AccessToken,
                    'oauthPlatform': localStorage.oauthPlatform
                }
            }).then((response) => {
                console.log(response)
                // if (response.status == 200) {
                //     router.push("/login")
                // }
                // else {
                //     router.push("/404")
                // }
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