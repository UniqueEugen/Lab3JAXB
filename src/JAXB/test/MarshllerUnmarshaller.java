package JAXB.test;

import JAXB.model.Catalog;
import JAXB.model.Animal;
import myLibrary.console.Console;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MarshllerUnmarshaller {

    private static final String XML_FILE = "E:/MTDWeb/MostBeautifulAnimalsThatIWantToHave.xml";

    public static void marshal() {

        Animal animal1 = new Animal("Mammal", "Rodent", "Beaver", 55.99, "Beavers are a genus of mammals from the order " +
                "of rodents. The only modern representative of the beaver family. It is divided into two species - the " +
                "common beaver, which lives in the area from the Atlantic coast to the Baikal region and Mongolia, and " +
                "the Canadian beaver - in North America.", UUID.randomUUID());
        Animal emp2 = new Animal("Mammal", "Mustelids", "Weasel", 180, "Weasel is the smallest representative of the" +
                " order of carnivores. Body weight of males is 60-250 g, females 53-120 g, body length of males is " +
                "160-260 mm, females 114-212 mm, tail length in males is 12-87 mm, in females 17-64 mm. Moves in leaps" +
                " 25-30 cm long.", UUID.randomUUID());
        Animal emp3 = new Animal("Mammal", "Rodent", "Ermine", 369.99,
                "The ermine is a small animal of a typical musteloid appearance with a long body on short " +
                        "legs (five-fingered limbs), a long neck and a triangular head with small rounded ears. The " +
                        "body length of the male is 17-38 cm (females are about half as long), the length of the tail" +
                        " is about 35% (one third) of the body length - 6-12 cm; body weight - from 70 to 260 g. The" +
                        " claws are very sharp, but rather weak and thin. It is similar to the common weasel, but is" +
                        " slightly larger in size and has a black fluffy tip of its longer tail. More similar to the" +
                        " long-tailed weasel, but smaller. At the base of the tail there are anal glands that secrete" +
                        " a liquid with an unpleasant odor (although less strong than in ferrets).", UUID.randomUUID());

        List<Animal> list = new ArrayList<Animal>();
        list.add(animal1);
        list.add(emp2);
        list.add(emp3);

        Catalog desiredАnimals = new Catalog("CAT2", "Desired Animals", "Zhlobin");
        List<Catalog> list1 = new ArrayList<Catalog>();
        list1.add(desiredАnimals);

        desiredАnimals.setAnimals(list);
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Catalog.class);
            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(desiredАnimals, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(desiredАnimals, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void unmarshal(){
        try{
            JAXBContext context = JAXBContext.newInstance(Catalog.class);
            // (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.


            Catalog deptFromFile1 = (Catalog) um.unmarshal(new FileReader(
                    XML_FILE));
            List<Animal> animals = deptFromFile1.getAnimals();
            animals.forEach(animal-> Console.log("Animal: " + animal.getKind()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
