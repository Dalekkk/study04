import React, { Component, useCallback } from 'react';
import Axios from 'axios';
import { Input, Mentions } from 'antd';
import {Table} from 'antd';
const { Search } = Input;

class SearchStaff extends React.Component{
    constructor(props){
        super(props);
        this.state={
            value:null,
            word:"翻译结果", 
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

        this.SearchInfo=(e)=>{
            const result=this.state.value;
            console.log(result)
            const _this=this;
            var data={word:result};
    
            Axios({
                method:'post',
                url:'http://localhost:8888/Search',
                params:data
              }).then(function(response){
                  console.log(response);
                  _this.setState({
                      word:response.data,
                      dataSource:response.data
                  })
              }).catch(function(error){
                console.log(error)
              });
        };

        this.handleChange=(event) =>{
            const _this=this;
            this.setState({value:event.target.value});
        }
    }

    render(){
        return(<div>
            <Search
              placeholder="input search text"
              enterButton="查询"
              size="large"
              value={this.state.value}
              onChange={this.handleChange}
              onSearch={this.SearchInfo.bind(this)}
              />
            <Table dataSource={this.state.dataSource} columns={this.state.columns}/>
            </div>

            

        )}
}

export default SearchStaff