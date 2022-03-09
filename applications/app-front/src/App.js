import { Component } from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
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
        </Routes>
      </div>
    )
  }
}

export default App;
