import { ExchangeOrganization } from './exchange-organization';

export class ExchangeInfo {

  private _organizations: ExchangeOrganization[];
  private _orgTypes: Map<string, string>;
  private _currencies: Map<string, string> = new Map<string, string>();

  private _date?: string;

  constructor(exchangeInfo: ExchangeInfo) {
    const { organizations, orgTypes, currencies, date } = exchangeInfo;
    this.organizations = organizations as ExchangeOrganization[];
    this.currencies = new Map<string, string>(Object.entries(currencies));
    this.orgTypes = new Map<string, string>(Object.entries(orgTypes));
    this.date = date.toString();
  }

  get organizations(): ExchangeOrganization[] {
    return this._organizations;
  }

  set organizations(value: ExchangeOrganization[]) {
    this._organizations = value;
  }

  get orgTypes(): Map<string, string> {
    return this._orgTypes;
  }

  set orgTypes(value: Map<string, string>) {
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
