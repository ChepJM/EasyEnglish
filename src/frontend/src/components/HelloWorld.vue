<template>
  <h1>{{ model.text }}</h1>
</template>

<script setup>

import {onMounted, reactive} from "vue";
import axios from "axios";

let model = reactive({
  text: ''
})

onMounted(() => {
  axios.get('/api/profession/').then((res) => {
    model.text = res.data
  })
})

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
