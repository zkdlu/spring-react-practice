import React, { Component } from "react";
import './TodoItem.css'

class TodoItem extends Component {
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.complete !== nextProps.complete;
    }
    render() {
        const { content, complete, id, onToggle, onRemove } = this.props;

        return (
            <div className="todo-item" onClick={() => onToggle(id)}>
                <div className="remove" onClick={(e) => {
                    e.stopPropagation();
                    onRemove(id);
                }}>&times;
                </div>
                <div className={`todo-text ${complete && 'complete'}`}>
                    <div>{content}</div>
                </div>
                {
                    complete && (<div className="check-mark">✓</div>)
                }
            </div>
        );
    }
}

export default TodoItem;