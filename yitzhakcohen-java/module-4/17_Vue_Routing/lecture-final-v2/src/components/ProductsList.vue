<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in $store.state.products" v-bind:key="product.id">
        <td>{{ product.id }}</td>
        <td>
          <!-- Create link on product name so it generates a URL product/id-of-product-seleted       -->
          <!-- router-link generates a link handled by Vue router                                    -->
          <!-- router-link as a 'to' attribute where your specify the name of the view and params    -->
          <!-- the router-link below will link to a view called 'product-detail' with the product.id -->
          <!--        name: name-of-the-view-for-link   (similar to href in html)                    -->
          <!--        param: {param-name : value}                                                    -->
          <router-link 
                v-bind:to="{name: 'product-detail', params: { yitz : product.id }}">
                {{ product.name }}
          </router-link>
          </td>
        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "products-list"
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
