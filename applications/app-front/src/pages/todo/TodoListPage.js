import { Component } from "react";
import Form from "../../components/Form";
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
        await this.fetchTodos();
    }

    async fetchTodos() {
        try {
            const fetchedTodos = await api.get('todos');
            this.setState({
                todos: fetchedTodos,
                fail: false
            });

            console.log(fetchedTodos);
        } catch (err) {
            this.setState({
                todos: [],
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
        const { input } = this.state;

        api.post('todos', {
            content: input
        }).then(() => this.fetchTodos());

        this.setState({
            input: '',
        });
    }

    handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            this.handleCreate();
        }
    }

    handleToggle = (id) => {
        const { todos } = this.state;
        const selectedTodo = todos.find(todo => todo.id === id);

        api.patch(`todos/${id}`, {
            complete: !selectedTodo.complete
        }).then(() => this.fetchTodos());
    }

    handleRemove = (id) => {
        api.delete(`todos/${id}`)
            .then(() => this.fetchTodos());
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
                    onClick={handleCreate} />
            )}>
                <TodoItemList todos={todos} onToggle={handleToggle} onRemove={handleRemove} />
            </TodoListTemplate>
        )
    }
}

export default TodoListPage;