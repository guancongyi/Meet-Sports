import './header.css'
import icon from '../../src/static/icon.png';
import * as React from 'react';
import { PageHeader, Button, Tag, Row, Image, Space } from 'antd';
import { history } from 'umi';

interface IHeaderProps {
}

const ButtonGroup = (props) => {
    return (
        <div className={'btns'}>
            <Space>
                <Button key='1' size='large' shape='round' type="primary" onClick={() => history.push('/login')}> Log in</Button>
                <Button key='2' size='large' shape='round' onClick={() => history.push('/welcome')}>Sign up</Button>
            </Space>
        </div>
    )
}

const Header: React.FC<IHeaderProps> = (props) => {
    return (
        <div className={'header-container'}  >
            <Image
                style={{ padding: '0.5em' }}
                width={100}
                src={icon}
            />
            <ButtonGroup />
        </div>
    );
};

export default Header;
