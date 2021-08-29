package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import domain.Deposit;

public class XmlReader {
	public List<Deposit> read(String fileName) throws FileNotFoundException {
		XMLStreamReader reader = null;
		try {
			List<Deposit> deposits = new ArrayList<Deposit>();
			Deposit deposit = null;
			XMLInputFactory factory = XMLInputFactory.newFactory();
			reader = factory.createXMLStreamReader(new FileInputStream(fileName));
			while (reader.hasNext()) {
				int type = reader.next();
				switch (type) {
				case XMLStreamConstants.START_ELEMENT: {
					String tagName = reader.getLocalName();
					if ("deposit".equals(tagName)) {
						deposit = new Deposit();
						deposit.setId(reader.getAttributeValue(null, "id"));
					}else if ("name".equals(tagName)) {
						deposit.setName(reader.getElementText());
					}else if ("country".equals(tagName)) {
						deposit.setCountry(reader.getElementText());
					}else if ("type".equals(tagName)) {
						deposit.setType(reader.getElementText());
					}
					else if ("depositor-name".equals(tagName)) {
						deposit.setDepositorName(reader.getElementText());
					}else if ("depositor-surname".equals(tagName)) {
						deposit.setDepositorSurname(reader.getElementText());
					}else if ("account-id".equals(tagName)) {
						deposit.setAccountId(Long.parseLong(reader.getElementText()));
					}else if ("amount-on-deposit".equals(tagName)) {
						deposit.setAmountDeposit(Long.parseLong(reader.getElementText()));
					}else if ("profitability".equals(tagName)) {
						deposit.setProfitability(Integer.parseInt(reader.getElementText()));
					}else if ("time-constraints".equals(tagName)) {
						deposit.setTimeConstraints(Integer.parseInt(reader.getElementText()));
					}
					break;
					
					
				}
				case XMLStreamConstants.END_ELEMENT:{
					String tagName = reader.getLocalName();
					if ("deposit".equals(tagName)) {
						deposits.add(deposit);
						//System.out.println(deposit.toString());
					}
					break;
				}
				}
			}
			return deposits;
		}catch (XMLStreamException e) {
			return null;
		}finally {
			try {
				reader.close();
			}catch (Exception e) {}
		}
		
		
		
	}
}
