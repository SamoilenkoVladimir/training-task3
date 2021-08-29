package xml;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import domain.Deposit;

public class Main {
	/*
	1.	Разработать для своего варианта структуру XML документа, описать её с помощью XSD. Создать файл XML, соответствующий разработанной XSD схеме.
	2.	При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения, обязательно использование атрибутов и типа ID.
	3.	Создать Java-класс(классы), соответствующие разработанной схеме.
	4.	Создать Java-приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла. Для разбора использовать SAX, DOM или StAX парсер. Для сортировки объектов использовать интерфейс Comparator.
	5.	Произвести проверку корректности и валидности XML-документа с привлечением XSD.
	вариант 15 
	15.	Банковские вклады.
•	Name – название банка
•	Country – страна регистрации.
•	Type – тип вклада (до востребования, срочный, расчетный, накопительный, сберегательный). 
•	Depositor – имя вкладчика.
•	Account id – номер счета.
•	Amount on deposit – сумма вклада.
•	Profitability – годовой процент.
•	Time constraints – срок вклада.

	*/

	public static void main(String[] args) throws IOException, XMLStreamException {
		DepositValidator validator = new DepositValidator("deposits.xml");
		if (validator.validate()) {
		
		XmlReader reader = new XmlReader();
		
			List<Deposit> deposits = reader.read("deposits.xml");
			
			
			for(Deposit deposit:deposits) {
				System.out.println(deposit);
			}
			
			//капитализация процентов за 1 день 
			for(Deposit deposit:deposits) {
				deposit.setAmountDeposit((long)(deposit.getAmountDeposit()+deposit.getAmountDeposit()*deposit.getProfitability()/100/365));
			}
			
			//сортировка по величине вклада
			Collections.sort(deposits, new Comparator<Deposit>(){
				public int compare(Deposit o1, Deposit o2) {
					return o2.getAmountDeposit().compareTo(o1.getAmountDeposit());
					
				}
			});
			System.out.println("\n вклады после капитализации процентов и сортировки по величине вклада: \n");
			for(Deposit deposit:deposits) {
				System.out.println(deposit);
			}
			XmlWriter writer = new XmlWriter();
			writer.wright(deposits, "NEWdeposits.xml");
		}else {
			System.out.println(validator.getError());
		}
		
		
		

	}

}

