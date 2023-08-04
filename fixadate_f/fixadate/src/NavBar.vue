<template>
  <div id='NavBar'>
    <div id="NavBarEle">
      <div class='NavEle' id="NavText">
        <router-link to='/'><p id='fixadate'>fixadate</p></router-link>
        
      </div>
      <!-- <div class='NavEle' id="NavText"><p>fixadate</p></div> -->
      <div class='NavEle' id="NavMenu">
        <div id="NavMenuIconImg"> 
          <router-link to="/alertcentre"><img id="AlertCentreIcon" width="33.8" src="./assets/images/AlertCentre.png" title="Alert Centre" alt="Alert Centre"></router-link>
          <router-link to="/preferences"><img id="PreferencesIcon" width="26.9" src="./assets/images/Preferences.png" title="Preferences" alt="Preferences"></router-link>
          
        </div>
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

  #NavBarEle {
    /* padding-top: -10%; */
    margin-top: -6.9%;
    margin-bottom: -10%;
  }

  #NavMenu{
    /* float: right; */
    vertical-align: middle;
    width: 60%;
    text-align: right;
    
  }

  #NavText{
    vertical-align: middle;
    width: 40%;
    font-family: 'Cairo Play', sans-serif;
    /* font-family: 'Roboto Serif', serif; */
    
    /* font-family: 'Libre Barcode 39 Text', cursive; */
    /* font-family: 'Roboto Serif', serif; */
  }
  
  p#fixadate{
    
    margin-left: 11%;
    font-size: x-large;
    
    
  }

  /* #NavMenuIconImg {
    
  } */

  #PreferencesIcon {
    vertical-align: middle;
    margin-right: 6.4%;
  }

  #AlertCentreIcon {
    vertical-align: middle;
    margin-right: 4%;
  }

</style>
