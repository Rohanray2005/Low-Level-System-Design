// The Factory Method design pattern is a creational design pattern that helps in creating objects. 
// The pattern's main idea is to provide an interface (or abstract method) in a superclass 
// for creating an object, while letting subclasses decide which specific type of object to create.
/**
 * Common interface for all buttons.
 */
public interface Button {
    void render();
    void onClick();
}

public class HtmlButton implement Button {
    void render(){
        System.out.println("Html button rendered !");
    }
    void onClick(){
        System.out.println("Html button clicked !")
    }
} 

public class WindowButton implement Button {
    void render(){
        System.out.println("Window button rendered !");
    }
    void onClick(){
        System.out.println("Window button clicked !")
    }
}

// Factory
public abstract class Dialog {
    public void renderDialog(){
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}

public class HtmlDialog extend Dialog {
    @Override
    public Button createButton(){
        return new HtmlButton();
    }
}

public class WindowDialog extend Dialog {
    @Override
    public Button createButton(){
        return new WindowButton();
    }
}

public class Demo {
    private static Dialog Dialog;

    public static void main(String[] args){
        configure();
        runBusinessLogic();
    }

    static void configure(){
        if (System.getProperty("os.name").equals("Windows")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderDialog();
    }
}