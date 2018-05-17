import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'entries'
})
export class EntriesPipe implements PipeTransform {

  transform(value, args: string[]): any {
    const keys = [];
    value.forEach(key => keys.push({key, value: value[key]}));
    return keys;
  }

}
