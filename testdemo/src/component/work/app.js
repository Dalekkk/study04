import React,{Component} from 'react';
import axios from 'axios';


class App extends Component{


    constructor(props){
        super(props);
        this.state={
            userid:"",
            username:"",
            password:""
        }
    }
    render(){
        return(
            <div className="container-fluid" style={{marginTop:'20px'}}>
                <div className="row">
                <table className="table-bordered">
                    <thead>
                        <tr>
                            <th>用户名</th>
                            <th>用户密码</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.list.map(item=>{
                                return(
                                    <tr key={item.userid}>
                                        <td>{item.username}</td>
                                        <td>{item.password}</td>
                                        <td>
                                            <button className="btn-edit" onClick={()=>{
                                                thhis.setState({userid:item.userid,username:item.username,password:item.password})
                                            }}>编辑</button>
                                            <button className="btn-delete" onClick={()=>{
                                                this.deleteItem(item)
                                            }}>删除</button>
                                        </td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>

                <form className="form-group">
                    <label htmlFor="username" className="col-xs-3">用户名</label>
                    <div className="col-xs-8">
                        <input type="text" id="name" className="form-control" value={this.state.name} onChange={(e)=>{this.setState({name:e.target.value})}}/>
                    </div>
                    <div className="form-group">
                        <div className="col-sm">
                            <button className="btn" onClick={this.handleFormSubmit}>提交</button>
                        </div>
                    </div>
                </form>
                </div>

            </div>
        )
    }


    componentDidMount(){
        this.query();
    }


    query =()=>{
        axios.get('/api/user').then(({data})=>{
            this.setState({
                list:data
            });
        });
    }

    handleFormSubmit=(e)=>{
        e.preventDefault();
        if(this.state.username!=''){
            axios.post('/api/user',{
                userid: !this.state.userid ? '' :this.state.userid,
                username:this.state.username,
                password:this.state.password
            }).then(({data})=>{
                this.setState({
                    userid:'',
                    username:'',
                    password:''
                });
                this.query();
            })
        }
    }

    deleteItem=(item)=>{
        axios.delete('/api/user/${item.userid}').then(({data})=>{
            this.query();
        })
    }
}

export default App;