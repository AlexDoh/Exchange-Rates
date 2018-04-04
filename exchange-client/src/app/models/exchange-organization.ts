import { ExchangeCurrecnyRates } from './exchange-currecny-rates';

export class ExchangeOrganization {

  public title: string;
  public link: string;
  public address: string;
  public phone: string;
  public currencies: Map<string, ExchangeCurrecnyRates[]>;

  public id?: string;
  public oldId?: number;
  public orgType?: number;
  public branch?: boolean;
  public regionId?: string;
  public cityId?: string;

  constructor(title: string, link: string, address: string, phone: string, currencies: Map<string, ExchangeCurrecnyRates[]>, id: string, oldId: number, orgType: number, branch: boolean, regionId: string, cityId: string) {
    this.title = title;
    this.link = link;
    this.address = address;
    this.phone = phone;
    this.currencies = currencies;
    this.id = id;
    this.oldId = oldId;
    this.orgType = orgType;
    this.branch = branch;
    this.regionId = regionId;
    this.cityId = cityId;
  }
}
