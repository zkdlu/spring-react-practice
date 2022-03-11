import { Component } from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import ChatPage from './pages/chat/ChatPage';
import Home from './pages/home/Home';
import TodoListPage from './pages/todo/TodoListPage';

class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/todo' element={<TodoListPage />} />
          <Route path='/chat' element={<ChatPage />} />
        </Routes>
      </div>
    )
  }
}

export default App;
