
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author tun
 */
public class XmlFormatter {

    public XmlFormatter() {
    }

    public String format(String unformattedXml) {
        try {
            final Document document = parseXmlFile(unformattedXml);

            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);

            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<current><city id=\"1581130\" name=\"Ha Noi\"><coord lon=\"105.84\" lat=\"21.02\"></coord><country>VN</country><sun rise=\"2018-11-09T23:03:56\" set=\"2018-11-10T10:16:51\"></sun></city><temperature value=\"297.15\" min=\"297.15\" max=\"297.15\" unit=\"kelvin\"></temperature><humidity value=\"88\" unit=\"%\"></humidity><pressure value=\"1015\" unit=\"hPa\"></pressure><wind><speed value=\"1.5\" name=\"Calm\"></speed><gusts></gusts><direction value=\"320\" code=\"NW\" name=\"Northwest\"></direction></wind><clouds value=\"75\" name=\"broken clouds\"></clouds><visibility value=\"5000\"></visibility><precipitation mode=\"no\"></precipitation><weather number=\"701\" value=\"mist\" icon=\"50d\"></weather><lastupdate value=\"2018-11-10T07:00:00\"></lastupdate></current>";
        String s2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><current><city id=\"2643743\" name=\"London\"><coord lon=\"-0.13\" lat=\"51.51\"></coord><country>GB</country><sun rise=\"2018-11-10T07:10:11\" set=\"2018-11-10T16:18:02\"></sun></city><temperature value=\"282.26\" min=\"281.15\" max=\"283.15\" unit=\"kelvin\"></temperature><humidity value=\"93\" unit=\"%\"></humidity><pressure value=\"995\" unit=\"hPa\"></pressure><wind><speed value=\"1.5\" name=\"Calm\"></speed><gusts></gusts><direction value=\"0\" code=\"N\" name=\"North\"></direction></wind><clouds value=\"40\" name=\"scattered clouds\"></clouds><visibility value=\"10000\"></visibility><precipitation mode=\"no\"></precipitation><weather number=\"802\" value=\"scattered clouds\" icon=\"03n\"></weather><lastupdate value=\"2018-11-10T06:50:00\"></lastupdate></current>";
        String unformattedXml
                = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<current>"
                + "<city id=\"1581130\" name=\"Ha Noi\">"
                + "<coord lon=\"105.84\" lat=\"21.02\"></coord>"
                + "<country>VN</country>"
                + "<sun rise=\"2018-11-09T23:03:56\" set=\"2018-11-10T10:16:51\"></sun>"
                + "</city>"
                + "<temperature value=\"297.15\" min=\"297.15\" max=\"297.15\" unit=\"kelvin\"></temperature>"
                + "<humidity value=\"88\" unit=\"%\"></humidity>"
                + "<pressure value=\"1015\" unit=\"hPa\"></pressure>"
                + "<wind>"
                + "<speed value=\"1.5\" name=\"Calm\"></speed>"
                + "<gusts></gusts>"
                + "<direction value=\"320\" code=\"NW\" name=\"Northwest\"></direction>"
                + "</wind>"
                + "<clouds value=\"75\" name=\"broken clouds\"></clouds>"
                + "<visibility value=\"5000\"></visibility>"
                + "<precipitation mode=\"no\"></precipitation>"
                + "<weather number=\"701\" value=\"mist\" icon=\"50d\">"
                + "</weather>"
                + "<lastupdate value=\"2018-11-10T07:00:00\">"
                + "</lastupdate>"
                + "</current>";

        System.out.println(new XmlFormatter().format(s2));
    }

}
