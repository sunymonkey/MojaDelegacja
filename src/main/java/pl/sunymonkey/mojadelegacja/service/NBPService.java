package pl.sunymonkey.mojadelegacja.service;

import org.springframework.web.client.RestTemplate;
import pl.sunymonkey.mojadelegacja.model.NBP;
import pl.sunymonkey.mojadelegacja.model.Rates;

import java.time.LocalDate;

public class NBPService {

    private final RestTemplate restTemplate = new RestTemplate();

    public double getExchangeRate(String currency) {
        switch(currency) {
            case "USD":
                return usdExchangeRate();
            case "EUR":
                return eurExchangeRate();
            case "AUD":
                return audExchangeRate();
            case "DKK":
                return dkkExchangeRate();
            case "JPY":
                return jpyExchangeRate();
            case "CAD":
                return cadExchangeRate();
            case "CHF":
                return chfExchangeRate();
            case "NOK":
                return nokExchangeRate();
            case "SEK":
                return sekExchangeRate();
            case "GBP":
                return gbpExchangeRate();
        }
        return 0;
        }

    public double getExchangeRate(String currency, LocalDate date){
        switch(currency) {
            case "USD":
                return usdExchangeRate(date);
            case "EUR":
                return eurExchangeRate(date);
            case "AUD":
                return audExchangeRate(date);
            case "DKK":
                return dkkExchangeRate(date);
            case "JPY":
                return jpyExchangeRate(date);
            case "CAD":
                return cadExchangeRate(date);
            case "CHF":
                return chfExchangeRate(date);
            case "NOK":
                return nokExchangeRate(date);
            case "SEK":
                return sekExchangeRate(date);
            case "GBP":
                return gbpExchangeRate(date);
        }
        return 0;
    }

    private double connect(String url) {
        NBP response = restTemplate.getForObject(url, NBP.class);

        Rates[] rates = response.getRates();
        return rates[0].getMid();
    }

    private double gbpExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/gbp/%s/?format=json", date.toString());
        return connect(url);
    }

    private double sekExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/sek/%s/?format=json", date.toString());
        return connect(url);
    }

    private double nokExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/nok/%s/?format=json", date.toString());
        return connect(url);
    }

    private double chfExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/chf/%s/?format=json", date.toString());
        return connect(url);
    }

    private double cadExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/cad/%s/?format=json", date.toString());
        return connect(url);
    }

    private double jpyExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/jpy/%s/?format=json", date.toString());
        return connect(url);
    }

    private double dkkExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/dkk/%s/?format=json", date.toString());
        return connect(url);
    }

    private double audExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/aud/%s/?format=json", date.toString());
        return connect(url);
    }

    private double eurExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/eur/%s/?format=json", date.toString());
        return connect(url);
    }

    private double usdExchangeRate(LocalDate date) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/usd/%s/?format=json", date.toString());
        return connect(url);
    }

    private double gbpExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json";
        return connect(url);
    }

    private double sekExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/sek/?format=json";
        return connect(url);
    }

    private double nokExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/nok/?format=json";
        return connect(url);
    }

    private double chfExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=json";
        return connect(url);
    }

    private double cadExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=json";
        return connect(url);
    }

    private double jpyExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=json";
        return connect(url);
    }

    private double dkkExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/dkk/?format=json";
        return connect(url);
    }

    private double audExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=json";
        return connect(url);
    }

    private double eurExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json";
        return connect(url);
    }

    private double usdExchangeRate() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=json";
        return connect(url);
    }

}
