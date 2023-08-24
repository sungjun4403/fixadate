<template>
    <div>
        <div>
            <h2>SIGN IN</h2>
        </div>

        <div>
            <h2>SIGN UP</h2>
        </div>

        <button id="googleSignUpButton" @click="getGoogleLoginUrl()">
            Sign up with Google
        </button>
        <br><br>

        <button  id="naverSignUpButton" @click="getNaverLoginUrl()">
            Sign up with Naver
        </button>        
        <br><br>

        <button id="kakaoSignUpButton" @click="getKakaoLoginUrl()">
            Sign up with Kakao
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
                url: "http://localhost:8080/getgoogleloginurl",
                method: "get"
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
    button {
        border: none;
    }

    #googleSignUpButton {
        background-color: white;
    }

    #naverSignUpButton {
        background-color: greenyellow;
    }

    #kakaoSignUpButton {
        background-color: yellow;
    }

</style>