import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import Comp from './comp';
import * as actions from './action';

const mapStateToProps = (state, ownProps) => {
    return state.comp;
};

const mapDispatchToProps = (dispatch, ownProps) => {
    return bindActionCreators(actions, dispatch);
};

const AppContainer = connect(
    mapStateToProps,
    mapDispatchToProps
)(Comp);

export default AppContainer;
