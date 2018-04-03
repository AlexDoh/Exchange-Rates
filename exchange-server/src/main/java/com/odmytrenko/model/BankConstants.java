package com.odmytrenko.model;

import java.util.HashMap;
import java.util.Map;

public class BankConstants {

    public static final Map<String, String> currencies;
    public static final Map<Integer, String> orgTypes;

    static {
        currencies = new HashMap<>();
        orgTypes = new HashMap<>();

        currencies.put("AED", "дирхамы ОАЭ");
        currencies.put("AMD", "армянские драмы");
        currencies.put("AUD", "австралийские доллары");
        currencies.put("AZN", "азербайджанские манаты");
        currencies.put("BGN", "болгарские левы");
        currencies.put("BRL", "бразильские реалы");
        currencies.put("BYN", "беларуские рубли");
        currencies.put("CAD", "канадские доллары");
        currencies.put("CHF", "швейцарские франки");
        currencies.put("CLP", "чилийские песо");
        currencies.put("CNY", "юани Женьминьби (Китай)");
        currencies.put("CZK", "чешские кроны");
        currencies.put("DKK", "датские кроны");
        currencies.put("DZD", "алжирские динары");
        currencies.put("EGP", "египетские фунты");
        currencies.put("EUR", "ЕВРО");
        currencies.put("GBP", "английские фунты стерлингов");
        currencies.put("GEL", "грузинские лари");
        currencies.put("HKD", "гонконгские доллары");
        currencies.put("HRK", "хорватские куны");
        currencies.put("HUF", "венгерские форинты");
        currencies.put("ILS", "израильские шекели");
        currencies.put("INR", "индийские рупии");
        currencies.put("JPY", "японские иены");
        currencies.put("KGS", "сомы Кыргызстана");
        currencies.put("KRW", "воны Республики Корея");
        currencies.put("KWD", "кувейтские динары");
        currencies.put("KZT", "казахские теньге");
        currencies.put("LBP", "ливанские фунты");
        currencies.put("MDL", "молдавские леи");
        currencies.put("MXN", "мексиканские новые песо");
        currencies.put("NOK", "норвежские кроны");
        currencies.put("NZD", "новозеландские доллары");
        currencies.put("PKR", "пакистанские рупии");
        currencies.put("PLN", "польские злотые");
        currencies.put("RON", "новые румынские леи");
        currencies.put("RUB", "российские рубли");
        currencies.put("SAR", "риалы Саудовской Аравии");
        currencies.put("SEK", "шведские кроны");
        currencies.put("SGD", "сингапурские доллары");
        currencies.put("THB", "таиландские баты");
        currencies.put("TJS", "таджикские сомоны");
        currencies.put("TMT", "новые туркменские манаты");
        currencies.put("TRY", "новые турецкие лиры");
        currencies.put("TWD", "новые тайванские доллары");
        currencies.put("USD", "доллары США");
        currencies.put("VND", "вьетнамские донги");

        orgTypes.put(1, "Банки");
        orgTypes.put(2, "Обменники");
    }
}
