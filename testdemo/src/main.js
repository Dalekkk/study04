import './css/index.css';
import './css/main.less';
import './css/login.css';
import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import store from './store';
import { LocaleProvider } from 'antd';
import zhCN from 'antd/es/locale-provider/zh_CN'
import 'antd/dist/antd.css';

import App from './antd/app';

ReactDOM.render(
    <LocaleProvider locale='zhCN'>
    <Provider store={store}>
    <App />
    </Provider>
    </LocaleProvider>,
    document.getElementById('app')
);