package com.philips.lighting.quickstart;

import homeautomation.lights.ILight;
import homeautomation.lights.ILightColor;
import homeautomation.lights.ILightDim;
import homeautomation.lights.IStrobe;

import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLight.PHLightAlertMode;
import com.philips.lighting.model.PHLight.PHLightEffectMode;
import com.philips.lighting.model.PHLightState;

/**
 * MyApplicationActivity - The starting point for creating your own Hue App.
 * Currently contains a simple view with a button to change your lights to
 * random colours. Remove this and add your own app implementation here! Have
 * fun!
 * 
 * @author SteveyO
 * 
 */
public class MyApplicationActivity extends Activity implements ILight, IStrobe, ILightColor, ILightDim {
	private PHHueSDK phHueSDK;
	private static final int MAX_HUE = 65535;
	public static final String TAG = "QuickStart";
	public EditText edit;
	public static int timeRight = 0;
	public static int timeLeft = 0;
	final static int timeInt = 800;

	// Will is taking over
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(R.string.app_name);
		setContentView(R.layout.activity_main);
		phHueSDK = PHHueSDK.create();
		
		
		
	}
	
	public void onResume() {
		super.onResume();
		

		PHBridge bridge = phHueSDK.getSelectedBridge();
		PHLightState lightState = new PHLightState();
		final List<PHLight> allLights = bridge.getResourceCache()
				.getAllLights();
		lightState.setOn(true);
		lightState.setBrightness(50);
		lightState.setHue(46920);
		bridge.updateLightState(allLights.get(2), lightState,
				listener);
		
		
	}

	public void turnLeft(View view) {
		PHBridge bridge = phHueSDK.getSelectedBridge();

		
		final List<PHLight> allLights = bridge.getResourceCache()
				.getAllLights();
		
		for (int i = 0; i < 5; i++) {
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					PHBridge bridge = phHueSDK.getSelectedBridge();

					PHLightState lightState = new PHLightState();
					//lightState.setTransitionTime(800);
					lightState.setOn(true);
					lightState.setBrightness(50);
					lightState.setHue(0);
					lightState.setTransitionTime(800);
					lightState.setAlertMode(PHLightAlertMode.ALERT_SELECT);
					lightState.setEffectMode(PHLightEffectMode.EFFECT_NONE);
					bridge.updateLightState(allLights.get(1), lightState,
							listener);
							
				}

			}, timeLeft += timeInt); // adding one sec delay

			Handler handler1 = new Handler();
			handler1.postDelayed(new Runnable() {
				@Override
				public void run() {

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setOn(false);
					lightState.setBrightness(50);
					lightState.setHue(0);
					bridge.updateLightState(allLights.get(1), lightState,
							listener);

				}

			}, 6*timeInt); // adding one sec delay
		}
		
		timeLeft=0;
		

	}
	
	public void breakLight(View view){
        PHBridge bridge = phHueSDK.getSelectedBridge();

		  List<PHLight> allLights = bridge.getResourceCache().getAllLights();
	        Random rand = new Random();
	        
	        for (PHLight light : allLights) {
	            PHLightState lightState = new PHLightState();
	        	lightState.setOn(false);
				lightState.setBrightness(50);
	            lightState.setHue(0);
	            // To validate your lightstate is valid (before sending to the bridge) you can use:  
	            // String validState = lightState.validateState();
	            bridge.updateLightState(light, lightState, listener);
	            //  bridge.updateLightState(light, lightState);   // If no bridge response is required then use this simpler form.
	        }
	}
	
	public void accel(View view) {
		
		PHBridge bridge = phHueSDK.getSelectedBridge();
		PHLightState lightState = new PHLightState();
		final List<PHLight> allLights = bridge.getResourceCache()
				.getAllLights();
		lightState.setOn(true);
		lightState.setBrightness(50);
		lightState.setHue(46920);
		bridge.updateLightState(allLights.get(2), lightState,
				listener);
	}


	// Colors
	// 0 : red
	// 49000: cool color
	// 59000: cool color
	// 39000: cool color

	public void turnRight(View view) {
PHBridge bridge = phHueSDK.getSelectedBridge();

		
		final List<PHLight> allLights = bridge.getResourceCache()
				.getAllLights();
		
		for (int i = 0; i < 5; i++) {
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					PHBridge bridge = phHueSDK.getSelectedBridge();

					PHLightState lightState = new PHLightState();
					//lightState.setTransitionTime(800);
					lightState.setOn(true);
					lightState.setBrightness(50);
					lightState.setHue(0);
					lightState.setTransitionTime(800);
					lightState.setAlertMode(PHLightAlertMode.ALERT_SELECT);
					lightState.setEffectMode(PHLightEffectMode.EFFECT_NONE);
					bridge.updateLightState(allLights.get(0), lightState,
							listener);
							
				}

			}, timeLeft += timeInt); // adding one sec delay

			Handler handler1 = new Handler();
			handler1.postDelayed(new Runnable() {
				@Override
				public void run() {

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setOn(false);
					lightState.setBrightness(50);
					lightState.setHue(0);
					bridge.updateLightState(allLights.get(0), lightState,
							listener);

				}

			}, 6*timeInt); // adding one sec delay
		}
		
		timeLeft=0;
		
	}

	// If you want to handle the response from the bridge, create a
	// PHLightListener object.
	PHLightListener listener = new PHLightListener() {

		@Override
		public void onSuccess() {
		}

		@Override
		public void onStateUpdate(Map<String, String> arg0,
				List<PHHueError> arg1) {
			Log.w(TAG, "Light has updated");
		}

		@Override
		public void onError(int arg0, String arg1) {
		}

		@Override
		public void onReceivingLightDetails(PHLight arg0) {
		}

		@Override
		public void onReceivingLights(List<PHBridgeResource> arg0) {
		}

		@Override
		public void onSearchComplete() {
		}
	};

	@Override
	protected void onDestroy() {
		PHBridge bridge = phHueSDK.getSelectedBridge();
		if (bridge != null) {

			if (phHueSDK.isHeartbeatEnabled(bridge)) {
				phHueSDK.disableHeartbeat(bridge);
			}

			phHueSDK.disconnect(bridge);
			super.onDestroy();
		}
	}

	@Override
	public void Dim(float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(float h, float s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void StrobeOn() {
			
	}

	@Override
	public void StrobeOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean On() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Off() {
		// TODO Auto-generated method stub
		
	}
}
