<template>
    <div>
        PREFE
        <button @click="axioss();">AXIOS</button>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    setup() {
    },

    methods: {
        axioss() {
            
            axios({
                url: 'http://localhost:8080/member/1',
                method: 'get'
            }).then((response)=> {
                console.log(response)
            })
        }
    }
}
</script>

<style scoped>

</style>