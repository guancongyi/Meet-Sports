import mockjs from 'mockjs';
import { Request, Response } from 'express';

export default {
    'POST /login': (req: Request, res: Response) => {
        const {username, password} = req.body;
        if (username === 'gcy' && password === 'gggg'){
            res.send({
                status: 1,
                name: 'gcy',
                icon: 'https://tva1.sinaimg.cn/large/00831rSTly1gdm7eok2oij301s01sgli.jpg',
                userId: 1,
                msg: 'Success'
            })
        }else{
            res.send({
                status: 0,
                msg: 'User does not exists!'
            })
        }
    }
}