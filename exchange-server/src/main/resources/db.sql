DROP ALL OBJECTS;

CREATE TABLE PROVIDERS (
  PROVIDER_ID VARBINARY PRIMARY KEY NOT NULL,
);

CREATE TABLE PROVIDERS_FINANCE (
  DATE                VARCHAR(30) NOT NULL,
  SOURCE_ID           VARCHAR(30),
  FINANCE_PROVIDER_ID VARBINARY   NOT NULL,
  CONSTRAINT FK_PROVIDER_FINANCE_PROVIDERS FOREIGN KEY (FINANCE_PROVIDER_ID)
  REFERENCES PROVIDERS (PROVIDER_ID)
);

CREATE TABLE PROVIDERS_KURS (
  KURS_PROVIDER_ID VARBINARY NOT NULL,
  CONSTRAINT FK_PROVIDER_KURS_PROVIDERS FOREIGN KEY (KURS_PROVIDER_ID)
  REFERENCES PROVIDERS (PROVIDER_ID)
);

CREATE TABLE ORGANIZATIONS_FINANCE (
  ORGANIZATION_ID VARCHAR(50) PRIMARY KEY NOT NULL,
  TITLE           VARCHAR(100)            NOT NULL,
  LINK            VARCHAR(200),
  ADDRESS         VARCHAR(200),
  PHONE           VARCHAR(200),
  OLD_ID          INTEGER                 NOT NULL UNIQUE,
  ORG_TYPE        INTEGER                 NOT NULL,
  BRANCH          BOOLEAN                 NOT NULL,
  REGION_ID       VARCHAR(30)             NOT NULL,
  CITY_ID         VARCHAR(30)             NOT NULL,

  PROVIDER_ID     VARBINARY,
  CONSTRAINT FK_ORGANIZATIONS_FINANCE_PROVIDER FOREIGN KEY (PROVIDER_ID)
  REFERENCES PROVIDERS (PROVIDER_ID),
);

CREATE TABLE ORGANIZATIONS_KURS (
  ORGANIZATION_ID VARCHAR(50) PRIMARY KEY NOT NULL,
  TITLE           VARCHAR(100)            NOT NULL,
  LINK            VARCHAR(200),
  ADDRESS         VARCHAR(200),
  PHONE           VARCHAR(200),

  PROVIDER_ID     VARBINARY,
  CONSTRAINT FK_ORGANIZATIONS_KURS_PROVIDER FOREIGN KEY (PROVIDER_ID)
  REFERENCES PROVIDERS (PROVIDER_ID),
);

CREATE TABLE CURRENCY_RATES_FINANCE (
  ID              VARBINARY PRIMARY KEY NOT NULL,
  TYPE            VARCHAR(10),
  BID             VARCHAR(30)           NOT NULL,
  ASK             VARCHAR(30)           NOT NULL,

  ORGANIZATION_ID VARCHAR(50),
  CONSTRAINT FK_CURRENCY_RATES_FINANCE_ORGANIZATION FOREIGN KEY (ORGANIZATION_ID)
  REFERENCES ORGANIZATIONS_FINANCE (ORGANIZATION_ID)
);

CREATE TABLE CURRENCY_RATES_KURS (
  ID              VARBINARY PRIMARY KEY NOT NULL,
  TYPE            VARCHAR(10),
  BID             VARCHAR(30)           NOT NULL,
  ASK             VARCHAR(30)           NOT NULL,
  UPDATED         VARCHAR(30)           NOT NULL,
  BID_CHANGE      VARCHAR(30),
  ASK_CHANGE      VARCHAR(30),

  ORGANIZATION_ID VARCHAR(50),
  CONSTRAINT FK_CURRENCY_RATES_KURS_ORGANIZATION FOREIGN KEY (ORGANIZATION_ID)
  REFERENCES ORGANIZATIONS_KURS (ORGANIZATION_ID)
);

CREATE TABLE CITIES (
  CITY_CODE   VARCHAR(30) NOT NULL UNIQUE,
  DESCRIPTION VARCHAR(30),

  PROVIDER_ID VARBINARY   NOT NULL,
  CONSTRAINT FK_CITIES_PROVIDERS_FINANCE FOREIGN KEY (PROVIDER_ID)
  REFERENCES PROVIDERS (PROVIDER_ID),

  CONSTRAINT PK_CITIES_PROVIDERS_FINANCE PRIMARY KEY (PROVIDER_ID, CITY_CODE)
);

CREATE TABLE CURRENCIES (
  CURRENCY    VARCHAR(30) NOT NULL UNIQUE,
  DESCRIPTION VARCHAR(30),

  PROVIDER_ID VARBINARY   NOT NULL,
  CONSTRAINT FK_CURRENCIES_PROVIDERS_FINANCE FOREIGN KEY (PROVIDER_ID)
  REFERENCES PROVIDERS (PROVIDER_ID),

  CONSTRAINT PK_CURRENCIES_PROVIDERS_FINANCE PRIMARY KEY (PROVIDER_ID, CURRENCY)
);

CREATE TABLE ORG_TYPES (
  TYPE        VARCHAR(30) NOT NULL UNIQUE,
  DESCRIPTION VARCHAR(30),

  PROVIDER_ID VARBINARY   NOT NULL,
  CONSTRAINT FK_ORG_TYPES_PROVIDERS_FINANCE FOREIGN KEY (PROVIDER_ID)
  REFERENCES PROVIDERS (PROVIDER_ID),

  CONSTRAINT PK_ORG_TYPES_PROVIDERS_FINANCE PRIMARY KEY (PROVIDER_ID, TYPE)
);

CREATE TABLE REGIONS (
  REGION_CODE VARCHAR(30) NOT NULL UNIQUE,
  DESCRIPTION VARCHAR(30),

  PROVIDER_ID VARBINARY   NOT NULL,
  CONSTRAINT FK_REGIONS_PROVIDERS_FINANCE FOREIGN KEY (PROVIDER_ID)
  REFERENCES PROVIDERS (PROVIDER_ID),

  CONSTRAINT PK_REGIONS_PROVIDERS_FINANCE PRIMARY KEY (PROVIDER_ID, REGION_CODE)
);
