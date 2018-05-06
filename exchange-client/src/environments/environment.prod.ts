export const environment = {
  production: true,
  api: {
    exchange: {
      get: {
        finance: 'http://localhost:8888/rates/finance',
        kurs: 'http://localhost:8888/rates/kurs'
      }
    }
  }
};
