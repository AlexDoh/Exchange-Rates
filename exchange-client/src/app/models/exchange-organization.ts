import { ExchangeCurrencyRates } from './exchange-currency-rates';

export class ExchangeOrganization {

  constructor({ title, link, address, phone, currencies, id, oldId, orgType, branch, regionId, cityId }: ExchangeOrganization) {
    this.title = title.toString();
    this.link = link.toString();
    this.address = address.toString();
    this.phone = phone.toString();
    this.currencies = new Map<string, ExchangeCurrencyRates[]>(Object.entries(currencies));

    this.id = id.toString();
    this.oldId = oldId;
    this.orgType = orgType;
    this.branch = branch;
    this.regionId = regionId.toString();
    this.cityId = cityId.toString();
  }

  private _title: string;
  private _link: string;
  private _address: string;
  private _phone: string;
  private _currencies: Map<string, ExchangeCurrencyRates[]>;

  private _id?: string;
  private _oldId?: number;
  private _orgType?: number;
  private _branch?: boolean;
  private _regionId?: string;
  private _cityId?: string;


  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get link(): string {
    return this._link;
  }

  set link(value: string) {
    this._link = value;
  }

  get address(): string {
    return this._address;
  }

  set address(value: string) {
    this._address = value;
  }

  get phone(): string {
    return this._phone;
  }

  set phone(value: string) {
    this._phone = value;
  }

  get currencies(): Map<string, ExchangeCurrencyRates[]> {
    return this._currencies;
  }

  set currencies(value: Map<string, ExchangeCurrencyRates[]>) {
    this._currencies = value;
  }

  get id(): string {
    return this._id;
  }

  set id(value: string) {
    this._id = value;
  }

  get oldId(): number {
    return this._oldId;
  }

  set oldId(value: number) {
    this._oldId = value;
  }

  get orgType(): number {
    return this._orgType;
  }

  set orgType(value: number) {
    this._orgType = value;
  }

  get branch(): boolean {
    return this._branch;
  }

  set branch(value: boolean) {
    this._branch = value;
  }

  get regionId(): string {
    return this._regionId;
  }

  set regionId(value: string) {
    this._regionId = value;
  }

  get cityId(): string {
    return this._cityId;
  }

  set cityId(value: string) {
    this._cityId = value;
  }
}
