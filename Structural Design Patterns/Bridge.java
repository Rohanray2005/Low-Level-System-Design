// Bridge is a structural design pattern that lets you split a large class or 
// a set of closely related classes into two separate hierarchies—abstraction and
// implementation—which can be developed independently of each other.

// Abstraction (also called interface) is a high-level control layer for some entity.
// This layer isn’t supposed to do any real work on its own. It should delegate the work to
// the implementation layer (also called platform).

// Remotes act as abstractions, and devices are their implementations.
// Thanks to the common interfaces, the same remotes can work with different devices and vice versa.

public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
}

public class Tv implements Device {

}

public class Radio implements Device {
    
}

public interface Remote {
    void power();
    void volumeUp();
    void volumeDown();
    void channelDown();
    void channelUp();
}

public BasicRemote implements Remote {
    private Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    void power(){
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }
}

public AdvanceRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        device.setVolume(0);
    }
}