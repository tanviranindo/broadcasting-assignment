
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/IndexPage.vue') },
      { path: '/custombroadcast', component: () => import('pages/CustomBroadcast.vue') },
      { path: '/wifirtt', component: () => import('pages/WifiRTT.vue') },
      { path: '/batteryreceiver', component: () => import('pages/BatteryReceiver.vue') },
      { path: '/showbroadcast', name: "broadcastvalue", component: () => import('pages/ShowBroadcast.vue') },
      { path: '/comparebattery', name: "batteryvalue", component: () => import('pages/CompareBattery.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
