package homeautomation.lights;

import java.util.List;

public interface ILightsProvider {
	
	List<ILight> getLights();
	void Initialize();
	
}
