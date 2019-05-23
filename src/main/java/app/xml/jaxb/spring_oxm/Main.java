package app.xml.jaxb.spring_oxm;

import app.model.food.Ramen;
import com.sun.tools.internal.ws.processor.model.jaxb.JAXBProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private Marshaller marshaller;

    private Marshaller unMarshaller;


    public void marshal() {

        Map<String, Object> map = new HashMap<>();
        map.put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        map.put(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true);
        ((Jaxb2Marshaller)marshaller).setMarshallerProperties(map);
//        User hiroshi = new User("hiroshi", "nohara", "kasukabe", "misae");

        Ramen miso = new Ramen("miso", "sapporo");
        try {
            StreamResult result = new StreamResult(Files.newOutputStream(Paths.get("/Users/dentaira/programming/java/XmlMapper/src/main/resources/output/sample")));
            marshaller.marshal(miso, result);
            System.out.println(result);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void main(String[] args) {

        ApplicationContext appContext
                = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
        Main main = (Main) appContext.getBean("main");
        main.marshal();
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnMarshaller(Marshaller unMarshaller) {
        this.unMarshaller = unMarshaller;
    }
}
