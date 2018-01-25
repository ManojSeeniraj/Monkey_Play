package com.androidvideoplayer;

public class REPinConstants {
	public static final String max_version = "1.";

	public static final String min_version = "01";

	public static final int NETWORK_CONNECTIVITY_ERROR = 1004;

	public static final int PLUGIN_VERSION_MISMATCH = 1006;

	public static final int INVALID_APP_NAME = 1007;

	public static final int INVALID_UNIQUE_SIGNATURE_ID = 1008;

	public static final int INVALID_REGISTERED_BANNER_PET_NAME = 1009;

	public static final int MEMORY_INSUFFICIENT = 1010;
	
	public static final int INVALID_BANNER_PET_NAME = 1012;

	public static final int INVALID_REGISTERED_APP_NAME = 1014;
	
	public static final int INVALID_AD_VIEW_ID = 1015;

	public static final int INVALID_DEBUG_MODE = 1016;

	public static final int USER_PROFILE_NOT_AVAILABLE = 1017;	
	
	public static final int NETWORK_CONNECTION_ERROR = 1018;

	public static final int UNREGISTERED_UNIQUE_SIGNATURE_ID = 1020;
	
	public static final int INVALID_USER_GROUP = 90;
	
	public static final int INVALID_USER_PHONE_NUMBER = 80;
	
	public static final int SUCCESS = 0;
	
	public static final int INSTANCE_CREATED = 10;
	
	public static final int PLUGIN_ENABLED = 20;
	
	public static final int PLUGIN_DISABLED = 30;

	public static final String APP_NAME = "MyApp";

	public static final int TWO = 2;

	public static final String NULL = null;

	public static int TYPE_WIFI = 1;
	public static int TYPE_MOBILE = 2;
	public static int TYPE_NOT_CONNECTED = 0;

	/**
	 * For android 
	 */

	public static final String ADSONUI_LOCATION = "AdsOnUI";

	public static final String ADSONUI_DATA_LOCATION = "AdsOnUIData.data";

	public static final String ADT_LOCATION = "AdtData.data";

	/**
	 * Variable to set the connection time out with the server in milli seconds
	 */
	public static final int CONNECTION_TIMEOUT = 30000; // 30 seconds

	public static final int IMAGE_FETCHING_2G_CONNECTION_TIMEOUT = 60000; // 60 seconds

	public static final int IMAGE_FETCHING_3G_OR_WIFI_CONNECTION_TIMEOUT = 30000; // 30 seconds
	/**
	 * Request type 
	 * 
	 */
	public static final int REPEAT = 1;

	public static final int ADT = 2;

	public static final String TEMP_LOCATION = "Bangalore";

	/*
	 * Tag Names in AdsOnUIResponse 
	 */

	public static final String AD_URL = "AdURL";

	public static final String AD_COMPANION_URL = "AdCompanionURL";

	public static final String DISPLAY_TIME = "DisplayTime";

	public static final String ASSET_DISPLAY_MODE = "AssetDisplayMode";

	public static final String OPPORTUNITY = "Opportunity";
	
	public static final String OPPORTUNITY_ID = "OppId";
		
	public static final String SEQUENCE = "Sequence";

	public static final String ASSET = "Asset";

	public static final String Acknowledgement = "Acknowledgement";

	public static final String TIME_INTERVAL = "TimeInterval";

	public static final String ACTION = "Action";

	public static final String PRIMARY_IMAGE_URL = "PrimaryAdImageURL";

	public static final String PRIMARY_AUDIO_URL = "PrimaryAdAudioURL";

	public static final String PRIMARY_VIDEO_URL = "PrimaryAdVideoURL";

	public static final String AD_COMPANION_IMAGE_URL = "AdCompanionImageURL";

	public static final String AD_COMPANION_VIDEO_URL = "AdCompanionVideoURL";

	public static final String AD_COMPANION_LINK_URL = "AdCompanionLinkURL";

	public static final String PRIMARY_ASSET_TYPE = "PrimaryAssetType";

	public static final String ADCOMPANION_TYPE = "AdCompanionAssetType";

	public static final String SUCCESS_RESPONSE = "0";

	public static final String Invalid_Sub_Id_RESPONSE = "1000";

	public static final String Server_BUSY_RESPONSE = "1001";

	public static final int URL = 3;
	
	public static final int IMAGE_TYPE_JPEG=0; /*PNG and BMP is also considered as same */

	public static final int IMAGE_TYPE_GIF=3;

	/**
	 * Service Check Delay
	 */
	public static final int FAILURE=-1;

	public static final int RETRY=144;

	public static final int numberOfAttemptsInitialValue=1;

	public static final int finalNumberOfAttempts=1;

	public static final String CONNECTION_REFUSED = "Connection refused";

	public static final String VIEWED = "Viewed";

	public static final String INTERESTED = "Interested";
	
	public static final String whoAmIURL="/Who_am_I/response";
	
	public static final String userProfileURL="/SubscriberProfile/response";
	
	public static final String adsOnUiURL="/AdsOnUI/adsOnUIReq";
	
	public static final String ADT_ADS_ON_UI_URL="/AdsOnUIADT/adsOnUIADTReq";
	
	public static final int maximumNumberOfReattempts=3;

	public static final String VALUE_NOT_FOUND="NA";
}