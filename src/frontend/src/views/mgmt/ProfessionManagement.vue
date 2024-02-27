<template>
  <h1>Professions</h1>
  <hr>
  <button @click="openAddModal">
    <i/> Add
  </button>
  <table class="prof-tbl" v-if="model.data.length">
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Description</th>
    </tr>
    <tr class="data-row" v-for="item in model.data" :key="item.id" @click="showDetail(item)">
      <td>{{ item.id }}</td>
      <td>{{ item.name }}</td>
      <td>{{ item.description }}</td>
      <td><span class="close" @click.stop="deleteProfession(item)">&times;</span></td>
    </tr>
  </table>
  <section class="no-data" v-else>There are no elements.</section>
  <prof-detail-modal
      v-if="model.detailVisible"
      :prof="model.selectedProf"
      :mode="model.mode"
      @onClose="model.detailVisible=false"
      @onSave="saveChanges"
  />
</template>

<script setup>

import {onMounted, reactive} from "vue";
import axios from "axios";
import ProfDetailModal from "@/views/modal/ProfDetailModal.vue";

const model = reactive({
  data: [],
  selectedProf: {
    name: 'Test',
    description: 'Test description',
  },
  detailVisible: false,
  mode: ''
})

onMounted(() => {
  getProfessions();
})

function openAddModal() {
  model.mode = 'Add';
  model.detailVisible = true;
}

function showDetail(item) {
  model.selectedProf = item;
  model.mode = 'Edit';
  model.detailVisible = true;
}

function getProfessions() {
  axios.get('/api/profession').then((response) => {
    model.data = response.data;
  });
}

function deleteProfession(prof) {
  axios.delete(`/api/profession?id=${prof.id}`).then((response) => {
    if (response.data) {
      getProfessions();
    }
  });
}

function saveChanges(prof) {
  if (model.mode === 'Add') {
    addProfession(prof);
  } else if (model.mode === 'Edit') {
    updateProfession(prof);
  }
}

function addProfession(prof) {
  axios.post('/api/profession', prof).then(() => {
    getProfessions();
    model.detailVisible = false;
  });
}

function updateProfession(prof) {
  axios.patch('/api/profession', prof).then(() => {
    getProfessions();
    model.detailVisible = false;
  });
}

</script>

<style scoped>
.prof-tbl {
  margin-top: 2em;
}

.no-data {
  margin-top: 2em;
}

tr.data-row {
  cursor: pointer;
  background-color: transparent;
}

tr.data-row:hover {
  background-color: #f1f1f1;
}
</style>
