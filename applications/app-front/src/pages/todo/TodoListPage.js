import { Component } from "react";
import Form from "./components/Form";
import TodoItemList from "./components/TodoItemList";
import TodoListTemplate from "./components/TodoListTemplate";
import api from '../../api'

class TodoListPage extends Component {
    id = 0
    state = {
        input: '',
        todos: [
          
        ],
        fail: false
    }

    async componentDidMount() {
        try {
            const fetchedTodos = await api.get('todos');
            this.setState({
                todos: fetchedTodos,
                fail: false
            });

            console.log(fetchedTodos);
        } catch (err) {
            this.setState({
                fail: true
            })
        }
    }

    handleChange = (e) => {
        this.setState({
            input: e.target.value
        });
    }

    handleCreate = () => {
        const { input, todos } = this.state;
        this.setState({
            input: '',
            todos: todos.concat({
                id: this.id++,
                content: input,
                complete: false
            })
        });
    }

    handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            this.handleCreate();
        }
    }

    handleToggle = (id) => {
        const { todos } = this.state;
        const index = todos.findIndex(todo => todo.id === id);
        const selectedTodo = todos[index];

        todos[index] = {
            ...selectedTodo,
            complete: !selectedTodo.complete
        };

        this.setState({
            todos: todos
        });
    }

    handleRemove = (id) => {
        const { todos } = this.state;
        this.setState({
            todos: todos.filter(todo => todo.id !== id)
        });
    }

    render() {
        const { input, todos } = this.state;
        const {
            handleChange,
            handleCreate,
            handleKeyPress,
            handleToggle,
            handleRemove
        } = this;

        return (
            <TodoListTemplate form={(
                <Form value={input}
                    onKeyPress={handleKeyPress}
                    onChange={handleChange}
                    onCreate={handleCreate} />
            )}>
                <TodoItemList todos={todos} onToggle={handleToggle} onRemove={handleRemove}/>
            </TodoListTemplate>
        )
    }
}

export default TodoListPage;