package com.odmytrenko.model;

import java.util.HashMap;
import java.util.Map;

public class BankConstants {

    public static final Map<String, String> CURRENCIES;
    public static final Map<Integer, String> ORG_TYPES;

    static {
        CURRENCIES = new HashMap<>();
        ORG_TYPES = new HashMap<>();

        CURRENCIES.put("AED", "дирхамы ОАЭ");
        CURRENCIES.put("AMD", "армянские драмы");
        CURRENCIES.put("AUD", "австралийские доллары");
        CURRENCIES.put("AZN", "азербайджанские манаты");
        CURRENCIES.put("BGN", "болгарские левы");
        CURRENCIES.put("BRL", "бразильские реалы");
        CURRENCIES.put("BYN", "беларуские рубли");
        CURRENCIES.put("CAD", "канадские доллары");
        CURRENCIES.put("CHF", "швейцарские франки");
        CURRENCIES.put("CLP", "чилийские песо");
        CURRENCIES.put("CNY", "юани Женьминьби (Китай)");
        CURRENCIES.put("CZK", "чешские кроны");
        CURRENCIES.put("DKK", "датские кроны");
        CURRENCIES.put("DZD", "алжирские динары");
        CURRENCIES.put("EGP", "египетские фунты");
        CURRENCIES.put("EUR", "ЕВРО");
        CURRENCIES.put("GBP", "английские фунты стерлингов");
        CURRENCIES.put("GEL", "грузинские лари");
        CURRENCIES.put("HKD", "гонконгские доллары");
        CURRENCIES.put("HRK", "хорватские куны");
        CURRENCIES.put("HUF", "венгерские форинты");
        CURRENCIES.put("ILS", "израильские шекели");
        CURRENCIES.put("INR", "индийские рупии");
        CURRENCIES.put("JPY", "японские иены");
        CURRENCIES.put("KGS", "сомы Кыргызстана");
        CURRENCIES.put("KRW", "воны Республики Корея");
        CURRENCIES.put("KWD", "кувейтские динары");
        CURRENCIES.put("KZT", "казахские теньге");
        CURRENCIES.put("LBP", "ливанские фунты");
        CURRENCIES.put("MDL", "молдавские леи");
        CURRENCIES.put("MXN", "мексиканские новые песо");
        CURRENCIES.put("NOK", "норвежские кроны");
        CURRENCIES.put("NZD", "новозеландские доллары");
        CURRENCIES.put("PKR", "пакистанские рупии");
        CURRENCIES.put("PLN", "польские злотые");
        CURRENCIES.put("RON", "новые румынские леи");
        CURRENCIES.put("RUB", "российские рубли");
        CURRENCIES.put("SAR", "риалы Саудовской Аравии");
        CURRENCIES.put("SEK", "шведские кроны");
        CURRENCIES.put("SGD", "сингапурские доллары");
        CURRENCIES.put("THB", "таиландские баты");
        CURRENCIES.put("TJS", "таджикские сомоны");
        CURRENCIES.put("TMT", "новые туркменские манаты");
        CURRENCIES.put("TRY", "новые турецкие лиры");
        CURRENCIES.put("TWD", "новые тайванские доллары");
        CURRENCIES.put("USD", "доллары США");
        CURRENCIES.put("VND", "вьетнамские донги");

        ORG_TYPES.put(1, "Банки");
        ORG_TYPES.put(2, "Обменники");
    }
}
