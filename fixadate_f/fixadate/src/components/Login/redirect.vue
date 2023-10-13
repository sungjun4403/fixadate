<template>
    <div>
        REDIRECTING TO HOME
    </div>
</template>

<script>
import axios from 'axios'
import router from '../../router'
export default {
    mounted() {
        this.saveAuthentication();
    },
    methods: {
        saveAuthentication() {
            axios({
                url: "http://localhost:8080/member/withtoken",
                method: "get",
                headers: {
                    'Authorization': 'Bearer ' + localStorage.AccessToken,
                    'oauthPlatform': localStorage.oauthPlatform
                }
            }).then((response) => {
                console.log(response)
                if (response.status == 200) {
                    router.push("/")
                }
                else {
                    router.push("/404")
                }
                
            })
        }
    }
}
</script>