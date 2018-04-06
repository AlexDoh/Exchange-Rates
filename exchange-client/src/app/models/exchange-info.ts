import { ExchangeOrganization } from './exchange-organization';

export class ExchangeInfo {

  private _organizations: ExchangeOrganization[];
  private _orgTypes: Map<number, string>;
  private _currencies: Map<string, string>;

  private _date?: string;

  get organizations(): ExchangeOrganization[] {
    return this._organizations;
  }

  set organizations(value: ExchangeOrganization[]) {
    this._organizations = value;
  }

  get orgTypes(): Map<number, string> {
    return this._orgTypes;
  }

  set orgTypes(value: Map<number, string>) {
    this._orgTypes = value;
  }

  get currencies(): Map<string, string> {
    return this._currencies;
  }

  set currencies(value: Map<string, string>) {
    this._currencies = value;
  }

  get date(): string {
    return this._date;
  }

  set date(value: string) {
    this._date = value;
  }
}
