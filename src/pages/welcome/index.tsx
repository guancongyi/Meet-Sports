import * as React from 'react';
import { Button, Form, Input, Row, Col, Card } from 'antd';
import { UserOutlined, LockOutlined, MailOutlined } from '@ant-design/icons';

interface RegisterPayload {
  username: String;
  password: String;
  remember: Boolean;
}
const RegisterPage: React.FC = () => {
  const onFinish = (values: RegisterPayload) => {
    console.log(values)
  }
  return (
    <Row justify="center" align="middle" style={{ minHeight: '100vh' }}>
      <Col>
        <Card title="Welcome" headStyle={{ textAlign: 'center' }} style={{ width: '300px'}}>
          <Form onFinish={onFinish}>
            <Form.Item name="username" rules={[{ required: true }]}>
              <Input prefix={<UserOutlined />} placeholder="Username" />
            </Form.Item>
            <Form.Item name="password" hasFeedback rules={[{ required: true }]}>
              <Input.Password prefix={<LockOutlined />} placeholder="Password" />
            </Form.Item>
            <Form.Item name="rePassword" hasFeedback dependencies={['password']}  rules={[
              { required: true },
              ({ getFieldValue }) => ({
                validator(rule, value) {
                  if (!value || getFieldValue('password') === value) {
                    return Promise.resolve();
                  }
                  return Promise.reject('The two passwords that you entered do not match!');
                }
              })
            ]}>
              <Input.Password prefix={<LockOutlined />} placeholder="Confirm Password" />
            </Form.Item>
            <Form.Item name="email" hasFeedback rules={[{ type: 'email' }, { required: true }]} >
              <Input prefix={<MailOutlined />} placeholder="Email" />
            </Form.Item>
            <Button htmlType="submit" type="primary" style={{ 'width': '100%' }}
            >Register</Button>
          </Form>
        </Card>
      </Col>
    </Row>
  );
};

export default RegisterPage;
