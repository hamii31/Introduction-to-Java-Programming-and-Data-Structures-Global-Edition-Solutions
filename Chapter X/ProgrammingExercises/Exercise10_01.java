public class Exercise10_01 {
    public static void main (String args[]) {
        WeatherStation ws1 = new WeatherStation();
        System.out.println("Weather Station 1 stats: ");
        System.out.printf("Temperature (in Celsius) and pressure (in bar): %.2f, %.2f\n", ws1.getTemperature(), ws1.getPressure());
        System.out.printf("Temperature (in Fahrenheit) and pressure (in PSI): %.2f, %.2f\n", ws1.getTemperatureFahrenheit(), ws1.getPressurePSI());

        WeatherStation ws2 = new WeatherStation(35, 0.5);
        System.out.println("Weather Station 2 stats: ");
        System.out.printf("Temperature (in Celsius) and pressure (in bar): %.2f, %.2f\n", ws2.getTemperature(), ws2.getPressure());
        System.out.printf("Temperature (in Fahrenheit) and pressure (in PSI): %.2f, %.2f\n", ws2.getTemperatureFahrenheit(), ws2.getPressurePSI());

        WeatherStation ws3 = WeatherStation.buildImperialWeatherStation(68, 21);
        System.out.println("Weather Station 3 stats: ");
        System.out.printf("Temperature (in Fahrenheit) and pressure (in PSI): %.2f, %.2f\n", ws3.getTemperature(), ws3.getPressure());

    }
}

class WeatherStation {
    private double temperature = 0;
    private double pressure = 1; // bar

    public WeatherStation() {
    }

    public WeatherStation(double temperature, double pressure) {
        setTemperature(temperature);
        setPressure(pressure);
    }

    /**
     * Convert the temp and pressure to imperial
     * Construct a WeatherStation object using pass-by-value
     */
    public static WeatherStation buildImperialWeatherStation(double temperature, double pressure) {
        WeatherStation ws = new WeatherStation();
        ws.setTemperatureFahrenheit(temperature);
        ws.setPressurePSI(pressure);

        return ws;
    }

    private void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    private void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public double getPressure() {
        return this.pressure;
    }
    
    private void setTemperatureFahrenheit(double temperature) {
        setTemperature(temperature);
    }

    private void setPressurePSI(double pressure) {
        setPressure(pressure);
    }

    public double getTemperatureFahrenheit() {
        return (this.temperature * 1.8) + 32;
    }

    public double getPressurePSI() {
        return this.pressure * 14.504;
    }
}
