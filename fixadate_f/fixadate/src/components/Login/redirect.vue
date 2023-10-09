<template>
    <div>
        REDIRECTING TO HOME
    </div>
</template>

<script>
import axios from 'axios'
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
        saveAuthen
    }
}
</script>