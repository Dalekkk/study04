import React, { Component } from 'react';
import Axios from 'axios';
import { Input, Mentions } from 'antd';
const { Search } = Input;
  
class Trans extends React.Component{

    constructor(props){
        super(props);
        this.state={
            value:null,
            word:"翻译结果", 
        }
        //this.Translate=this.Translate.bind(this);
        //this.handleChange=this.handleChange.bind(this);

        this.Translate=(e)=>{
            const result=this.state.value;
            console.log(result)
            const _this=this;
            var data={word:this.state.value};
    
            Axios({
                method:'post',
                url:'http://localhost:8888/Translator',
                params:data
              }).then(function(response){
                  console.log(response);
                  _this.setState({
                      word:response.data
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
              enterButton="翻译"
              size="large"
              value={this.state.value}
              onChange={this.handleChange}
              onSearch={this.Translate.bind(this)}
              />

            <Mentions value={this.state.word} ></Mentions>
            </div>

            

        )}
}

export default Trans;
