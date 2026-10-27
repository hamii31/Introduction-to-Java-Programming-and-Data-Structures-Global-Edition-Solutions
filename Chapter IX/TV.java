public class TV {

    public static void main(String[] args) {
        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChannel(10);
        tv1.setVolume(3);

        TV tv2 = new TV();
        tv2.turnOn();
        tv2.channelUp();
        tv2.channelUp();
        tv2.volumeUp();

        System.out.println("tv1's channel is " + tv1.channel +
        " and volume level is " + tv1.volumeLevel);
        System.out.println("tv2's channel is " + tv2.channel +
        " and volume level is " + tv2.volumeLevel);
    }


    int channel = 1;
    int volumeLevel = 1;
    boolean on = false;;

    TV() {
    }

    void turnOn() {
        this.on = true;
    }
    void turnOff() {
        this.on = false;
    }
    void setChannel(int newChannel) {
        this.channel = newChannel;
    }
    void setVolume(int newVolumeLevel) {
        this.volumeLevel = newVolumeLevel;
    }
    void channelUp() {
        this.channel++;
    }
    void channelDown() {
        this.channel--;
    }
    void volumeUp() {
        this.volumeLevel++;
    }
    void volumeDown() {
        this.volumeLevel--;
    }
}
