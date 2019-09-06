import { combineReducers } from 'redux';
import routerReducer from 'react-router-redux';
import compReducer from './component/redux/reducer';

// 合并管理
const reducer = combineReducers({
    routing: routerReducer,
    comp: compReducer
});

export default reducer;
