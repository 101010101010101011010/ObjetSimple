public class Main {
    static Port port1 = new Port(PortType.DVI, PortDirectionality.In);
    static Port port2 = new Port(PortType.DVI, PortDirectionality.Out);
    static Port port3 = new Port(PortType.DVI, PortDirectionality.Out);

    public static void main(String[] args) {
        if (port1.connect(port2)) {
            System.out.println("A pu connecter!");
        } else {
            System.err.println("N'a pas pu connecter....");
        }
        printAll();

        if (port3.connect(port2)) {
            System.out.println("A pu connecter!");
        } else {
            System.err.println("N'a pas pu connecter....");
        }
        printAll();

        if (port3.connect(port1)) {
            System.out.println("A pu connecter!");
        } else {
            System.err.println("N'a pas pu connecter....");
        }
        printAll();
    }

    public static void printAll() {
        System.out.println("Port1:\n" + port1.toString());
        System.out.println("Port2:\n" + port2.toString());
        System.out.println("Port3:\n" + port3.toString());
    }
}