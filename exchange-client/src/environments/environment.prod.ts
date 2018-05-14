export const environment = {
  production: true,
  api: {
    exchange: {
      get: {
        finance: 'http://localhost:8888/rates/finance/update',
        kurs: 'http://localhost:8888/rates/kurs'
      }
    }
  }
};
