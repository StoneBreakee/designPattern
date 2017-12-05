import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer,DisplayElement{
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Observable observable;

    public ForecastDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display(){
        System.out.print("Forecast: ");
        if(currentPressure > lastPressure){
            System.out.println("Improving weather on the way!");
        }else if(currentPressure == lastPressure){
            System.out.println("More of the same");
        }else if(currentPressure < lastPressure){
            System.out.println("Watch out for cooler,rainy weather");
        }

    }

    //public void update(float temperature,float humidity,float pressure){
    //    lastPressure = currentPressure;
    //    currentPressure = pressure;
    //    display();
    //}
    public void update(Observable obs,Object arg){
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }
}
