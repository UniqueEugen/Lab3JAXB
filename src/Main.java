import JAXB.test.MarshllerUnmarshaller;
import myLibrary.console.Console;
import myLibrary.input.Scan;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MarshllerUnmarshaller.marshal();
        boolean flag;
        flag=false;
        while (!flag){
            Console.log("1.Вывести данные.\n2Выход");
            switch(Scan.intScan()){
                case 1:
                    MarshllerUnmarshaller.unmarshal();
                    break;
                case 2:
                    flag=true;
                    break;
                default:
                    Console.log("Неверрный ввод!");
                    break;
            }
        }
    }
}