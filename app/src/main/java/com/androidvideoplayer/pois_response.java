package com.androidvideoplayer;

/**
 * Created by s.manoj on 28-12-2017.
 */
import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;





public class pois_response {


    private String subscriberID;
    public String getSubscriberID() {
        return subscriberID;
    }

    public pois_response(String resultXML) throws XmlPullParserException,IOException

    {

        String tagName = "";
        final String ASSET_ID_TAG_NAME = "AssetId";
        final String TYPE_TAG_NAME = "Type";
        final String ARMWIDTH_ID_TAG_NAME = "ArmWidth";
        final String ARMHEIGHT_ID_TAG_NAME = "ArmHeight";
        final String DURATION_ID_TAG_NAME = "Duration";
        final String TIME_INTERVAL_ID_TAG_NAME = "TimeInterval";
        final String PRIORITY_ID_TAG_NAME = "Priority";
        final String DISPLAYPOSITION_CODE_ID_TAG_NAME = "DisplayPositionCode";
        final String BANNER_URL_ID_TAG_NAME = "BannerUrl";
        final String ADD_COMPANION_ASSET_TYPE_ID_TAG_NAME = "AdCompanionAssetType";
        final String ADD_COMPANION_LINK_URL_ID_TAG_NAME = "AdCompanionLinkURL";
        final String REPEAT_BANNER_ID_TAG_NAME = "RepeatBanner";

        AdsOnUILog.displayLog(resultXML);
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);

        String serverXmlString = resultXML.replaceAll(">\\s+<", "><").trim();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(serverXmlString));

        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_DOCUMENT) {
                AdsOnUILog.displayLog("Start document event");
            } else if (eventType == XmlPullParser.START_TAG) {
                if (parser.getName().equals(ASSET_ID_TAG_NAME)) {
                    tagName = ASSET_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                } else if (parser.getName().equals(TYPE_TAG_NAME )) {
                    tagName =TYPE_TAG_NAME ;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                } else if (parser.getName().equals(ARMWIDTH_ID_TAG_NAME)) {
                    tagName =ARMWIDTH_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }
                else if (parser.getName().equals(ARMHEIGHT_ID_TAG_NAME)) {
                    tagName =ARMHEIGHT_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }
                else if (parser.getName().equals( DURATION_ID_TAG_NAME)) {
                    tagName = DURATION_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }
                else if (parser.getName().equals( TIME_INTERVAL_ID_TAG_NAME)) {
                    tagName = TIME_INTERVAL_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }
                else if (parser.getName().equals(PRIORITY_ID_TAG_NAME)) {
                    tagName =PRIORITY_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }
                else if (parser.getName().equals(DISPLAYPOSITION_CODE_ID_TAG_NAME)) {
                    tagName =DISPLAYPOSITION_CODE_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }
                else if (parser.getName().equals(BANNER_URL_ID_TAG_NAME)) {
                    tagName =ADD_COMPANION_ASSET_TYPE_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }
                else if (parser.getName().equals(ADD_COMPANION_LINK_URL_ID_TAG_NAME)) {
                    tagName =ADD_COMPANION_LINK_URL_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }
                else if (parser.getName().equals(REPEAT_BANNER_ID_TAG_NAME)) {
                    tagName =REPEAT_BANNER_ID_TAG_NAME;
                    AdsOnUILog.displayLog(" Tag Nme => " + parser.getName());
                }

            } else if (eventType == XmlPullParser.TEXT) {
                if (parser.getText() != null && parser.getText().length() > 0) {
                    if (tagName.equals(ASSET_ID_TAG_NAME)) {
                        this.subscriberID = parser.getText();
                        AdsOnUILog.displayLog("subscriber id => " + this.subscriberID);
                    } else if (tagName.equals(TYPE_TAG_NAME)) {
                        AdsOnUILog.displayLog("start guard id => "
                                + Integer.parseInt(parser.getText()));
                    } else if (tagName.equals(ARMWIDTH_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals(ARMHEIGHT_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals(DURATION_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals(TIME_INTERVAL_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals(PRIORITY_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals(DISPLAYPOSITION_CODE_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals(BANNER_URL_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals( ADD_COMPANION_ASSET_TYPE_ID_TAG_NAME )) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals(ADD_COMPANION_LINK_URL_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                    else if (tagName.equals(REPEAT_BANNER_ID_TAG_NAME)) {
                        AdsOnUILog.displayLog("end guard id => "
                                + Integer.parseInt(parser.getText()));
                    }
                }
            } else if (eventType == XmlPullParser.END_TAG) {

            }
            eventType = parser.next();
        }
    }


}


