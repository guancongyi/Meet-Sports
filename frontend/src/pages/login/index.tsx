import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector, useHistory } from 'umi';
import { Button, Form, Input, Row, Col, Card, Checkbox } from 'antd';
import { UserOutlined, LockOutlined } from '@ant-design/icons';

interface LoginPayload {
  username: String;
  password: String;
  remember: Boolean;
}
const LoginPage: React.FC = () => {
  const currentUser = useSelector(state => state.user.currentUser);
  const dispatch = useDispatch();
  const history = useHistory();

  const onFinish = (values: LoginPayload) => {
    dispatch({ type: 'user/login', payload: values })
  }

  useEffect(() => {    
    if (Object.keys(currentUser).length > 0) {
      history.push('/')
    }
  }, [currentUser])

  return (
    <Row justify="center" align="middle" style={{ minHeight: '100vh' }}>
      <Col>
        <Card title="Log in" headStyle={{ textAlign: 'center' }}>
          <Form initialValues={{ remember: true }} onFinish={onFinish}>
            <Form.Item
              name="username"
              rules={[{ required: true, message: 'Please input your Username!' }]}>
              <Input prefix={<UserOutlined />} placeholder="Username" />
            </Form.Item>
            <Form.Item
              name="password"
              rules={[{ required: true, message: 'Please input your Password!' }]}>
              <Input.Password prefix={<LockOutlined />} placeholder="Password" />
            </Form.Item>
            <Form.Item name="remember" valuePropName="checked" noStyle>
              <Checkbox>Remember me</Checkbox>
            </Form.Item>
            <Form.Item >
              <Button htmlType="submit" type="primary" style={{ 'marginTop': '0.5em', 'width': '100%' }}
              >Login</Button>
            </Form.Item>
          </Form>
        </Card>
      </Col>
    </Row>
  );
};

export default LoginPage;