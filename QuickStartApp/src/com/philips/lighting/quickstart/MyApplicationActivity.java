package com.philips.lighting.quickstart;

import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
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
public class MyApplicationActivity extends Activity {
	private PHHueSDK phHueSDK;
	private static final int MAX_HUE = 65535;
	public static final String TAG = "QuickStart";
	public EditText edit;
	public static int timeRight= 1000;
	public static int timeLeft= 1000;
	final static int timeInt=300;


	// Will is taking over
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(R.string.app_name);
		setContentView(R.layout.activity_main);
		edit = (EditText) findViewById(R.id.editText1);
		phHueSDK = PHHueSDK.create();
		Button randomButton;
		randomButton = (Button) findViewById(R.id.buttonRand);
		randomButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				randomLights();
			}

		});

	}

	// Colors
	// 0 : red
	// 49000: cool color
	// 59000: cool color
	// 39000: cool color

	public void randomLights() {
		Toast.makeText(this, "yo", Toast.LENGTH_LONG).show();
		PHBridge bridge = phHueSDK.getSelectedBridge();

		final List<PHLight> allLights = bridge.getResourceCache()
				.getAllLights();
		Random rand = new Random();

		

		

			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setOn(true);

					lightState.setBrightness(50);
					lightState.setHue(0);
					bridge.updateLightState(allLights.get(0), lightState,
							listener);

				}

			}, timeLeft); // adding one sec delay

			Handler handler1 = new Handler();
			handler1.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setOn(true);

					lightState.setBrightness(50);

					
					lightState.setHue(0);
					bridge.updateLightState(allLights.get(2), lightState,
							listener);
					
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);
					bridge.updateLightState(allLights.get(0), lightState1,
							listener);
					
					

				}

			}, timeLeft+=timeInt); // adding one sec delay

			Handler handler2 = new Handler();

			handler2.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();


					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setBrightness(50);
					lightState.setOn(true);


					lightState.setHue(0);
					bridge.updateLightState(allLights.get(1), lightState,
							listener);
					
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);

					bridge.updateLightState(allLights.get(2), lightState1,
							listener);

				}

			}, timeLeft+=timeInt); // adding one sec delay
			
			Handler handler3 = new Handler();

			handler3.postDelayed(new Runnable() {
				@Override
				public void run() {


					PHBridge bridge = phHueSDK.getSelectedBridge();				
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);

					bridge.updateLightState(allLights.get(1), lightState1,
							listener);

				}

			}, timeLeft+=timeInt); // adding one sec delay
			
			Handler handler4 = new Handler();
			handler4.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setOn(true);

					lightState.setBrightness(50);
					lightState.setHue(0);
					bridge.updateLightState(allLights.get(0), lightState,
							listener);

				}

			}, timeLeft+=timeInt); // adding one sec delay

			Handler handler5 = new Handler();
			handler5.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setOn(true);

					lightState.setBrightness(50);

					
					lightState.setHue(0);
					bridge.updateLightState(allLights.get(2), lightState,
							listener);
					
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);
					bridge.updateLightState(allLights.get(0), lightState1,
							listener);
					
					

				}

			}, timeLeft+=timeInt); // adding one sec delay

			Handler handler6 = new Handler();

			handler6.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setBrightness(50);
					lightState.setOn(true);


					lightState.setHue(0);
					bridge.updateLightState(allLights.get(1), lightState,
							listener);
					
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);

					bridge.updateLightState(allLights.get(2), lightState1,
							listener);

				}

			}, timeLeft+=timeInt); // adding one sec delay
			
			Handler handler7 = new Handler();

			handler7.postDelayed(new Runnable() {
				@Override
				public void run() {

					PHBridge bridge = phHueSDK.getSelectedBridge();				
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);

					bridge.updateLightState(allLights.get(1), lightState1,
							listener);

				}

			}, timeLeft+=timeInt); // adding one sec delay
			
			
			Handler handler8 = new Handler();
			handler8.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setOn(true);

					lightState.setBrightness(50);
					lightState.setHue(0);
					bridge.updateLightState(allLights.get(0), lightState,
							listener);

				}

			}, timeLeft+=timeInt); // adding one sec delay

			Handler handler9 = new Handler();
			handler9.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setOn(true);

					lightState.setBrightness(50);

					
					lightState.setHue(0);
					bridge.updateLightState(allLights.get(2), lightState,
							listener);
					
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);
					bridge.updateLightState(allLights.get(0), lightState1,
							listener);
					
					

				}

			}, timeLeft+=timeInt); // adding one sec delay

			Handler handler10 = new Handler();

			handler10.postDelayed(new Runnable() {
				@Override
				public void run() {
					Random rand = new Random();

					PHBridge bridge = phHueSDK.getSelectedBridge();
					PHLightState lightState = new PHLightState();
					lightState.setBrightness(50);
					lightState.setOn(true);


					lightState.setHue(0);
					bridge.updateLightState(allLights.get(1), lightState,
							listener);
					
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);

					bridge.updateLightState(allLights.get(2), lightState1,
							listener);

				}

			}, timeLeft+=timeInt); // adding one sec delay
			
			Handler handler11 = new Handler();

			handler11.postDelayed(new Runnable() {
				@Override
				public void run() {

					PHBridge bridge = phHueSDK.getSelectedBridge();				
					PHLightState lightState1 = new PHLightState();
					lightState1.setOn(false);

					bridge.updateLightState(allLights.get(1), lightState1,
							listener);
					
					timeLeft=1000;

				}

			}, timeLeft+=timeInt); // adding one sec delay


			
			

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
}
