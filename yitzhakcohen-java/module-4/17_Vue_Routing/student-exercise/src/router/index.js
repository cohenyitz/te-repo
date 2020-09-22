import Vue from 'vue';
import VueRouter from 'vue-router';




Vue.use(VueRouter);

import Home from '@/views/Home';
import MyBooks from '@/views/MyBooks';
import NewBook from '@/views/NewBook';
import BookDetails from '@/views/BookDetails';

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/myBooks',
    name: 'my-books',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'new-book',
    component: NewBook
  },
  {
    path: '/book/: id',
    name: 'book',
    component: BookDetails
  }

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
