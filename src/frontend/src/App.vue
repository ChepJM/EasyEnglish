<template>
  <button @click="moveDeps">
    <i/> Departments
  </button>
  <button  @click="moveEmpls">
    <i/> Employees
  </button>
  <button @click="moveProfs">
    <i/> Professions
  </button>
  <router-view />
</template>

<script setup>
import router from '@/route'

function moveEmpls() {
  router.push('/employees');
}

function moveDeps() {
  router.push('/departments');
}

function moveProfs() {
  router.push('/professions');
}
</script>

<style scoped>

</style>
