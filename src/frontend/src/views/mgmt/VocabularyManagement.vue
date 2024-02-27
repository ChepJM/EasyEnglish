<template>
  <h1>Vocabularies</h1>
  <hr>
  <button @click="openAddModal">
    <i/> Add
  </button>
  <table class="dep-tbl" v-if="model.data.length">
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Description</th>
      <th>Head department</th>
    </tr>
    <tr class="data-row" v-for="item in model.data" :key="item.id" @click="showDetail(item)">
      <td>{{ item.id }}</td>
      <td>{{ item.name }}</td>
      <td>{{ item.description }}</td>
      <td>{{ item.parentDepartment?.name || '-' }}</td>
      <td><span class="close" @click.stop="deleteDepartment(item)">&times;</span></td>
    </tr>
  </table>
  <section class="no-data" v-else>There are no elements.</section>
  <dept-detail-modal
      v-if="model.detailVisible"
      :dept="model.selectedDept"
      :depts="model.data"
      :mode="model.mode"
      @onClose="model.detailVisible=false"
      @onSave="saveChanges"
  />
</template>

<script setup>

import {onMounted, reactive} from "vue";
import DeptDetailModal from "@/views/modal/DeptDetailModal.vue";
import axios from "axios";

const model = reactive({
  data: [],
  selectedDept: {
    name: 'Test',
    description: 'Test description',
    parentDepartment: {
      name: 'Parent dept'
    }
  },
  detailVisible: false,
  mode: '',
  page: 1
})

onMounted(() => {
  getVocabularies({page: model.page})
})

function getVocabularies(data) {
  const params = data
  axios.get('/api/vocabulary', {params}).then((response) => {
    model.data = response.data;
  });
}

function openAddModal() {
  model.mode = 'Add';
  model.detailVisible = true;
}

function showDetail(item) {
  model.selectedDept = item;
  model.mode = 'Edit';
  model.detailVisible = true;
}

function getDepartments() {
  axios.get('/api/department').then((response) => {
    model.data = response.data;
  });
}

function saveChanges(dept) {
  if (model.mode === 'Add') {
    addDepartment(dept);
  } else if (model.mode === 'Edit') {
    updateDepartment(dept);
  }
}

function addDepartment(dept) {
  axios.post('/api/department', dept).then(() => {
    getDepartments();
    model.detailVisible = false;
  });
}

function updateDepartment(dept) {
  axios.patch('/api/department', dept).then(() => {
    getDepartments();
    model.detailVisible = false;
  });
}

function deleteDepartment(dept) {
  axios.delete(`/api/department?id=${dept.id}`).then((response) => {
    if (response.data) {
      getDepartments();
    } else {
      alert('You are trying to delete department that is foreign_key for another department.');
    }
  });
}

</script>

<style scoped>
.dep-tbl {
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
