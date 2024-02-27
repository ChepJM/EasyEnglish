<template>
  <div class="modal" tabindex="-1">
    <div class="modal-content">
      <span class="close" @click="emits('onClose')">&times;</span>
      <h1>{{ props.mode }}</h1>
      <hr>
      <div class="data-row">
        <label for='name'>Name</label>
        <input id='name' v-model='model.name'>
      </div>
      <div class="data-row">
        <label for='description'>Description</label>
        <input id='description' v-model='model.description'>
      </div>
      <div class="btns">
        <button class="save-btn" @click="saveChanges">
          <i/> Save
        </button>
        <button @click="emits('onClose')">
        <i/> Cancel
      </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import {defineEmits, defineProps, onMounted, reactive} from 'vue';

const emits = defineEmits(['onClose', 'onSave']);
const props = defineProps(['prof', 'mode']);

const model = reactive({
  name: '',
  description: ''
});

onMounted(() => {
  if (props.mode === 'Add') {
    model.name = '';
    model.description = '';
  } else if (props.mode === 'Edit') {
    model.id = props.prof.id;
    model.name = props.prof.name;
    model.description = props.prof.description;
  }
})

function saveChanges() {
  if (model.name) {
    emits('onSave', model);
  } else {
    alert('Field "Name" is empty.');
  }

}

</script>

<style scoped>
.modal {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0, 0, 0); /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.btns {
  text-align: right;
}

.save-btn {
  margin-right: 1em;
}

.data-row {
  margin-top: 1em;
}

label {
  font-weight: bold;
  display: block;
  width: 150px;
  float: left;
}

label:after {
  content: ": "
}
</style>
