package com.androidvideoplayer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * This class is responsible for Communication 
 * 
 * 
 *
 */
public class Communication{
	/**
	 * variable===>"finalData" will have XML
	 * which has to be sent to the server
	 * 
	 */
	private String finalData;
	
	private static final int TIME_OUT_PERIOD=20000;// 20 seconds

	private URL url;

	public static final int WHO_AM_I=-1;

	public static final int USER_PROFILE=-2;

	private int type;

	public Communication(String finalData,URL url,int type) {
		AdsOnUILog.displayLog("Communication initializing with data ==> " + finalData + "\n\n and url ==> " + url);

		this.finalData = finalData;
		this.url=url;
		this.type=type;
	}

	public boolean sendAndFillResultIn(StringBuffer retString ) throws Exception {
		if(retString==null) {
			throw new IllegalArgumentException("Parameter Sent as Null!");
		}
		try {
			AdsOnUILog.displayLog("I will send data , sendAndFillResultIn function");

			String data ="";
//			Toast.makeText(ctxx, "Communication type "+type, Toast.LENGTH_LONG).show();	
			if(type==WHO_AM_I) {
				data = URLEncoder.encode("request", "UTF-8") +
						"=" + URLEncoder.encode(finalData.toString(), "UTF-8");
//				Toast.makeText(ctxx, "Communication data "+data, Toast.LENGTH_LONG).show();
			}
			else if(type==USER_PROFILE) {
				data = URLEncoder.encode("httpRequest", "UTF-8") +
						"=" + URLEncoder.encode(finalData.toString(), "UTF-8");
//				Toast.makeText(ctxx, "Communication data "+data, Toast.LENGTH_LONG).show();
			}

			URLConnection conn = url.openConnection();
//			Toast.makeText(ctxx, "Communication conn "+conn, Toast.LENGTH_LONG).show();	
			
			conn.setConnectTimeout(TIME_OUT_PERIOD);
			conn.setReadTimeout(TIME_OUT_PERIOD);
			conn.setDoOutput(true);

			//======Send data==================
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//			Toast.makeText(ctxx, "Communication wr "+wr, Toast.LENGTH_LONG).show();
			wr.write(data);
			wr.flush();

			//=======Get the response==========
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			Toast.makeText(ctxx, "Communication rd "+rd, Toast.LENGTH_LONG).show();	
			String line;

			while ((line = rd.readLine()) != null) {
				retString.append(line);
			}
			wr.close();
			rd.close();
			return true;
		}
		
		catch (Exception e) {
			AdsOnUILog.displayLog("Exception in communication  " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
}