<template>
  <div>
    <h1>Studentenliste</h1>
    <input v-model="neuerStudent" placeholder="Name eingeben" />
    <button @click="hinzufuegen">Hinzufügen</button>

    <ul>
      <li v-for="s in studenten" :key="s.id">{{ s.name }}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      neuerStudent: '',
      studenten: []
    }
  },
  methods: {
    async laden() {
      try {
        const res = await axios.get('/api/students')
        this.studenten = res.data
      } catch (error) {
        console.error('Error loading students:', error)
      }
    },
    async hinzufuegen() {
      if (!this.neuerStudent) return
      try {
        await axios.post('/api/students', {name: this.neuerStudent})
        this.neuerStudent = ''
        this.laden()
      } catch (error) {
        console.error('Error adding student:', error)
      }
    }
  },
  mounted() {
    this.laden()
  }
}
</script>