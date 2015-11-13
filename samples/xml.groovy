import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.EntityResolver;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

public class XMLReader {

    Map<String, Set<Map <String, String>>> global;
    
    public String get(String path) {
        String[] toks = path.split("\\.");

        Set<Map<String,String>> mySet;
        mySet = global.get(toks[1]);
        
        for(Map<String,String> mm:mySet) {
            for(String key : mm.keySet()) {
                if (key == toks[2]) {
                    return mm.get(toks[2])
                }
            }
        }
    
        return false
    }
    
    public void run() {
    println new Object(){}.getClass().getEnclosingMethod().getName();
    return;
        try {
            File file = new File("/Users/tonydt/git/ec-nevec/component_nevec_egs_ecid_client_java/src/test/resources/remoteConfigSample.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setEntityResolver(new EntityResolver()
        {
            public InputSource resolveEntity(String publicId, String systemId)
                throws SAXException, IOException
            {
                return new InputSource(new StringReader(""));
            }
        });
            Document doc = db.parse(file);
            NodeList configs = doc.getElementsByTagName("config");
            global = new HashMap<String, Set<Map <String, String>>>();
            
            for(int x=0; x<configs.getLength(); x++) {
                String name = configs.item(x).getAttributes().getNamedItem("name").getNodeValue();
                
                if (name == "global") {
                    //do nothing
                } else {                    
                    Node childNode = configs.item(x).getFirstChild();     
                    Set<Map <String, String>> props = new HashSet<Map <String, String>>();
                    while( childNode.getNextSibling()!=null ){               
                        childNode = childNode.getNextSibling();         
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {         
                            Element childElement = (Element) childNode;             
                            Map <String, String> prop = new HashMap<String, String>();
                            prop.put(childElement.getAttribute("key"), childElement.getAttribute("value"))
                            props.add(prop);
                        }       
                    }
                    global.put(name, props);

                }
                
            }
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

def f = new XMLReader()
f.run()
println f.get("global.mysql_read.user")