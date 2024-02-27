import { createRouter, createWebHistory } from 'vue-router'


const routes = [
    {
        path: '/professions',
        name: 'professions',
        component: () => import('@/views/mgmt/ProfessionManagement.vue')
    },
    {
        path: '/departments',
        name: 'departments',
        component: () => import('@/views/mgmt/DepartmentManagement.vue'),
    },
    {
        path: '/employees',
        name: 'employees',
        component: () => import('@/views/mgmt/EmployeeManagement.vue'),
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
