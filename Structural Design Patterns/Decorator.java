// Decorator is a structural design pattern that lets you attach new behaviors to objects 
// by placing these objects inside special wrapper objects that contain the behaviors.

public interface INotifier {

    void send(String message);

    String getUsername();

}

public class Notifier implements INotifier {

    private final String username;
    private final DatabaseService databaseService;

    public Notifier(String username) {
        this.username = username;
        databaseService = new DatabaseService();
    }

    @Override
    public void send(String msg) {
        String mail = databaseService.getMailFromUsername(username);
        System.out.println("Sending " + msg + " by Mail to " + mail);
    }

    @Override
    public String getUsername() {
        return username;
    }

}

public abstract class BaseNotifierDecorator implements INotifier {

    private final INotifier wrapped;
    protected final DatabaseService databaseService;

    BaseNotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
        databaseService = new DatabaseService();
    }

    @Override
    public void send(String msg) {
        wrapped.send(msg);
    }

    @Override
    public String getUsername() {
        return wrapped.getUsername();
    }

}

public class FacebookDecorator extends BaseNotifierDecorator {

    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    public void send(String msg) {
        super.send(msg);
        String fbName = databaseService.getFBNameFromUsername(getUsername());
        System.out.println("Sending " + msg + " on Facebook to " + fbName);
    }

}

public class WhatsAppDecorator extends BaseNotifierDecorator {

    public WhatsAppDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        String phoneNbr = databaseService.getPhoneNbrFromUsername(getUsername());
        System.out.println("Sending " + msg + " by WhatsApp on " + phoneNbr);
    }

}

// client code
 public static void main(String[] args) {

    INotifier notifyAll = new FacebookDecorator(new WhatsAppDecorator(new Notifier("Demo")));

    INotifier notifyFbMail = new FacebookDecorator(new Notifier("Demo"));

}