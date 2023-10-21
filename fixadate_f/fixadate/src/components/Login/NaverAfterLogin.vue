<template>
    <div>
        NAVER AFTERLOGIN
    </div>
</template>

<script>
import axios from 'axios'
import router from '../../router'
export default {
    setup() {
        
    },
    mounted() {
        this.extractUserInfo()
    },
     
    methods: {
        extractUserInfo() {
            var code = document.location.href.split("?")[1]
            axios ({
                url: "http://localhost:8080/api/naver/login?" + code,
                method: "get"
            }).then((response) => {
                console.log(response.data)
                console.log(response.data.naverTokenResponse)
                var boolGender
                if (response.data.response.gender == "M") {
                    boolGender = true
                }
                else if (response.data.response.gender == "F") {
                    boolGender = false
                }
                router.push({
                    name: "InfoInput",
                    params: {
                        oauthPlatform: "naver",
                        oauthId: response.data.response.id,
                        name: null,
                        gender: boolGender,
                        profileImg: response.data.response.profile_image,
                        birth: response.data.response.birthday,
                        AccessToken: response.data.naverTokenResponse.access_token,
                        RefreshToken: response.data.naverTokenResponse.refresh_token
                    }
                })
            })
        }
    }
}

</script>

<style scoped>

</style>