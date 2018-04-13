import { Injectable } from '@angular/core';

@Injectable()
export class UtilsService<K, V> {

  constructor() { }

  public getArrayFromMapEntries(entries: IterableIterator<[K, V]>): Array<[K, V]> {
    return Array.from(entries);
  }

}
