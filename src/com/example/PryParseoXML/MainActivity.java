package com.example.PryParseoXML;

import android.app.Activity;
import android.os.Bundle;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        XmlPullParserFactory factory;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader("<div>Hello</div>"));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                if (eventType == XmlPullParser.START_DOCUMENT){
                    System.out.println(" ==== El documento ha comenzado ====");
                } else if (eventType == XmlPullParser.START_TAG) {
                    System.out.println("Start Tag: "+xpp.getName());
                } else if (eventType == XmlPullParser.END_TAG) {
                    System.out.println("End Tag: "+xpp.getName());
                } else if (eventType == XmlPullParser.TEXT) {
                    System.out.println("Text: "+xpp.getText());
                }
                eventType = xpp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
