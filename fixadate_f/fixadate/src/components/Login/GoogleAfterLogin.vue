<template>
    <div>
        AFTERLOGIN
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
            var url = document.location.href
            url = url.split("/")
            url = url[3].split("?")
            var code = url[1]
            
            console.log(code)
            axios ({
                url: "http://localhost:8080/api/v1/oauth2/google?" + code,
                method: "get"
            }).then((response) => {
                console.log(response.data)
                router.push({
                    name: "InfoInput",
                    params: {
                        oauthPlatform: "kakao",
                        oauthId: response.data.id,
                        name: null,
                        gender: response.data.kakao_account.gender,
                        profileImg: response.data.properties.profile_image,
                        birth: response.data.kakao_account.birthday,
                        AccessToken: response.data.kakaoTokenResponse.access_token,
                        RefreshToken: response.data.kakaoTokenResponse.refresh_token
                        
                    }
                })
            })
        }
    }
}
</script>

<style scoped>

</style>