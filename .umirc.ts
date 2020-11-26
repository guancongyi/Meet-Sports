import { defineConfig } from 'umi';

export default defineConfig({
  nodeModulesTransform: {
    type: 'none',
  },
  routes: [
    { path: '/', component: '@/pages/home/index' },
    { path: '/login', component: '@/pages/login/index' },
    { path: '/register', component: '@/pages/register/index' }

  ],
});
