import axios from 'axios'
import {message} from 'antd'

interface LoginParams {
    username: string,
    password: string,
}

async function userLogin(params: LoginParams){
    const resp = await axios.post('/login', params);
    if (resp.data.status === 1){
        return resp.data;
    }else{
        message.error(resp.data.msg)
    }
}

export { userLogin };