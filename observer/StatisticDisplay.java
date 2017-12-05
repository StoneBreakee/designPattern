import java.util.Observable;
import java.util.Observer;

public class StatisticDisplay implements Observer,DisplayElement{
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private Observable observable;

    public StatisticDisplay(Observable observable){
        this.observable= observable;
        observable.addObserver(this);
    }

    public void display(){
        System.out.println("Avg/Max/Min temperature = " + (tempSum/numReadings) + "/"+maxTemp+"/"+minTemp);
    }

    //public void update(float temperature,float humidity,float pressure){
    //    tempSum += temperature;
    //    numReadings++;

    //    if(temperature > maxTemp){
    //        maxTemp = temperature;
    //    }

    //    if(temperature < minTemp){
    //        minTemp = temperature;
    //    }

    //    display();
    //}
    public void update(Observable obs,Object arg){
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            float temperature = weatherData.getTemperature();
            tempSum += temperature;
            numReadings++;

            if(temperature > maxTemp){
                maxTemp = temperature;
            }

            if(temperature < minTemp){
                minTemp = temperature;
            }

            display();
        }
    }
}
