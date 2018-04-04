export const environment = {
  production: true,
  api: {
    exchange: {
      get: {
        finance: 'http://localhost:8080/rates/finance',
        kurs: 'http://localhost:8080/rates/kurs'
      }
    }
  }
};
