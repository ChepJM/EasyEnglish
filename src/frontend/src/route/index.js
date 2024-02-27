import { createRouter, createWebHistory } from 'vue-router'


const routes = [
    {
        path: '/vocabularies',
        name: 'vocabularies',
        component: () => import('@/views/mgmt/VocabularyManagement.vue')
    },
    {
        path: '/words',
        name: 'words',
        component: () => import('@/views/mgmt/WordManagement.vue'),
    },
    {
        path: '/users',
        name: 'users',
        component: () => import('@/views/mgmt/UserManagement.vue'),
    },
    {
        path: '/roles',
        name: 'roles',
        component: () => import('@/views/mgmt/RoleManagement.vue'),
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes,
    scrollBehavior() {
        return { top: 0 }
    }
})

export default router
