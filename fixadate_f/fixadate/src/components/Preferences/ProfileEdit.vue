<template>
    <div>
        edit profile
        {{name}} <br>
        {{oauthPlatform}} <br>
        {{profileImg}} <br>
        {{nickname}} <br>
        {{birth}} <br>
        {{gender}} <br>
        {{profession}} <br>
        {{signatureColor}} <br>
    </div>
</template>

<script>
import { ref } from 'vue'
import axios from 'axios'
export default {
    setup() {
      const name = ref("")  
      const oauthPlatform = ref("")  
      const profileImg = ref("")  
      const nickname = ref("")  
      const birth = ref("")  
      const gender = ref("")  
      const profession = ref("")  
      const signatureColor = ref("")
      const AccessToken = localStorage.AccessToken

      return {
          name, oauthPlatform, profileImg, nickname, birth, gender, profession, signatureColor, AccessToken
      }
    },

    beforeMount() {
        this.getMemberInfo() 
    },

    methods: {
        getMemberInfo() {
            axios({
                url: "http://localhost:8080/member/withtoken",
                method: "get",
                headers: {
                    'Authorization': 'Bearer ' + localStorage.AccessToken,
                    'oauthPlatform': localStorage.oauthPlatform
                }
            }).then((response) => {
                this.name = response.data.name
                this.oauthPlatform = response.data.oauthPlatform
                this.profileImg = response.data.profileImg
                this.nickname = response.data.nickname
                this.birth = response.data.birth
                this.gender = response.data.gender
                this.profession =  response.data.profession
                this.signatureColor = response.data.signatureColor
            })
        }
    }

}
</script>

<style scoped>

</style>