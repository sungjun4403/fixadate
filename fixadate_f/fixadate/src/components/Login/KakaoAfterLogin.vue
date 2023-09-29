<template>
    <div>
        redirecting (kakao)
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
                url: "http://localhost:8080/api/kakao/login?" + code,
                method: "get"
            }).then((response) => {
                console.log(response.data)
                console.log(response.data.kakaoTokenResponse.access_token)
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
        },
    }
    
}
</script>

<style scoped>

</style>