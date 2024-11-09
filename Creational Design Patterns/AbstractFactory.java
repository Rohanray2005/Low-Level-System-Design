// Abstract Factory is a creational design pattern,
// which solves the problem of creating entire product families without specifying 
// their concrete classes.
public interface Button {
    void paint();
}

public class WindowButton implements Button {
    @Override
    public void paint(){
        System.out.println("Window Button");
    }
}

public class MacButton implements Button {
    @Override
    public void paint(){
        System.out.println("Mac Button");
    }
}

public interface CheckBox {
    void paint();
}

public class WindowCheckBox implements CheckBox {
    @Override
    public void paint(){
        System.out.println("Window CheckBox");
    }
}

public class MacCheckBox implements CheckBox {
    @Override
    public void paint(){
        System.out.println("Mac CheckBox");
    }
}

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

public class WindowFactory implements GUIFactory {
    @Override
    public Button createButton(){
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckbox(){
        return new WindowCheckBox();
    }
}

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton(){
        return new MacButton();
    }

    @Override
    public CheckBox createCheckbox(){
        return new MacCheckBox();
    }
}

public class Application {

    private Button button;
    private CheckBox CheckBox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        CheckBox = factory.createCheckbox();
    } 

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}