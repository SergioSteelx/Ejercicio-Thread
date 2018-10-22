package mx.com.superq;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

public class StockRetriever implements Runnable
{
    private String company;



    public StockRetriever(String company)
    {
        this.company=company;
    }

    @Override
    public void run() {
        BigDecimal subtotal = new BigDecimal(0.0);
        try
        {

            Stock stock = YahooFinance.get(company);

            BigDecimal price = stock.getQuote().getPrice();

            subtotal = subtotal.add(price);

            //System.out.println(subtotal);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
