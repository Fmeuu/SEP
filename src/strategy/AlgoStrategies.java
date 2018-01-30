package strategy;


public interface AlgoStrategies {

	public void configure();
	
	public void execute();
	
	public void setCapteur(CapteurImpl capteurImplEntry);
	
	public void addCanal(Canal canalEntry);
}
