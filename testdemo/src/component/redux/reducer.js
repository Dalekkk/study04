const initState = {
    count: 0,
    a:1
};
const compReducer = (state = initState, action = {}) => {
    let {type} = action;
    let nextState = Object.assign({}, state);
    switch (type) {
    case 'ADD_COUNT':
    nextState.count++;
        break;
    case 'DEL_COUNT':
    nextState.count--;
        break;
    default:
        break;
    }
    return nextState;
};

export default compReducer;

    