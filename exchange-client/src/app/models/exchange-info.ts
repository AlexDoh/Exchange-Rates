import { ExchangeOrganization } from './exchange-organization';

export class ExchangeInfo {
  private _organizations: ExchangeOrganization[];
  private _orgTypes: Map<number, string>;
  private _currencies: Map<string, string> = new Map<string, string>();
  private _title: string;
  private _link: string;

  private _date?: Date;

  constructor({ organizations, orgTypes, currencies, title, link, date }: ExchangeInfo) {
    this.organizations = organizations as ExchangeOrganization[];
    this.currencies = new Map<string, string>(Object.entries(currencies));
    this.orgTypes = new Map<number, string>(
      Object.entries(orgTypes).map<[ number, string ]>(entry => [ +entry[ 0 ], entry[ 1 ] ]));
    this.title = title;
    this.link = link;

    date ? this.date = date : '';
  }

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

  get date(): Date {
    return this._date;
  }

  set date(value: Date) {
    this._date = value;
  }

  get link(): string {
    return this._link;
  }

  set link(value: string) {
    this._link = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }
}
