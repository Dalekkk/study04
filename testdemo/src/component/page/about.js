import React, { Component } from 'react';
// import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';
import {Pagination} from 'antd';
class About extends Component{

    constructor(props){
        super(props);
    }

    render(){
        return(
            this.props.users.map((user,i)=>{
                return(
                    <tr key={user.id} className="text-center">
                        <td>{user.author_name}</td>
                        <td>{user.category}</td>
                        <td>{user.date}</td>
                        <td>{user.title}</td>
                        <td>{user.url}</td>
                    </tr>
                    
                )
            })
        )
    }
    // skipToHome(){
    //     this.props.history.push('/');
    // }

    // render(){
    //     return <div>
    //         <span>this is about</span>
    //         <button onClick={this.skipToHome.bind(this)}>跳到home</button>
    //     </div>
    // }


}
// const homedataSource=[
//     {
//         username:"陈同学",
//         password:"123456"
//     }
// ];

// const homecolumns =[
//     {
//         title: '用户名称',
//         dataIndex: 'username',
//         key: 'username',
//       },
//       {
//         title: '用户密码',
//         dataIndex: 'password',
//         key: 'password',
//       },{
//         title: '操作',
//         dataIndex: '',
//         key: 'y',
//         render: () => <a href="javascript:;">Edit</a>,
//       },{
//         title: 'Action',
//         dataIndex: '',
//         key: 'x',
//         render: () => <a href="javascript:;">Delete</a>,
//       },
// ];
// <Table dataSource={homedataSource} columns={homecolumns} />;
//       const User = function() {
//       return <Table dataSource={homedataSource} columns={homecolumns} />;
//     }
export default About;