import React, { Component } from 'react';
import axios from 'axios';
import About from './about';
import {Table} from 'antd';

class List extends React.Component{
    constructor(props){
        super(props);
        this.state={
            users:[],
            isLoaded:false,
            dataSource:[],
            columns:[
                {
                    title: '作者',
                    dataIndex: 'author_name',
                    key: 'author_name',
                  },
                  {
                    title: '所属板块',
                    dataIndex: 'category',
                    key: 'category',
                  },
                  {
                    title: '发布时间',
                    dataIndex: 'date',
                    key: 'date',
                  },
                  {
                    title: '新闻标题',
                    dataIndex: 'title',
                    key: 'title',
                  },
                  {
                    title: '新闻链接',
                    dataIndex: 'url',
                    key: 'url',
                  },
            ]
        }
        }
    
    componentDidMount(){
        const _this=this;    //先存一下this，以防使用箭头函数this会指向我们不希望它所指向的对象。
        axios.get('http://localhost:8888/getNews')
        .then(function (response) {
            _this.setState({
                users:response.data,
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
export default List;