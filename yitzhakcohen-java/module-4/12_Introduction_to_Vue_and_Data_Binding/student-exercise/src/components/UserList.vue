<template>
  <table id="tblUsers">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td><input type="text" id="firstNameFilter" v-model="filter.firstName"/></td>
        <td><input type="text" id="lastNameFilter"  v-model="filter.lastName"/></td>
        <td><input type="text" id="usernameFilter"  v-model="filter.username"/></td>
        <td><input type="text" id="emailFilter"     v-model="filter.emailAddress"/></td>
        <td>
          <select id="statusFilter" v-model="filter.status">
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Disabled">Disabled</option>
          </select>
        </td>
      </tr>
      <!-- user listing goes here -->
      <!--                              -->
     <tr class="list" v-for="aUser in filteredList" v-bind:key='aUser.username' v-bind:class="{disabled: aUser.status === 'Disabled'}">
          <td>{{aUser.firstName}}</td>
          <td>{{aUser.lastName}}</td>
          <td>{{aUser.username}} </td>
          <td>{{aUser.emailAddress}}</td>
          <td>{{aUser.status}}</td>
     </tr> 
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'user-list',
  data() {
    return {
      users: [
        { firstName: 'John', lastName: 'Smith', username: 'jsmith', emailAddress: 'jsmith@gmail.com', status: 'Active' },
        { firstName: 'Anna', lastName: 'Bell', username: 'abell', emailAddress: 'abell@yahoo.com', status: 'Active' },
        { firstName: 'George', lastName: 'Best', username: 'gbest', emailAddress: 'gbest@gmail.com', status: 'Disabled' },
        { firstName: 'Ben', lastName: 'Carter', username: 'bcarter', emailAddress: 'bcarter@gmail.com', status: 'Active' },
        { firstName: 'Katie', lastName: 'Jackson', username: 'kjackson', emailAddress: 'kjackson@yahoo.com', status: 'Active' },
        { firstName: 'Mark', lastName: 'Smith', username: 'msmith', emailAddress: 'msmith@foo.com', status: 'Disabled' }
      ],
      /*#4*/
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status:""
      },
      
    }
  }, // end of data()
  computed: {
        filteredList() {
          return this.users.filter((aUser) => {
              return aUser.firstName.toLowerCase().includes(this.filter.firstName.toLowerCase())
              && aUser.lastName.toUpperCase().includes(this.filter.lastName.toUpperCase()) 
              && aUser.username.toLowerCase().includes(this.filter.username.toLowerCase()) 
              && aUser.emailAddress.toLowerCase().includes(this.filter.emailAddress.toLowerCase()) 
              && aUser.status.includes(this.filter.status)
       });
        }
      }
}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}
th {
  text-transform: uppercase
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input, select {
  font-size: 16px;
}
</style>
