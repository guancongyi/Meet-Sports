import axios from 'axios'

interface LoginParams {
    username: string,
    password: string,
}

async function userLogin(params: LoginParams){
    const resp = await axios.post('/login', params);
    if (resp.data.status === 1){
        return resp.data;
    }else{
        alert(resp.data.message)
    }
}

export { userLogin };