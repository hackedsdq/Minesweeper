import java.awt.*;

public class Main {
    public static void main(String[] args) {
    //Tp1exo1 test = new Tp1exo1();
    //Tp1exo2 test = new Tp1exo2();

        EventQueue.invokeLater(() -> {

            var ex = new Tp1exo2();
            ex.setVisible(true);
        });
    }
}
