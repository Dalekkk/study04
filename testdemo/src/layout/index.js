import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter,Route} from "react-router-dom";
import UserList from './component/page/UserList';

ReactDOM.render((
    <BrowserRouter>
      <div className="container">
          <Route path="/" exact component={UserList}/>
      </div>
    </BrowserRouter>

),
    document.getElementById('root'));

serviceWorker.unregister();