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
        axios({
                url: "http://localhost:8080/getkakaologinurl",
                method: "get"
            }).then((response) => {
                document.location.href = response.data
            })   
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
                    router.push("/home")
                }
            })
        }
    }
}
</script>