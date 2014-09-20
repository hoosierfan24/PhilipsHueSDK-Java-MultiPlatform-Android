package homeautomation;
import homeautomation.lights.*;
import homeautomation.lights.provider.hue.*;

public class Main {

	/**
	 * @throws InterruptedException 
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args) {
		System.out.println("Start");
		
		HueLightsConfig hueConfig = new HueLightsConfig("192.168.2.23", "javaRemote", "javaRemote");
		HueLightsProvider lightsProvider = new HueLightsProvider(hueConfig);
		
		try {
			
			// Register if needed
			if(!lightsProvider.IsRegistered())
			{
				HueRegisterStates state;
				while((state = lightsProvider.Register()) == HueRegisterStates.Unregistered)
				{
					System.out.println("Please press the link button.");
					Thread.sleep(5000);
				}
				
				if(state == HueRegisterStates.Registered)
					System.out.println("We are succesfully registered!");
				else
					throw new Exception("Unable to register.");
			}
			
			Lights lights = new Lights(lightsProvider);
			lights.AllOff();
			
			for(ILight light : lights.getLights())
			{
				light.On();
				if(light instanceof ILightDim)
				{
					((ILightDim) light).Dim(0.001f);
				}
				if(light instanceof ILightColor)
				{
					RandomLightAnimation animation = new RandomLightAnimation((ILightColor) light);
					animation.start();
					Thread.sleep(2000);
				}
			}
			
			
			/*
			for(ILight light : lights.getLights())
			{
				light.On();
				//Thread.currentThread().sleep(5000);
				//light.Off();
				Thread.currentThread().sleep(5000);
				if(light instanceof IStrobe)
				{
					((IStrobe) light).StrobeOn();
					Thread.currentThread().sleep(5000);
					((IStrobe) light).StrobeOff();
					Thread.currentThread().sleep(5000);
				}
				if(light instanceof ILightColor)
				{
					for(int x = 1; x <= 30; x++)
					{
						((ILightColor) light).setColor((float)x / 30, (float)0.5);
						Thread.currentThread().sleep(1000);
					}
				}
				//light.Off();
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("Stop");
	}

}
