 /*  -------------------- Program Information --------------------
    Name Of Program: XMLFiloIO.java
    Date of Creation: 15/12/20
    Name of Author(s): Farzad Rahman
    Course: ICS 4UI
    Description: This program creates a timetable as designed in the assignment details. Once the user is ready,
                    the program reads and updates it with school info, and an additional course, all in a new updated XML file.
   
-------------------- Program Information --------------------  */


package Assignment_3_ICS_4UI;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.*;

public class XMLFileIO {
    
    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        String filepath = ("Assignment_3_ICS_4UI\\timetable.XML");
        create(filepath); 
        System.out.println("\n Type 'ready' when you are ready to proceed to the edits.");
        String confirm = sc.nextLine();
        confirm = confirm.toLowerCase();
        if (confirm.equals("ready"));
            System.out.println("\n Get ready for some real magic now.");
            Edit(filepath);
        sc.close();
          
}

public static void create(String Location){            // This method creates the timetable XML file with the original elements as instructed
    try {
        DocumentBuilderFactory dbFactory =
        DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        

        Element rootElement = doc.createElement("timetable");
        doc.appendChild(rootElement);

        Element course = doc.createElement("course");
         rootElement.appendChild(course);

         Element code = doc.createElement("code");
         code.appendChild(doc.createTextNode("ICS4U"));
         course.appendChild(code);

         Element description = doc.createElement("description");
         description.appendChild(doc.createTextNode("Computer Programming, Grade 12, University"));
         course.appendChild(description);

         Element teacher = doc.createElement("teacher");
         teacher.appendChild(doc.createTextNode("Teacher A"));
         course.appendChild(teacher);

         Element room = doc.createElement("room");
         room.appendChild(doc.createTextNode("Lab 8-11"));
         course.appendChild(room);


         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         DOMSource domSource = new DOMSource(doc);
         StreamResult result = new StreamResult(new File(Location));

         transformer.transform(domSource, result);
         System.out.println("Timetable created");

      } catch (Exception e) {
         e.printStackTrace();
      } 
}





public static void Edit(String Location){          // This method makes the instructed edits to the files
    File file = new File(Location);

try {
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(file);

        
        NodeList timetable = doc.getElementsByTagName("timetable");
        for (int i = 0; i < timetable.getLength(); i++) {
            Element course = null;
            course = (Element) timetable.item(i);
            Node name = course.getElementsByTagName("teacher").item(0).getFirstChild();
            name.setNodeValue("Mr. Merritt");
            Node Room = course.getElementsByTagName("room").item(0).getFirstChild();
            Room.setNodeValue("Online");
        }


        NodeList course = doc.getElementsByTagName("course");
        for (int i = 0; i< course.getLength(); i++){
            Element room = null;
            room = (Element) course.item(i);
            Element School = doc.createElement("school");
            School.appendChild(doc.createTextNode("Waterloo Collegiate Institute"));
            room.appendChild(School);
        }

       
        Element iDontKnow = null;
        for (int i = 0; i < timetable.getLength(); i++) {
            iDontKnow = (Element) timetable.item(i);
            Element Course2 = doc.createElement("course");
            Element code = doc.createElement("code");
            Element description = doc.createElement("description");
            Element teacher = doc.createElement("teacher");
            Element room = doc.createElement("room");
            Element school = doc.createElement("school");

            code.appendChild(doc.createTextNode("SPH4U"));
            description.appendChild(doc.createTextNode("Physics, Grade 12, University"));
            teacher.appendChild(doc.createTextNode("Mr. Valeda"));
            room.appendChild(doc.createTextNode("Online"));
            school.appendChild(doc.createTextNode("Waterloo Collegiate Institute"));

            Course2.appendChild(code);
            Course2.appendChild(description);
            Course2.appendChild(teacher);
            Course2.appendChild(room);
            Course2.appendChild(school);
            iDontKnow.appendChild(Course2);
            
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(new File("Assignment_3_ICS_4UI\\NEWtimetable.XML"));
        transformer.transform(source, result);
    }catch (ParserConfigurationException pce) {
        pce.printStackTrace();
       } catch (TransformerException tfe) {
        tfe.printStackTrace();
       } catch (IOException ioe) {
        ioe.printStackTrace();
       } catch (SAXException sae) {
        sae.printStackTrace();
    } 


}
}
    

