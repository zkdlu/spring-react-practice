import { Component } from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import ChatPage from './pages/chat/ChatPage';
import Home from './pages/home/Home';
import TodoListPage from './pages/todo/TodoListPage';
import './App.css'
import MarketPage from './pages/market/MarketPage';
import ProductPage from './pages/market/ProductPage';
import PaymentPage from './pages/market/PaymentPage';
import LottoPage from './pages/lotto/LottoPage';

class App extends Component {
  render() {
    return (
      <div className='main'>
        <Header />
        <Routes>
          <Route path='/'  element={<Home />} />
          <Route path='/todo' element={<TodoListPage />} />
          <Route path='/chat' element={<ChatPage />} />
          <Route path='/market' element={<MarketPage />} />
          <Route path='/market/:id' element={<ProductPage />} />
          <Route path='/payment/:id' element={<PaymentPage />} />
          <Route path='/lotto' element={<LottoPage />} />
        </Routes>
      </div>
    )
  }
}

export default App;
