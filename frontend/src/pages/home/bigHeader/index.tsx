import background from '../../../static/frisbee.jpg';
import * as React from 'react';
import { PageHeader, Button, Tag } from 'antd';
import { history } from 'umi';

interface IBigHeaderProps {
}

const containerStyle = {
    height: '65vh',
    backgroundImage: `url(${background})` 
}

const pageheaderStyle = {
    backgroundColor: 'rgba(52, 52, 52, 0)'
}

const pageheaderTitleStyle = {
    fontSize: '1.3em'
}

const BigHeader: React.FunctionComponent<IBigHeaderProps> = (props) => {
    return (
        <div style={containerStyle}>
            <PageHeader
                title={<div style={pageheaderTitleStyle}>Sports Meet</div>}
                style={pageheaderStyle}
                ghost={false}
                tags={<Tag color="blue">Beta 1</Tag>}
                extra={[
                    <Button size='large' shape='round' type="primary" onClick={()=>history.push('/login')}> Log in</Button>,
                    <Button size='large' shape='round' onClick={()=>history.push('/welcome')}>Sign up</Button>
                ]}
            >
            </PageHeader>
        </div>
    );
};

export default BigHeader;
