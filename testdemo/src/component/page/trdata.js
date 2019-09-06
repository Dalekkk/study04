import React, { Component } from 'react';

class TrData extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return(
            this.props.staffs.map((staff,i)=>{
                return(
                    <tr key={staff.usercode} className="text-center">
                        <td>{staff.usercode}</td>
                        <td>{staff.username}</td>
                        <td>{staff.department}</td>
                    </tr>
                )
            })
        )
    }
}

export default TrData