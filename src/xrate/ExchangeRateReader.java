package xrate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Provide access to basic currency exchange rate services.
 * 
 * @author PUT YOUR TEAM NAME HERE
 */
public class ExchangeRateReader {

	/**
	 * Construct an exchange rate reader using the given base URL. All requests
	 * will then be relative to that URL. If, for example, your source is Xavier
	 * Finance, the base URL is http://api.finance.xaviermedia.com/api/ Rates
	 * for specific days will be constructed from that URL by appending the
	 * year, month, and day; the URL for 25 June 2010, for example, would be
	 * http://api.finance.xaviermedia.com/api/2010/06/25.xml
	 * 
	 * @param baseURL
	 *            the base URL for requests
	 * @throws Exception 
	 */
	public String Url;
	public ExchangeRateReader(String baseURL) throws Exception {
		Url = baseURL;
	}

	/**
	 * Get the exchange rate for the specified currency against the base
	 * currency (the Euro) on the specified date.
	 * 
	 * @param currencyCode
	 *            the currency code for the desired currency
	 * @param year
	 *            the year as a four digit integer
	 * @param month
	 *            the month as an integer (1=Jan, 12=Dec)
	 * @param day
	 *            the day of the month as an integer
	 * @return the desired exchange rate
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public float getExchangeRate(String currencyCode, int year, int month, int day) throws ParserConfigurationException, SAXException {
		String dayString = String.valueOf(day);
		String monthString = String.valueOf(month);
		
		//Added this if statement to append 0 to the month and day if the month and day are single digit
		if( month < 10 ) {
			monthString= "0" + monthString;
		}
		if( day < 10 ) {
			dayString= "0" + dayString;
		}
		try {
			//Constructing the baseURL, with the year, month, and day modifiers well as the xml document type
			


			} catch (IOException ex) {
				System.out.println("Have problem with opening input stream");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * Get the exchange rate of the first specified currency against the second
	 * on the specified date.
	 * 
	 * @param currencyCode
	 *            the currency code for the desired currency
	 * @param year
	 *            the year as a four digit integer
	 * @param month
	 *            the month as an integer (1=Jan, 12=Dec)
	 * @param day
	 *            the day of the month as an integer
	 * @return the desired exchange rate
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public float getExchangeRate( String fromCurrency, String toCurrency, int year, int month, int day) {
		// TODO Your code here
		try {
			//Dividing the two corresponding rates from each country to obtain the exchange rate
			return (getExchangeRate(fromCurrency, year, month, day) / getExchangeRate(toCurrency, year, month, day));
		} catch (UnsupportedOperationException | ParserConfigurationException | SAXException e){
			throw new UnsupportedOperationException(); 
		}
	}


}
