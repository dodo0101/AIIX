package com.javacore.aiix;


import com.javacore.aiix.db.misc.DBConstants;
import com.javacore.aiix.db.misc.Utils;
import com.javacore.aiix.db.misc.XMLDocumentHandler;
import com.javacore.aiix.profile.ProfileController;
import com.javacore.aiix.state.ApplicationState;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Iterator;
import java.util.List;

/**
 *Main class
 * */
public class Application {

    /**
     * Fields with name, author and version
     * */
    static private final String APP_NAME = "AIIX";
    static public final String AUTHOR = "Fedor Glushchenko";
    static public final String VERSION = "0.0.5";

    /**
     * Field for state machine
     * */
    static ApplicationState currentState; //currentState

    /**
     * Method for state machine - turning into new state
     * @param newState New state of program
     * @param commandName Name of command
     * */
    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        newState.enter(commandName);
    }

    /**
     * Start of the program
     * @param args command line values
     * */
    public static void main(String[] args) {

        //String commandName = "version";

        /*
        if (CommandRegistry.INSTANCE.hasCommands(commandName)) {
            ACommand command = CommandRegistry.INSTANCE.getCommand(commandName);
            command.execute();

            commandName = "creator";
            command = CommandRegistry.INSTANCE.getCommand(commandName);
            command.execute();

            commandName = "time";
            command = CommandRegistry.INSTANCE.getCommand(commandName);
            command.execute();

            commandName = "weather";
            command = CommandRegistry.INSTANCE.getCommand(commandName);
            command.execute();
        }

         */


        /*
        changeState(new StateIdle(), "Idle");
        //reading input
        commandName = "test command";
        //receiving 10 new commands
        for (int i = 0; i < 10; i++) {
            currentState.onCommand(commandName + i);

        }

         */

        /*
        ProfileController controller = new ProfileController();
        controller.showProfile(5);
        */

        /*
        ConsoleCanvas concan = new ConsoleCanvas(20,20);
        concan.drawSquare(4,4,10, 'x');
        concan.draw();

         */




/*
        DataBase db = new DataBase();

        Thread thread = new Thread() {
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                    db.select();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                db.update();
            }
        };

        thread.start();
        (new Thread(runnable)).start();

 */
        /*
        List<String[]> records = DataBase.readDataFile(""); // READ FILE RECIEVED RECORD _ GET MODELS
        Table table = new Table("Criminals", Arrays.asList(new String[]{"id", "name", "deceased"}));

        for (String[] s : records) {
            Record rec  = new Record(table);
            rec.setValues(s);
            table.insert(rec);
        }

         */

/*
        Record rec = new Record(table); //modified
        rec.setValues(new String[]{"100", "Antony Soprano", "false"});
        try {
            System.out.println(rec.getBoolean("deceased"));
        } catch (Record.FieldNotFoundExceptione e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

 */
        //System.out.println("ALL is ok, all exceptions have been caught");

        //DataBase.readDataFile("C:/Users/fglus/IdeaProjects/AIIX/src\com\javacore\aiix\example.txt");


        //WTF
        /*
        Integer j = 71;
        Integer k = ++j;
        int i = 2;
        k = i + j + k;
        System.out.println(k);
        */
    }

    public static void iteratorCleanup(List<String> list, String filter) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (!s.matches(filter)) {
                it.remove();
            }
        }
    }

    public static void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void testXMLReader() {
        try {
            Utils.readXMLDocument(DBConstants.STRUCTURE_DIR + "/test.xml",
                    new XMLDocumentHandler() {
                        @Override
                        public void handleDocument(Document document) {
                            Element root = document.getDocumentElement();
                            System.out.println(root.getAttribute("name"));
                            NodeList columns = root.getElementsByTagName("column");
                            System.out.println(columns.getLength());
                            for (int i = 0, len = columns.getLength(); i < len; i++) {
                                Element column = (Element)columns.item(i);
                                System.out.println(column.getAttribute("systemName"));
                                System.out.println(column.getAttribute("displayName"));
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
