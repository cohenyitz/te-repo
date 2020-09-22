import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    hotels: []  // hold the hotels we are using
  },
  mutations: {  // functions to change data in the data store
    SET_HOTELS(state, data) {
      state.hotels = data;
    },
  },
  actions: {},
  modules: {},
  strict: true    // enforce the rule that only mutations can change the state of data store
                  //     throw an exception is anything other than a mutation attempts tp change data store
});
