<template>
  <button @click="moveToVocanularies">
    <i/> Vocabularies
  </button>
  <button  @click="moveToWords">
    <i/> Words
  </button>
  <button @click="moveToUsers">
    <i/> Users
  </button>
  <button @click="moveToRoles">
    <i/> Roles
  </button>
  <router-view />
</template>

<script setup>
import router from '@/route'

function moveToVocanularies() {
  router.push('/vocabularies');
}

function moveToWords() {
  router.push('/words');
}

function moveToUsers() {
  router.push('/users');
}

function moveToRoles() {
  router.push('/roles');
}
</script>

<style scoped>

</style>
