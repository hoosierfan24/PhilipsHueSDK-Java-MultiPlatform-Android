package homeautomation.lights;

import java.util.List;

public class Lights {

	private ILightsProvider provider;
	
	public Lights(ILightsProvider provider)
	{
		this.provider = provider;
		this.provider.Initialize();
	}

	public List<ILight> getLights() {
		return this.provider.getLights();
	}
	
	public void AllOn() {
		for(ILight light : this.getLights())
		{
			light.On();
		}
	}
	
	public void AllOff() {
		for(ILight light : this.getLights())
		{
			light.Off();
		}
	}
	
}
