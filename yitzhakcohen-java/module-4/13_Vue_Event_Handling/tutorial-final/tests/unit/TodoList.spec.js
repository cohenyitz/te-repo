import TodoList from "@/components/TodoList";
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from "@vue/test-utils";

import chai from "chai";
chai.should();

describe("TodoList", () => {
  /** @type Wrapper */
  let wrapper;

  beforeEach(() => {
    wrapper = shallowMount(TodoList);
  });

  it("should be a Vue instance", () => {
    wrapper.isVueInstance().should.be.true;
  });

  describe("filteredTodos computed property", () => {
    it("should not filter any todos if filter is empty", () => {
      wrapper.setData({
        filterText: '',
        todos: [
          {
            name: "first"
          },
          {
            name: "second"
          },
          {
            name: "third"
          }
        ]
      });
      wrapper.vm.filteredTodos.length.should.equal(3);
    });

    it("should filter todos if filter is set", () => {
      wrapper.setData({
        filterText: 'r',
        todos: [
          {
            name: "first"
          },
          {
            name: "second"
          },
          {
            name: "third"
          }
        ]
      });
      wrapper.vm.filteredTodos.length.should.equal(2);
      wrapper.vm.filteredTodos[0].name.should.equal('first');
      wrapper.vm.filteredTodos[1].name.should.equal('third');
    });
  });

  it("should remove a todo passed to the deleteTodo() method", () => {
    const testTodo = { name: "TEST" };
    wrapper.setData({
      todos: [testTodo, { name: "DON'T DELETE" }]
    });
    wrapper.vm.deleteTodo(testTodo);
    wrapper.vm.todos.length.should.equal(1);
    wrapper.vm.todos[0].name.should.equal("DON'T DELETE");
  });

  it("should add a new item to todos when the createTodo() method is called", () => {
    wrapper.setData({
        todos: [],
        newItem: "NEW TODO"
    });
    wrapper.vm.createTodo();
    wrapper.vm.todos.length.should.equal(1);
    wrapper.vm.todos[0].name.should.equal("NEW TODO");
    wrapper.vm.todos[0].done.should.be.false;
});
});
