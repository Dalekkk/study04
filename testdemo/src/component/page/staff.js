import React, { Component } from 'react';
import axios from 'axios';

import {Table} from 'antd';
class Staff extends Component{
    constructor(props){
        super(props);
        this.state={
            staffs:[],
            isLoaded:false,
            dataSource:[],
            columns:[
                {
                    title: '员工工号',
                    dataIndex: 'usercode',
                    key: 'usercode',
                  },
                  {
                    title: '员工姓名',
                    dataIndex: 'username',
                    key: 'username',
                  },
                  {
                    title: '所属部门',
                    dataIndex: 'department',
                    key: 'department',
                  },
            ]
        }
        }
    
    componentDidMount(){
        const _this=this;    //先存一下this，以防使用箭头函数this会指向我们不希望它所指向的对象。
        axios.get('http://localhost:8888/getStaff')
        .then(function (response) {
            _this.setState({
                staffs:response.data,
                isLoaded:true,
                dataSource:response.data
              });
            })
        .catch(function (error) {
            console.log(error);
              _this.setState({
                isLoaded:false,
                error:error
            })
        })
    }
    render(){
        if(!this.state.isLoaded){
            return <div>Loading</div>
        }else{
            return(
               <Table dataSource={this.state.dataSource} columns={this.state.columns} />
            )
        }
        
    }
}

export default Staff;