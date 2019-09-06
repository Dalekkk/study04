import { Form, Icon, Input, Button, Checkbox } from 'antd';
import React, { Component } from 'react';
import Password from 'antd/lib/input/Password';
import Axios from 'axios';

class NormalLoginForm extends React.Component{
  
  constructor(props){
      super(props);
      this.handleSubmit = e => {
          e.preventDefault();
              this.props.form.validateFields((err, values) => {
                if (!err) {
                  console.log('Received values of form: ', values);
                }
          });
      };
      this.Login=(e)=>{
        var value;
        this.props.form.validateFieldsAndScroll(
          (err,values)=>{
            if(!err){
              value=values;
            }
        });
        var data={
          username:value.username,
          password:value.password,
        }
    
        let history=this.props.history;
        Axios({
          method:'post',
          url:'http://localhost:8888/login',
          params:data
        }).then(function(response){
          if(response.data=="success"){
            console.log(response);
            history.push('/news');
          }else{
            <Button onClick={()=>openNotificationWithIcon('error')}>error</Button>
            console.log("用户名或密码错误")
            console.log(response)
            alert("用户名或密码错误")
          }
        }).catch(function(error){
          console.log(error)
        });
      }
  }
  
  
   
    render() {
        const { getFieldDecorator } = this.props.form;
        return (
          <Form onSubmit={this.handleSubmit} className="login-form">
            <Form.Item>
              {getFieldDecorator('username', {
                rules: [{ required: true, message: 'Please input your username!' }],
              })(
                <Input
                  prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
                  placeholder="Username"
                />,
              )}
            </Form.Item>
            <Form.Item>
              {getFieldDecorator('password', {
                rules: [{ required: true, message: 'Please input your Password!' }],
              })(
                <Input
                  prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                  type="password"
                  placeholder="Password"
                />,
              )}
            </Form.Item>
            <Form.Item>
              {getFieldDecorator('remember', {
                valuePropName: 'checked',
                initialValue: true,
              })}
              <Button type="primary" htmlType="submit" className="login-form-button" onClick={this.Login}>
                Log in
              </Button>
            </Form.Item>
          </Form>
        );
      }
    
}

const Login = Form.create({ name: 'normal_login' })(NormalLoginForm);

export default Login