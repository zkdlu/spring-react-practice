import React, { Component } from "react";
import TodoItem from "./TodoItem";

class TodoItemList extends Component {
    render() {
        const { todos, onToggle, onRemove } = this.props;
        const todoList = todos.map(
            ({ id, content, complete }) => (
                <TodoItem
                    id={id}
                    content={content}
                    complete={complete}
                    onToggle={onToggle}
                    onRemove={onRemove}
                    key={id}
                />)
        )

        return (
            <div>
                {todoList}
            </div>
        )
    }
}

export default TodoItemList;