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

    public BigDecimal getStockPrice() throws IOException
    {

        Stock stock = YahooFinance.get(company);
        //stock.print();
        BigDecimal price = stock.getQuote().getPrice();


        return price;
    }


    @Override
    public void run() {
        BigDecimal subtotal = new BigDecimal(0.0);
        try {

            //synchronized(this) {

                BigDecimal price = getStockPrice();

                subtotal = subtotal.add(price);

            TestStock.total = subtotal;

            System.out.println(TestStock.total);
            //}

            //notify();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


}
