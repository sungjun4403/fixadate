<template>
  <div id='NavBar'>
    <div>
      <div class='NavEle' id="NavMenu">
        <router-link to="/preferences">Preferences</router-link> | 
        <router-link to="/alertcentre">Alert Centre</router-link>
      </div>
      <!-- <div class='NavEle' id="NavText"><p>fixadate</p></div> -->
      <div class='NavEle' id="NavText">
        <router-link to='/'><p id='fixadate'>fixadate</p></router-link>
      </div>
      <!-- <router-link to="/">Home</router-link> | 
      <router-link to="/adate">Adate</router-link> | 
      <router-link to="/dates">Dates</router-link> | 
      <router-link to="/anonymousdates">Anoymous Dates</router-link> | 
       -->
    </div>
    <router-view/>
  </div>
</template>

<script setup>
</script>

<style scoped>
  #NavBar {
    padding-bottom: 3%;
    margin-bottom: 3%;
  }

  .NavEle{
    display: inline-block;
    
  }

  #NavMenu{
    width: 55%;
  }
  #NavText{
    /* float: right; */
    width: 45%;
    text-align: right;
  }
  a{
    text-decoration: none;
    color: white;
  }
  p#fixadate{
    margin-top: 7%;
    margin-bottom: 7%;
    margin-right: 7%;
    font-size: xx-large;
    
  }

</style>
