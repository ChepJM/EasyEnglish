import {defineStore} from 'pinia'

export const userStore = defineStore({
    id: 'user',
    state: () => ({
        token: null,
        displayName: null,
        userId: null,
        signedIn: false,
    }),
    getters: {
        getToken: (state) => {
            let token = state.token;
            if (!token) {
                token = sessionStorage.getItem('t');
                if (!token) {
                    sessionStorage.removeItem('t');
                    return null;
                } else {
                    state.token = token;
                    return token;
                }
            } else {
                return token;
            }
        },
        getDisplayName: (state) => {
            return state.displayName;
        },
        getUserId: (state) => {
            return state.userId;
        },
        isSignedIn: (state) => {
            return state.signedIn;
        }
    },
    actions: {
        setToken(value: string) {
            sessionStorage.setItem('t', value)
            this.token = value
        },
        setDisplayName(value: string) {
            if (value) {
                sessionStorage.setItem('n', value)
                this.displayName = value
            }
        },
        setUserId(value: string) {
            this.userId = value
        },
        setSignedIn(value: Boolean) {
            this.signedIn = value
        }
    }
})
