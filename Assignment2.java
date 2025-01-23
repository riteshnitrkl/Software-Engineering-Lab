class Clock {
    private int hour;
    private int minutes;
    private int seconds;
    private boolean isAM;

    public Clock() {
        this.hour = 12;
        this.minutes = 0;
        this.seconds = 0;
        this.isAM = true;
    }

    public Clock(int hour, boolean isAM) {
        this.hour = hour;
        this.minutes = 0;
        this.seconds = 0;
        this.isAM = isAM;
    }

    public Clock(int hour, int minutes, int seconds, boolean isAM) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
        this.isAM = isAM;
    }

    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hour++;
                if (hour == 13) {
                    hour = 1;
                    isAM = !isAM;
                }
            }
        }
    }

    public String displayTime() {
        return String.format("%02d:%02d:%02d %s", hour, minutes, seconds, isAM ? "AM" : "PM");
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Clock clock = new Clock(11, true); 
        System.out.println("Initial Time: " + clock.displayTime());

       
        for (int i = 0; i < 5; i++) {
            clock.tick();
            System.out.println("Ticking New Time: " + clock.displayTime());
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       
        clock = new Clock(12, 59, 58, false); 
        System.out.println("Time set to: " + clock.displayTime());
        clock.tick();
        System.out.println("Ticking New Time: " + clock.displayTime());
        clock.tick(); 
        System.out.println("Ticking New Time: " + clock.displayTime());
    }
}