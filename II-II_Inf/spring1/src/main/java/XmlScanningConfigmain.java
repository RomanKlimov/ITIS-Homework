import classes.Eur;
import classes.Usd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Scanner;

public class XmlScanningConfigmain {
    public static void main(String[] args) { new XmlScanningConfigmain();}
    public XmlScanningConfigmain(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your vallue to convert");
        Double money = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter the currency: ");
        String currency = sc.nextLine();
        System.out.println();

        ApplicationContext context
                = new FileSystemXmlApplicationContext(getClass().getResource("/converter.xml").toString());
        switch (currency) {
            case "Eur":

                Eur eur = (Eur) context.getBean("Eur");
                System.out.println(eur.convert(money));
                break;
            case "Usd":
                Usd usd = (Usd) context.getBean("Usd");
                System.out.println(usd.convert(money));
                break;
        }
    }
}
