<template>
    <div id='Home'>
        <div id='CalMenu'>
            <div class='CalItem' id='Adate'>
                <p>Adate</p>
            </div>

            <div class='CalItem' id='Dates'>
                <p>Dates</p>
            </div>

            <div class='CalItem' id='AnonymousDates'>
                <p>Anonymous Dates</p>
            </div>
        </div>


        <div id='Widgets'>
            <div class='Widget' id='AppleCalanderWidget'>
                AppleCalanderWidget
            </div>

            <div class='Widget' id='Notes'>
                <p>Notes</p>
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
        margin-left: 13%;
        margin-right: 13%;
        margin-top: 30%;
        padding-top: 2%;
        padding-bottom: 2%;
        background-color: rgba(108, 108, 108, 1);
        border-radius: 13px;
        font-size: larger;
    }

    .Widget {
        margin-top: 20%;
        font-size: larger;
    }
    #Notes {
        text-align: center;
    }
</style>

