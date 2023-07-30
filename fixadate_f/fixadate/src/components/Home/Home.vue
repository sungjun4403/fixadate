<template>
    <div id='Home'>
        <div id='CalMenu'>
            <div class='CalItem' id='Adate'>
                Adate
            </div>

            <div class='CalItem' id='Dates'>
                Dates
            </div>

            <div class='CalItem' id='AnonymousDates'>
                Anonymous Dates
            </div>
        </div>


        <div id='Widgets'>
            <div class='Widget' id='AppleCalanderWidget'>
                AppleCalanderWidget
            </div>

            <div class='Widget' id='Notes'>
                Notes
            </div>
        </div>
    </div>
</template>

<script>
export default {
    setup() {
        document.title = 'fixadate | Home'
    },
}
</script>

<style scoped>
    #Home {
        display: flex;
    }
    #CalMenu {
        text-align: center;
        flex: 1;
        width: 50%;
    }
    #Widgets{
        flex: 1;
        width: 50%;
        /* float: right; */
    }

    .CalItem {
        margin-top: 60%;
    }

    .Widget {
        margin-top: 80%;
    }
    #Notes {
        text-align: center;
    }
</style>

