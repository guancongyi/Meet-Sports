import mockjs from 'mockjs';
import { Request, Response } from 'express';

export default {
    'POST /login': (req: Request, res: Response) => {
        const { username, password } = req.body;
        if (username === 'gcy' && password === 'gggg') {
            res.send({
                success: true,
                code: 200,
                message: "Login Success",
                result: {
                    status: 1,
                    username: 'gcy',
                    email: 'congyi@gmail.com',
                    name: 'gcy',
                    icon: 'https://tva1.sinaimg.cn/large/00831rSTly1gdm7eok2oij301s01sgli.jpg',
                    id: 1,
                    msg: 'Success'
                }
            })
        } else {
            res.send({
                success: false,
                code: 400,
                message: "Username or password doesn't match",
                result: null
            })
        }
    },
    'POST /welcome': (req: Request, res: Response) => {
        const { username } = req.body;
        if (username === 'gcy'){
            res.send({
                success: true,
                code: 200,
                message: "Register Success",
                result: null
            })
        }else{
            res.send({
                success: false,
                code: 400,
                message: "Please Retry :(",
                result: null
            })
        }
        
    }
}