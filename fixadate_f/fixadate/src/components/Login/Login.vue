<template>
    <div>
            <h2>SIGN IN</h2>
        </div>
        
        <div>
            <h2>SIGN UP</h2>
        </div>

        <button @click="getGoogleLoginUrl()">
            GOOGLE LOGIN
        </button>

        <button @click="getNaverLoginUrl()">
            naver login
        </button>        

        <button @click="getKakaoLoginUrl()">
            kakao login
        </button>
           
    </div>
</template>

<script>
import axios from 'axios'
export default {
    setup() {
        
    },
    methods: {
        getGoogleLoginUrl() {
            axios({
                url: "http://localhost:8080/api/v1/oauth2/google",
                method: "post"
            }).then((response) => {
                document.location.href = response.data
            })
        },

        getNaverLoginUrl() {
            axios({
                url: "http://localhost:8080/getnaverloginurl",
                method: "get"
            }).then((response) => {
                document.location.href = response.data
            })   
        },

        getKakaoLoginUrl() {
            axios({
                url: "http://localhost:8080/getkakaologinurl",
                method: "get"
            }).then((response) => {
                document.location.href = response.data
            })   
        }
    }
}
</script>

<style scoped>

</style>