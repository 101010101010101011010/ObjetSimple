public class Main {
    static Port port1 = new Port(PortType.DVI, PortDirectionality.In);
    static Port port2 = new Port(PortType.DVI, PortDirectionality.Out);
    static Port port3 = new Port(PortType.DVI, PortDirectionality.Out);

    public static void main(String[] args) {
        if (port1.Connect(port2)) {
            System.out.println("A pu connecter!");
        } else {
            System.err.println("N'a pas pu connecter....");
        }
        PrintAll();

        if (port3.Connect(port2)) {
            System.out.println("A pu connecter!");
        } else {
            System.err.println("N'a pas pu connecter....");
        }
        PrintAll();

        if (port3.Connect(port1)) {
            System.out.println("A pu connecter!");
        } else {
            System.err.println("N'a pas pu connecter....");
        }
        PrintAll();
    }

    public static void PrintAll() {
        System.out.println("Port1:\n" + port1.ToString());
        System.out.println("Port2:\n" + port2.ToString());
        System.out.println("Port3:\n" + port3.ToString());
    }
}