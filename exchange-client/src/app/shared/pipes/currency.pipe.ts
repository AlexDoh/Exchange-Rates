import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'currency'
})
export class CurrencyPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    const organizations = [];
    value.forEach((organization, index) => {
      if (organization.currencies[args]) {
        organizations.push(organization);
      }
    });
    return organizations;
  }

}
