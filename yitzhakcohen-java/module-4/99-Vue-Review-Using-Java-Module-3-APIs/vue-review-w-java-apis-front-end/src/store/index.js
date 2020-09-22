import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    hotels: []      // holds the hotels we are using
  },
  mutations: {
    SET_HOTELS(state, data) {   // functions to change data in the data store
      state.hotels = data;
    }
  },
  actions: {},
  modules: {},
  strict: true //enforce the rule that only mutations can change the state of data store
  //                        throw and exception in anything other than 
});
