package io;

import java.util.Scanner;
import models.FinancialModels;

public class InputOutputTool {
    
    FinancialModels model = new FinancialModels();
    Scanner sc;

    public void welcome() {
        System.out.println(this.welcomeString);
        this.menu();
    }
    
    public void menu() {
        System.out.println(this.menuString);
        sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equals("1")) {
            this.futureCapitalChosen();
        }
        else if(input.equals("2")) {
            this.interestChosen();
        }
        else if(input.equals("3")) {
            this.numerOfPeriodsChosen();
        }
        else if(input.equals("4")) {
            this.presentCapitalChosen();
        }
        else if(input.equals("5")) {
            this.annuitetsopsparingChosen();
        }
        else if(input.equals("6")) {
            System.out.println("Programmet afsluttes");
        }
        else {
            System.out.println("error 404: ukendt forespøgsel, prøv venligst igen");
        }
    }
    
    public void futureCapitalChosen() {
        System.out.println("Venligst indtast din nuværende kapital: ");
        double capital = (double) Double.parseDouble(sc.nextLine());
        System.out.println("Venligst indtast din rente i antal procent: ");
        double interest = (double) Double.parseDouble(sc.nextLine())/100;
        System.out.println("Venligst indtast den ønskede tidsperiode i antal terminer: ");
        double periods = (double) Double.parseDouble(sc.nextLine());
        double result = model.calculateFutureCapital(capital, interest, periods);
        System.out.println("Om "+periods+" terminer med følgende kapital: "+capital+" og renten: "+interest+" vil du nå følgende sum "+result+"\n");
        menu();
    }
    
    public void numerOfPeriodsChosen() {
        System.out.println("Venligst indtast din nuværende kapital: ");
        double presentCapital = (double) Double.parseDouble(sc.nextLine());
        System.out.println("Venligst indtast din rente i antal procent: ");
        double interest = (double) Double.parseDouble(sc.nextLine())/100;
        System.out.println("Venligst indtast din ønskede slutkapital");
        double futureCapital = (double) Double.parseDouble(sc.nextLine());
        double result = model.calculatePeriods(futureCapital, presentCapital, interest);
        System.out.println("Med startkapitalen: "+presentCapital+", renten: "+interest+", og ønskede slutkapital på "+futureCapital+", vil du skulle vente "+result+" terminer\n");
        menu();
    }
    
    public void presentCapitalChosen() {
        System.out.println("Venligst indtast din ønskede slutkapital: ");
        double futureCapital = (double) Double.parseDouble(sc.nextLine());
        System.out.println("Venligst indtast din rente i antal procent: ");
        double interest = (double) Double.parseDouble(sc.nextLine())/100;
        System.out.println("Venligst indtast antallet af terminer");
        double periods = (double) Double.parseDouble(sc.nextLine());
        double result = model.calculatePresentCapital(futureCapital, interest, periods);
        System.out.println("Hvis slutkapitalen skal være "+futureCapital+", med en rente på "+interest+", og det strækker sig over "+periods+", terminer vil man altså have en startkapital på "+result+"kr.\n");
        menu();
    }
    
    public void interestChosen() {
        System.out.println("Venligst indtast din nuværende kapital: ");
        double presentCapital = (double) Double.parseDouble(sc.nextLine());
        System.out.println("Venligst indtast antallet af terminer ");
        double periods = (double) Double.parseDouble(sc.nextLine());
        System.out.println("Venligst indtast din ønskede slutkapital");
        double futureCapital = (double) Double.parseDouble(sc.nextLine());
        double result = model.calculatePeriods(futureCapital, presentCapital, periods);
        System.out.println("Med startkapital: "+presentCapital+", slutkapital: "+futureCapital+", og antallet af terminer: "+periods+", har du modtaget renten: "+result+"\n");
        menu();
    }
   
    public void annuitetsopsparingChosen() {
        System.out.println("Venligst indtast din indbetalingsrate: ");
        double payRate = (double) Double.parseDouble(sc.nextLine());
        System.out.println("Venligst indtast din rente i antal procent: ");
        double interest = (double) Double.parseDouble(sc.nextLine())/100;
        System.out.println("Venligst indtast den ønskede tidsperiode i antal terminer: ");
        double periods = (double) Double.parseDouble(sc.nextLine());
        double result = model.calculateFutureCapital(payRate, interest, periods);
        System.out.println("ved en indbetaling på "+payRate+"kr. hvert termin i "+periods+" terminer med en rente på "+interest+" vil du opnå følgende sum "+result+"\n");
        menu();
    }

    String welcomeString = "\n\n\n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + " _______ _______ _______ _______ _______ _______ _______ _______ _______ \n"
            + "(_______|_______|_______|_______|_______|_______|_______|_______|_______)\n"
            + "                                                                         \n"
            + " _     _       _  _                                           _ _        \n"
            + "(_)   (_)     | || |                                      _  (_) |       \n"
            + " _     _ _____| || |  _ ___  ____  ____  _____ ____     _| |_ _| |       \n"
            + "| |   | | ___ | || |_/ ) _ \\|    \\|    \\| ___ |  _ \\   (_   _) | |       \n"
            + " \\ \\ / /| ____| ||  _ ( |_| | | | | | | | ____| | | |    | |_| | |       \n"
            + "  \\___/ |_____)\\_)_| \\_)___/|_|_|_|_|_|_|_____)_| |_|     \\__)_|\\_)      \n"
            + "                                                                         \n"
            + "     _                   ___ _                        _       _ _        \n"
            + "    | |                 / __|_)                      (_)     | | |       \n"
            + "  __| |_____ ____     _| |__ _ ____  _____ ____   ___ _ _____| | | _____ \n"
            + " / _  | ___ |  _ \\   (_   __) |  _ \\(____ |  _ \\ /___) | ___ | | || ___ |\n"
            + "( (_| | ____| | | |    | |  | | | | / ___ | | | |___ | | ____| | || ____|\n"
            + " \\____|_____)_| |_|    |_|  |_|_| |_\\_____|_| |_(___/|_|_____)\\_)_)_____)\n"
            + "                                                                         \n"
            + " _                                                                       \n"
            + "| |                                                                      \n"
            + "| | ___  ____  ____  _____  ____ _____  ____ ____  _____  ____           \n"
            + "| |/ _ \\|    \\|    \\| ___ |/ ___) ___ |/ _  |  _ \\| ___ |/ ___)          \n"
            + "| | |_| | | | | | | | ____| |   | ____( (_| | | | | ____| |              \n"
            + " \\_)___/|_|_|_|_|_|_|_____)_|   |_____)\\___ |_| |_|_____)_|              \n"
            + "                                      (_____|                            \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + " _______ _______ _______ _______ _______ _______ _______ _______ _______ \n"
            + "(_______|_______|_______|_______|_______|_______|_______|_______|_______)\n"
            + "                                                                         ";


    String menuString = "\n\n"
            + "\nVælg 1 for at beregne fremtidsværdi af nuværende kapital"
            + "\nVælg 2 for at beregne rente mellem to perioder"
            + "\nVælg 3 for at beregne antallet af terminer for at opnå en bestemt kapital"
            + "\nVælg 4 for at beregne fortidigværdi af nuværende kapital"
            + "\nVælg 5 for at beregne slutkapitalen ved indbetalingsrater"
            + "\nVælg 6 for at afslutte programmet";
    
}
