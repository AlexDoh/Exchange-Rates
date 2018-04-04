export class ExchangeCurrecnyRates {

  public bid: string;
  public ask: string;

  public updated?: string;
  public bidChange?: string;
  public askChange?: string;

  constructor(bid: string, ask: string, updated: string, bidChange: string, askChange: string) {
    this.bid = bid;
    this.ask = ask;
    this.updated = updated;
    this.bidChange = bidChange;
    this.askChange = askChange;
  }
}
