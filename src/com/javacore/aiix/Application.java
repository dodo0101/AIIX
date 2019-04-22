package com.javacore.aiix;


import state.ApplicationState;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *Main class
 * */
public class Application {

    public static final String OPERATION_GROUP = "(SELECT|DELETE)";
    public static final String FIELD_GROUP = "([*a-zA-Z, ]+)";
    public static final String SPACE = "([\\s])";
    public static final String FROM_GROUP = "(FROM)";
    public static final String TABLE_GROUP = "([a-zA-Z]+)$";


    //регулярное выражения для поиска доменных имен с производльным окончанием
    public static final String ALLOWED_DOMAIN_NAMES = "^((a-zA-Z0-9)+\\.)+[a-zA-Z]+$";
    //регулярное выражения для поиска доменных имен с окончанием com и de
    public static final String ALLOWED_DOMAIN_NAME = "^((a-zA-Z0-9)+\\.)+[com|de|ru]+$";


    /**
     * Fields with name, author and version
     * */
    static private final String APP_NAME = "AIIX";
    static public final String AUTHOR = "Fedor Glushchenko";
    static public final String VERSION = "0.0.2";

    static ApplicationState currentState; //currentState

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

        String query = "SELECT id, fileName, lastName FROM Criminals";

        Pattern p = Pattern.compile(OPERATION_GROUP + SPACE + FIELD_GROUP + SPACE + FROM_GROUP + SPACE + TABLE_GROUP);
        Matcher matcher = p.matcher(query); //

        if (matcher.find()) {
            System.out.println("Number of groups: " + matcher.groupCount());
            for (int i = 0, len = matcher.groupCount(); i <= len; i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }


        /*
        List<String> list = new ArrayList<String>();
        list.add("developer.apple.com");
        list.add("google/com");
        list.add("wrong.");
        list.add(".another");
        list.add("this is a wrong domain name");
        list.add("facebook.com");
        list.add("nasa.gov");
        list.add("handelsblatt.de");
        list.add("login.");
        list.add("mail.ru");
        iteratorCleanup(list, ALLOWED_DOMAIN_NAMES);
        printList(list);

         */





        //System.out.println("Hello, my name is " + APP_NAME);
        //System.out.println("my author`s name is " + AUTHOR);


        /*
        ACommand acommand = new ACommand("Anonymous") { //inner anonymous class
            @Override
            public void execute() {
                System.out.println("Hello!");
                System.out.println(this.getClass());
            }
        };
        acommand.execute();

         */



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
        System.out.println();
        System.out.println();

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

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    System.out.print("-");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread11 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("done");

            }
        };

        System.out.print("\nLoading");
        thread11.start();

         */
        /*
        ConsoleCanvas concan = new ConsoleCanvas(20,20);
        concan.drawSquare(4,4,10, 'x');
        concan.draw();

         */
/*
        List<String> columns = new ArrayList<String>();
        columns.add("id");
        columns.add("firstName");
        columns.add("lastName");
        Table criminalTable = new Table("Criminals", columns);

        List<String> values = new ArrayList<String>();
        List<String> values2 = new ArrayList<String>();

        values.add("1");
        values.add("Vladimir");
        values.add("Trump");

        values2.add("2");
        values2.add("Donald");
        values2.add("Timoshenko");

        criminalTable.insert(new Record(values));
        criminalTable.insert(new Record(values2));

        List<String> result = criminalTable.selectField("lastName");
        for (String s : result) {
            System.out.println(s);
        }

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
            //System.out.println(rec.getInt("id"));
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

}
