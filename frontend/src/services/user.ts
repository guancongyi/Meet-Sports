import axios from 'axios'

interface LoginParams {
    username: string,
    password: string,
}

async function userLogin(params: LoginParams){
    return await axios.post('/login', params);
}

async function userRegister(params){
    return await axios.post('/welcome', params);
}

export { userLogin, userRegister };