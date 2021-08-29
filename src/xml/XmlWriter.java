package xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import domain.Deposit;

public class XmlWriter {

	public void wright(List<Deposit> deposits, String fileName) throws FileNotFoundException, XMLStreamException {
		XMLStreamWriter writer = null;
		try {
			XMLOutputFactory factory = XMLOutputFactory.newFactory();
			writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
			writer.writeStartDocument("UTF-8", "1.0");
			
			writer.writeStartElement("deposits");
			writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			writer.writeAttribute("xmlns", "http://www.example.org/deposits");
			writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/deposits deposits.xsd");
			
			for (Deposit deposit : deposits) {
				writer.writeStartElement("deposit");
				 writer.writeAttribute("id", deposit.getId());
				
				  writer.writeStartElement("name");
				  writer.writeCharacters(deposit.getName());
				  writer.writeEndElement();
				  
				writer.writeStartElement("country");
				writer.writeCharacters(deposit.getCountry());
				writer.writeEndElement();
				
				writer.writeStartElement("type");
				writer.writeCharacters(deposit.getType());
				writer.writeEndElement();
				
				writer.writeStartElement("depositor");
				
					writer.writeStartElement("depositor-name");
					writer.writeCharacters(deposit.getDepositorName());
					writer.writeEndElement();
					
					writer.writeStartElement("depositor-surname");
					writer.writeCharacters(deposit.getDepositorSurname());
					writer.writeEndElement();
					
				writer.writeEndElement();
				
				writer.writeStartElement("account-id");
				writer.writeCharacters(deposit.getAccountId().toString());
				writer.writeEndElement();
				
				writer.writeStartElement("amount-on-deposit");
				writer.writeCharacters(deposit.getAmountDeposit().toString());
				writer.writeEndElement();
				
				writer.writeStartElement("profitability");
				writer.writeCharacters(deposit.getProfitability().toString());
				writer.writeEndElement();
				
				Integer i = deposit.getTimeConstraints();
				if (i != null) {
					writer.writeStartElement("time-constraints");
					writer.writeCharacters(i.toString());
					writer.writeEndElement();
				
				}
				writer.writeEndElement();
				}
				writer.writeEndElement();
				writer.writeEndDocument();
				
				
		}finally {
			try {
				writer.close();
			}catch (Exception e) {
				
			}
		}
	}

}
