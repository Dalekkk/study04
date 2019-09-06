import React,{Component} from 'react';
import {Route,Link,Switch,HashRouter,BrowserRouter} from 'react-router-dom'
import {Layout,Menu} from 'antd';
import './app.css';
import Login from '../component/page/login'
import List from '../component/page/list'
import Staff from '../component/page/staff'
import Trans from '../component/page/trans'
import SearchStaff from '../component/page/searchstaff'

const {Header,Sider,Content,Footer}=Layout;
const MenuItem=Menu.Item;


class App extends Component{
    constructor(props){
        super(props);
        this.state = {
            collapsed: false,
          };

          this.toggle = () => {
            this.setState({
              collapsed: !this.state.collapsed,
            });
          };
    }
     
      render() {
        return (
        <HashRouter>
        <Switch>
            <Route exact path='/' component={Login}></Route>
          <Layout>
            <Sider trigger={null} collapsible collapsed={this.state.collapsed}>
              <div className="logo" />
              <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                <Menu.Item keu="1"><Link to='/news'><span>新闻</span></Link></Menu.Item>
                <Menu.Item><Link to='/trans'><span>翻译</span></Link></Menu.Item>
                {/* <Menu.Item><Link to='/staff'><span>员工信息</span></Link></Menu.Item> */}
                <Menu.Item><Link to='/searchstaff'><span>员工查询</span></Link></Menu.Item>
              </Menu>
            </Sider>
            <Content>
                <Switch>
                <Route path = '/news' exact component={List} />
                <Route path = '/trans' exact component={Trans} />
                {/* <Route path = '/staff' exact component={Staff} /> */}
                <Route path = '/searchstaff' exact component={SearchStaff} />
                </Switch>
            </Content>
            <Layout>
              <Header style={{ background: '#fff', padding: 0 }}>
              </Header>
              <Content
                style={{
                  margin: '24px 16px',
                  padding: 24,
                  background: '#fff',
                  minHeight: 280,
                }}
              >
              </Content>
            </Layout>
          </Layout>
        </Switch>
        </HashRouter>
        );
      }

}


export default App;