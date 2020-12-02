import { userLogin } from '@/services/user';
import { Effect, Reducer } from 'umi';
interface CurrentUser {
    name?: string;
    icon?: string;
    userId?: number;
}

interface UserDetail {
    name?: string;
    icon?: string;
    userId?: number;
    email?: string;
}

interface UserModelState {
    currentUser: CurrentUser;
    detail: UserDetail;
}

interface UserModelType {
    namespace: 'user',
    state: UserModelState,
    effects: {
        login: Effect
    },
    reducers: {
        saveUser: Reducer<UserModelState>
    }
}

const UserModel: UserModelType = {
    namespace: 'user',
    state: {
        currentUser: {},
        detail: {},
    },
    effects: {
        *login({ payload }, { call, put }) {
            const resp = yield call(userLogin, payload)
            console.log(resp);
            yield put({type: 'saveUser', payload: {currentUser: {...resp}}})
        }
    },
    reducers: {
        saveUser(state, action) {
            return {...state, ...action.payload}
        }
    }
}

export default UserModel;