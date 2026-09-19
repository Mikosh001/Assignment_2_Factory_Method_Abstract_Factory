package app;

import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: exactly two arguments are required: delivery mode and UI platform.");
            System.out.println("Usage: java -cp out app.Main <ROAD|SEA> <WINDOWS|MACOS>");
            return;
        }

        Logistics logistics;
        GUIFactory guiFactory;
        try {
            logistics = selectLogistics(args[0]);
            guiFactory = selectGUIFactory(args[1]);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        System.out.println("Delivery mode: " + args[0]);
        System.out.println("UI platform: " + args[1]);
        DeliveryApplication application = new DeliveryApplication(guiFactory, logistics);
        application.run("laboratory equipment", "Aktau warehouse");
    }

    private static Logistics selectLogistics(String deliveryMode) {
        return switch (deliveryMode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> throw new IllegalArgumentException(
                    "Error: unsupported delivery mode '" + deliveryMode + "'. Use ROAD or SEA.");
        };
    }

    private static GUIFactory selectGUIFactory(String platform) {
        return switch (platform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> throw new IllegalArgumentException(
                    "Error: unsupported UI platform '" + platform + "'. Use WINDOWS or MACOS.");
        };
    }
}
