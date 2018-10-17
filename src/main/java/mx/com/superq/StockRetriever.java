package mx.com.superq;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

public class StockRetriever
{
    private String company;



    public StockRetriever(String company)
    {
        this.company=company;
    }

    public BigDecimal getStockPrice() throws IOException
    {
        Stock stock = YahooFinance.get(company);
        BigDecimal price = stock.getQuote().getPrice();
        return price;
    }



    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }




}
