package homeautomation.lights.provider.hue;

import homeautomation.lights.*;

public class HueLight implements ILight, IStrobe, ILightColor, ILightDim {
	
	private String key;
	private HueLightsProvider provider;
	
	public HueLight(String key, HueLightsProvider provider) {
		this.key = key;
		this.provider = provider;
	}

	@Override
	public boolean On() {
		HueLightJson request = new HueLightJson();
		request.on = true;
		this.provider.AddLightChange(this.key, request);
		
		return true;
	}
	
	@Override
	public void Off() {
		HueLightJson request = new HueLightJson();
		request.on = false;
		this.provider.AddLightChange(this.key, request);
	}
	
	@Override
	public void StrobeOn() {
		HueLightJson request = new HueLightJson();
		request.alert = HueLightAlerts.lselect;
		this.provider.AddLightChange(this.key, request);
	}

	@Override
	public void StrobeOff() {
		HueLightJson request = new HueLightJson();
		request.alert = HueLightAlerts.none;
		this.provider.AddLightChange(this.key, request);
	}
	
	@Override
	public void setColor(float h, float s) {
		HueLightJson request = new HueLightJson();
		
		request.hue = (int) (h * 360 * 182);
		request.sat = (int) (s * 254);
		request.transitiontime = 0;
		
		this.provider.AddLightChange(this.key, request);
	}

	@Override
	public void Dim(float value) {
		HueLightJson request = new HueLightJson();
		request.bri = (int) (value * 254);
		
		this.provider.AddLightChange(this.key, request);
	}	
}
