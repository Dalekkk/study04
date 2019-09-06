import React, { Component } from 'react';

// const Comp = (props)=>{
//     let {count, addCount, delCount} = props;
//     return <div>
//         <span>显示redux count值：{count}</span>
//         <button onClick={addCount}>增加count</button>
//         <button onClick={delCount}>减少count</button>
//     </div>
// }

class Comp extends Component{
    constructor(props){
        super(props);
        this.state = {
            count: 0
        }
        this.addCount = this.addCount.bind(this);
        this.delCount = this.delCount.bind(this);
    }

    addCount(){
        let count = this.state.count;
        this.setState({count:count+1});
    }

    delCount(){
        let count = this.state.count;
        this.setState({count:count-1});
    }


    render(){
        let {count} = this.state;
        return <div>
                <span>显示redux count值：{count}</span>
                <button onClick={this.addCount}>增加count</button>
                <button onClick={this.delCount}>减少count</button>
        </div>
    }
}

export default Comp;