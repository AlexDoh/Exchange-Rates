export class ExchangeCurrencyRates {

  private _bid: string;
  private _ask: string;

  private _updated?: Date;
  private _bidChange?: string;
  private _askChange?: string;

  constructor({ bid, ask, updated, bidChange, askChange }: ExchangeCurrencyRates) {
    this.bid = bid.toString();
    this.ask = ask.toString();

    this.updated = updated;
    this.bidChange = bidChange.toString();
    this.askChange = askChange.toString();
  }

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

  get updated(): Date {
    return this._updated;
  }

  set updated(value: Date) {
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
