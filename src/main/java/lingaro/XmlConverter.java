package lingaro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

public class XmlConverter {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void convertFromObjectToXML(Object object, String filepath) throws IOException, JAXBException {
        try (FileOutputStream os = new FileOutputStream(filepath)) {
            marshaller.marshal(object, new StreamResult(os));
        }catch(Exception e){
            throw e;
        }

    }

    public Object convertFromXMLToObject(String xmlfile) throws IOException, JAXBException {
        try (FileInputStream is = new FileInputStream(xmlfile)){
            return unmarshaller.unmarshal(new StreamSource(is));
        } catch(Exception e){
            throw e;
        }
    }
}
