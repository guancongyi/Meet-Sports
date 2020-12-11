import './index.css'
import React from 'react';
import Header from '@/components/header';
import { Input, Button, Select, Row } from 'antd';
import { SearchOutlined } from '@ant-design/icons';

const { Option } = Select;

const SelectionBox = () => {
    return (
        <div className={'selection-container'}>
            <Row wrap={false}>
                <Input size="large" placeholder="Frisbee, Basketball, and..."
                    prefix={<div><SearchOutlined /> <b>Find</b></div>}
                    suffix={<div><b>Activities</b></div>} />
                <Select defaultValue="Zhejiang" size="large">
                    <Option value="Zhejiang">Shanghai</Option>
                    <Option value="Jiangsu">Jiangsu</Option>
                </Select>
                <Select defaultValue="Zhejiang" size="large">
                    <Option value="Zhejiang">Xuhui</Option>
                    <Option value="Jiangsu">Pudong</Option>
                </Select>
                <Button type='primary' size="large">Go!</Button>
            </Row>
        </div>
    )
}

const HomePage = () => {
    
    return (
        <div>
            <div className={'top-container'}>
                <Header/>
                <SelectionBox/>
            </div>
            <div>Events</div>
        </div>
    )
}

export default HomePage

