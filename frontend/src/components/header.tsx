import './header.css'
import icon from '../../src/static/icon.png';
import React, { useState, useEffect } from 'react';
import { Avatar, Button, Tag, Row, Image, Space } from 'antd';
import { history, useSelector } from 'umi';

interface IHeaderProps {
}

const ButtonGroup = () => {
    return (
        <div className={'btns'}>
            <Space>
                <Button key='1' size='large' shape='round' type="primary" onClick={() => history.push('/login')}> Log in</Button>
                <Button key='2' size='large' shape='round' onClick={() => history.push('/welcome')}>Sign up</Button>
            </Space>
        </div>
    )
}

const UserIcon = ({iconSrc}) => {
    return (
        <div className={'icon'} onClick={(e)=>{
            console.log('logout');
            
        }}>
            <Avatar size={50} src={iconSrc} />
        </div>
    )
}

const Header: React.FC<IHeaderProps> = () => {
    let currUser = useSelector(state => state.user.currentUser);

    return (
        <div className={'header-container'}  >
            <Image
                style={{ padding: '0.5em' }}
                width={100}
                src={icon}
            />
            {
                <UserIcon iconSrc={'https://tva1.sinaimg.cn/large/00831rSTly1gdm7eok2oij301s01sgli.jpg'}/>
                // Object.keys(currUser).length > 0 ?
                //     <UserIcon iconSrc={currUser['icon']}/> : <ButtonGroup />
            }
        </div>
    );
};

export default Header;
