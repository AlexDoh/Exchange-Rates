export class ExchangeCurrencyRates {

  private _bid: string = '';
  private _ask: string = '';

  private _updated?: string;
  private _bidChange?: string;
  private _askChange?: string;

  get bid(): string {
    return this._bid;
  }

  set bid(value: string) {
    this._bid = value;
  }

  get ask(): string {
    return this._ask;
  }

  set ask(value: string) {
    this._ask = value;
  }

  get updated(): string {
    return this._updated;
  }

  set updated(value: string) {
    this._updated = value;
  }

  get bidChange(): string {
    return this._bidChange;
  }

  set bidChange(value: string) {
    this._bidChange = value;
  }

  get askChange(): string {
    return this._askChange;
  }

  set askChange(value: string) {
    this._askChange = value;
  }

}
