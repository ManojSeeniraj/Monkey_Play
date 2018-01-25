package com.androidvideoplayer;

/**
 * Created by s.manoj on 28-12-2017.
 */

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class pois_request {


    private String Header;

    private String SubscriberId;

    private String UserId;

    private String TimeZone;

    private String TimeStamp;

    private String Mode;

    private String State;

    private String ChannelNumber;

    private String EventName;

    private String GeneORChannel;

    private String Resolution;

    private String AudioLanguage;

    private String Reattempt;

    /**
     *
     * @param Header
     * @param SubscriberId
     * @param UserId
     * @param TimeZone
     * @param TimeStamp
     * @param Mode
     * @param State
     * @param ChannelNumber
     * @param EventName
     * @param GeneORChannel
     * @param Resolution
     * @param AudioLanguage
     * @param Reattempt
     */

    public pois_request(String Header, String SubscriberId,
                        String UserId, String TimeZone,
                        String TimeStamp, String Mode, String State,
                        String ChannelNumber, String EventName,
                        String GeneORChannel, String Resolution,
                        String AudioLanguage, String Reattempt) {
        super();
        this.Header = Header;
        this.SubscriberId= SubscriberId;
        this. UserId =  UserId;
        this.TimeZone = TimeZone;
        this.TimeStamp = TimeStamp;
        this.Mode = Mode;
        this.State = State;
        this. ChannelNumber =  ChannelNumber;
        this.EventName = EventName;
        this.GeneORChannel =GeneORChannel;
        this. Resolution =  Resolution;
        this.AudioLanguage = AudioLanguage;
        this.Reattempt = Reattempt;

    }



    public String getHeader() {
        return Header;
    }

    public String getSubscriberId() {
        return SubscriberId;
    }

    public String getUserId(){
        return UserId;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public String getState() {
        return State;
    }

    public String getMode() {
        return Mode;
    }

    public String getChannelNumber(){
        return ChannelNumber;
    }

    public String getGeneORChannel() {
        return GeneORChannel;
    }

    public String getResolution() {
        return Resolution;
    }

    public String getAudioLanguage() {
        return AudioLanguage;
    }

    public String  getReattempt(){
        return Reattempt;
    }

    public String getEventName(){
        return EventName;
    }

    public pois_response sendRequestToServer(String serverURLString) {
        // Generate UUID using java.util.UUID
        UUID uid = UUID.randomUUID();

        int numberOfAttempts = 0;

        StringBuffer buf = new StringBuffer(R.xml.placement_request);
        buf.append("<PlacementRequest=\"" + uid + "\" Version=\"1.1\">");
        buf.append("<Header>" + getHeader() + "</Header>");
        buf.append("<SubscriberId>" + getSubscriberId()
                + "</SubscriberId>");
        buf.append("<UserId>" + getUserId() + "</UserId>");
        buf.append("<TimeZone>" + getTimeZone() + "</TimeZone>");
        buf.append("<TimeStamp>" + getTimeStamp() + "</TimeStamp>");
        buf.append("<Mode>" + getMode() + "</Mode>");
        buf.append("<ChannelNumber>" + getChannelNumber() + "</ChannelNumber>");
        buf.append("<EventName>" + getEventName() + "</EventName>");
        buf.append("<GenreORChannelName value=\"0>" + getGeneORChannel() + "</GenreORChannelName>");
        buf.append("<Resolution>" + getResolution() + "</Resolution>");

        buf.append("<EventName>" + getEventName() + "</EventName>");
        buf.append("<AudioLanguage>" + getAudioLanguage() + "</AudioLanguage>");
        buf.append("<Reattempt>" + getReattempt() + "</Reattempt>");
        buf.append("</PlacementRequest>");

        String clientXmlStr = buf.toString();
        AdsOnUILog.displayLog(clientXmlStr);
		/* Set URL Here */

        URL url=null;
        try
        {
            url=new URL(serverURLString);
        }catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        AdsOnUILog.displayLog("who am i Server URL -->  " + url);

        Communication communicationObject = new Communication(clientXmlStr,
                url, Communication.WHO_AM_I);

        while (numberOfAttempts < REPinConstants.maximumNumberOfReattempts) {
            StringBuffer result = new StringBuffer();
            try {
                communicationObject.sendAndFillResultIn(result);
            }
            catch (Exception e ) {
                e.printStackTrace();
                numberOfAttempts++;
                continue ;
            }

            pois_response out=null;
            try {
                out = new  pois_response(result.toString());
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return out;
        }
        return null;
    }
}