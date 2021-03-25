package Test4;

import CardDeck.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DesignPatternsWalkTrough
{
    //! One - Six 'Red' highlighted code examples:
    static void printExampleOne(String[] arr)
    {
        System.err.println(
                "Public class " + arr[0] + "{\n" +
                        "\n" +
                        "  Private " + arr[0] + "()\n" +
                        "  {}\n" +
                        "\n" +
                        "}\n"
        );
    }

    static void printExampleTow(String[] arr)
    {
        System.err.println(
                "Public class " + arr[0] + " {\n" +
                        "\n" +
                        "Private " + arr[0] + "()\n" +
                        "{}\n" +
                        "\n" +
                        "\n" +
                        "    Public static class " + arr[1] + "{\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "}\n"
        );
    }

    static void printExampleThree(String[] arr)
    {
        System.err.print(
                "\n" +
                        "Public class " + arr[0] + " {\n" +
                        "\n" +
                        "Private " + arr[0] + "()\n" +
                        "{}\n" +
                        "\n" +
                        "\n" +
                        "    Public static class " + arr[1] + "{\n" +
                        "\n" +
                        "        " + arr[0] + " obj = new " + arr[0] +"()\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "}" +
                        "\n"
        );
    }

    static void printExampleFour(String[] arr)
    {
        System.err.print(
                "\n" +
                        "\n" +
                        "Public class " + arr[0] + " {\n" +
                        "\n" +
                        "String propertyName;\n" +
                        "\n" +
                        "Private " + arr[0] + "()\n" +
                        "{}\n" +
                        "\n" +
                        "\n" +
                        "    Public static class " + arr[1] + "{\n" +
                        "\n" +
                        "        " + arr[0] + " obj = new " + arr[0] +"()\n" +
                        "\n" +
                        "            public " + arr[1] + " setSomeObjectPropertyMethod(String name) {\n" +
                        "        \n" +
                        "                 obj.propertyName = name;\n" +
                        "             \n" +
                        "                 return this;" +
                        "\n" +
                        "            }\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "}\n" +
                        "\n"
        );
    }

    static void printExampleFive(String[] arr)
    {
        System.err.print(
                "\n" +
                        "\n" +
                        "Public class " + arr[0] + " {\n" +
                        "\n" +
                        "String propertyName;\n" +
                        "\n" +
                        "Private " + arr[0] + "()\n" +
                        "{}\n" +
                        "\n" +
                        "\n" +
                        "    Public static class " + arr[1] + "{\n" +
                        "\n" +
                        "        " + arr[0] + " obj = new " + arr[0] +"()\n" +
                        "\n" +
                        "            public " + arr[1] + " setSomeObjectPropertyMethod(String name) {\n" +
                        "        \n" +
                        "                 obj.propertyName = name;\n" +
                        "             \n" +
                        "                 return this; \n" +
                        "\n" +
                        "            }\n" +
                        "\n" +
                        "\n" +
                        "           public " + arr[0] + " build() {\n" +
                        "           \n" +
                        "                 return obj; \n" +
                        "\n" +
                        "           } \n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "}\n" +
                        "\n"
        );
    }

    static void printExampleSix(String[] arr)
    {
        System.err.print(
                arr[0] + " obj = new " + arr[1] + "().setSomeObjectPropertyMethod(name:'Dave').build()\n\n"
        );
    }

    //________________________________________________


    //! Method builds each step in the Builder pattern:
    static <T> void stepsBuilder(List<String> steps, int stepNumber,T object)
    {
        //! show each pattern step info:
        System.out.println(steps.get(stepNumber - 1) + "\n");

        int userSelection = cmdMenu(new String[]{"Show code example.","Show next step in pattern."},"Do you want to see code example ? (select by index number).");

        //! if user selected to see the code example:
        if (userSelection == 1)
        {
            //! according to step of pattern, show the relevant code:
            switch (stepNumber)
            {
                case 1 -> printExampleOne(detectClass(object));
                case 2 -> printExampleTow(detectClass(object));
                case 3 -> printExampleThree(detectClass(object));
                case 4 -> printExampleFour(detectClass(object));
                case 5 -> printExampleFive(detectClass(object));
            }
        }
    }

    //! command line menu:
    static int cmdMenu(String[] options, String menuTitle)
    {
        Scanner scanner = new Scanner(System.in);

        //! validation for avoiding "" at title ->
        if (menuTitle.length() != 0)
        {
            System.out.println(menuTitle);
        }

        //! auto creation of menu print ->
        for (int i = 0; i < options.length; i++)
        {
            System.out.println((i + 1) + ") " + options[i]);
        }


        System.out.println("\nSelect choice: ");

        //! Get the user selection from Scanner ->
        String input = scanner.nextLine();

        //! validation for avoiding user input press "enter" ->
        if (input.length() == 0)
        {
            System.err.println("Please select an option...\n");
            return cmdMenu(options, menuTitle);
        }

        //! validation for userInput must be a number
        if (!isNumbersOnly(input, false,false))
        {
            System.err.println("Must type a number...\n");
            return cmdMenu(options, menuTitle);
        }

        //! casting the String to Int ->
        int choice = Integer.parseInt(input);

        //! validation for choosing between option limits only ->
        if (choice > options.length || choice <= 0)
        {
            System.err.println("Please choose from the above options only...");
            return cmdMenu(options, menuTitle);
        }

        return (choice);
    }


    //! Builder design pattern walk trough:
    static <T> void builderDesignPatternToolTips(T object)
    {
        //! using helper method for detecting the User class (where builder is needed) & 'parsing' only the Name of the class:
        String userOuterClass =  detectClass(object)[0];
        String userBuilderClass =  detectClass(object)[1];

        List<String> patternStepsInfo = new ArrayList<>();
        patternStepsInfo.add("1) At the '" + userOuterClass + "' class that we want to build, we need to set the 'Constructor' to Private.");
        patternStepsInfo.add("2) Now we need to create inside the '" + userOuterClass + "' class a nested Static class named '" + userBuilderClass + ".\n" + "The inner class must be Static !");
        patternStepsInfo.add("3) Now we need to create as property of the '" + userOuterClass + "Builder'" + " class, the '" + userOuterClass + "' Object instance.\n");
        patternStepsInfo.add("4) Now that the '" + userBuilderClass + "' class holds the '" + userOuterClass + "' instance, we need to create methods for updating the '" + userBuilderClass + "' properties.");
        patternStepsInfo.add("5) The last part in the pattern is to create one last method, the 'Build' method.\n" +
                "This method needs only to return the '" + userOuterClass + "' object (after we set all properties of it manually via the set methods at '4' above).");


        System.out.println("The Builder pattern allows us to write readable, understandable code to set up complex objects.\n\n" +
                "*** When to use the builder pattern ***\n" +
                "1) When we have to many arguments in constructor.\n" +
                "2) when we need to create the object with only few properties init.\n" +
                "3) when we have too many property combinations for creating the object.\n" +
                "4) when you find yourself in a situation where you keep on adding new parameters to a constructor, resulting in code that becomes error-prone and hard to read");


        System.out.println("\n*** Key steps for the pattern ***\n");

        //! 'Fori' loop uses the stepBuilder() method to show all steps + ability by user to ask for code example:
        for (int i = 1; i < 6; i++)
        {
            stepsBuilder(patternStepsInfo,i,object);
        }


        System.out.println("6) For using the 'Builder DesignPattern' We need to instantiate(build) the '" + userOuterClass + "' Object from the '" + userBuilderClass + "' object !\n" +
                "Meaning we create the '" + userBuilderClass + "' object and 'chin' to it (from the methods we set in it),\n" +
                "only when we finished chaining the methods we need, we must chain the last method for building/returning the '" + userOuterClass + "' Object (the 'build()').\n");

        int userInput = cmdMenu(new String[]{"Show code example","Exit"},"Do you want to see Code example ?");

        if (userInput == 1)
        {
            printExampleSix(detectClass(object));

            System.out.println("* If we have more 'set methods' in the '" + userBuilderClass + "' inner class,\n" +
                    "We could chain more methods when creating the '" + userBuilderClass + "' including chaining the same method few times.\n");

        }

        else
        {
            System.out.println("Hope you master now the 'Builder pattern', Good bye.");
        }
    }


    //! A Generic method that 'parse' the class name from the Object parameter (the object we want to use Builder pattern on):
    static <T> String[] detectClass(T object)
    {
        String str = object.getClass() + "";
        String[] arr =  str.split("\\.");
        String userOuterClass = arr[1];
        String userBuilderClass = userOuterClass + "Builder";
        return new String[]{userOuterClass,userBuilderClass};
    }


    //! method checks if the 'String' parameter is a number.
    public static boolean isNumbersOnly(String input, boolean printError , boolean isDoubleNumbersSupported)
    {
        Pattern pattern;

        if (isDoubleNumbersSupported)
        {
            pattern = Pattern.compile("^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"); //! for float numbers
        }

        else
        {
            pattern = Pattern.compile("^[0-9]+$");  //! for natural numbers
        }


        Matcher matcher = pattern.matcher(input);
        boolean isFound = matcher.find();

        if (!isFound)
        {
            if (printError)
            {
                System.err.println("Invalid input !! only Numbers allowed.");
            }

            return false;
        }

        return true;
    }
}
