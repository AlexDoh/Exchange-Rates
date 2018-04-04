import { ExchangeOrganization } from './exchange-organization';

export class ExchangeInfo {

  public organizations: ExchangeOrganization[];
  public orgTypes: Map<number, string>;
  public currencies: Map<string, string>;

  public date?: string;

  constructor(organizations: ExchangeOrganization[], orgTypes: Map<number, string>, currencies: Map<string, string>, date: string) {
    this.organizations = organizations;
    this.orgTypes = orgTypes;
    this.currencies = currencies;
    this.date = date;
  }
}
