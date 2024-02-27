<template>
  <h1>Employees</h1>
  <hr>
  <button @click="openAddModal">
    <i/> Add
  </button>
  <table class="empl-tbl" v-if="model.data.length">
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Description</th>
      <th>Profession</th>
      <th>Department</th>
    </tr>
    <tr class="data-row" v-for="item in model.data" :key="item.id" @click="showDetail(item)">
      <td>{{ item.id }}</td>
      <td>{{ item.name }}</td>
      <td>{{ item.description }}</td>
      <td>{{ item.profession.name }}</td>
      <td>{{ item.department.name }}</td>
      <td><span class="close" @click.stop="deleteEmployee(item)">&times;</span></td>
    </tr>
  </table>
  <section class="no-data" v-else>There are no elements.</section>
  <empl-detail-modal
      v-if="model.detailVisible"
      :empl="model.selectedEmpl"
      :mode="model.mode"
      :depts="model.departments"
      :profs="model.professions"
      @onClose="model.detailVisible=false"
      @onSave="saveChanges"
  />
</template>

<script setup>

import {onMounted, reactive} from "vue";
import axios from "axios";
import EmplDetailModal from "@/views/modal/EmplDetailModal.vue";

const model = reactive({
  data: [],
  departments: [],
  professions: [],
  selectedEmpl: {
    name: 'Test',
    description: 'Test description',
    profession: '',
    department: ''
  },
  detailVisible: false,
  mode: ''
})

onMounted(() => {
  getEmployees();
  getProfessions();
  getDepartments();
})

function openAddModal() {
  model.mode = 'Add';
  model.detailVisible = true;
}

function showDetail(item) {
  model.selectedEmpl = item;
  model.mode = 'Edit';
  model.detailVisible = true;
}

function deleteEmployee(empl) {
  axios.delete(`/api/employee?id=${empl.id}`).then((response) => {
    model.data = response.data;
  });
}

function getDepartments() {
  axios.get('/api/department').then((response) => {
    model.departments = response.data;
  });
}

function getProfessions() {
  axios.get('/api/profession').then((response) => {
    model.professions = response.data;
  });
}

function getEmployees() {
  axios.get('/api/employee').then((response) => {
    model.data = response.data;
  });
}

function saveChanges(empl) {
  if (model.mode === 'Add') {
    addEmployee(empl);
  } else if (model.mode === 'Edit') {
    updateEmployee(empl);
  }
}

async function addEmployee(empl) {
  console.log(empl)
  await axios.post('/api/employee', empl).then(() => {
    getEmployees();
    model.detailVisible = false;
  });
}

function updateEmployee(empl) {
  axios.patch('/api/employee', empl).then(() => {
    getEmployees();
    model.detailVisible = false;
  });
}

</script>

<style scoped>
.empl-tbl {
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
