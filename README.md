# DesignPatternsCmdWalkTrough
Fast and easy to learn for junior Java developers, Design Patterns (all from code via CMD).

This Java class contains (for now only the Builder desgin pattern walk trough), i will add into it more Design Patterns).
the idea is very simple, all we need to do when we need/want to use the builder pattern (but not remember the steps so much) we can easlly add this class to 
your project.

 # The class contians static methods as folowing:

* 6 methods in charge of printing in Red highligted Color the Example code of each Step in the Design pattern:

    - printExampleOne(String[] arr)
    - printExampleTow(String[] arr)
    - printExampleThree(String[] arr)
    - printExampleFour(String[] arr)
    - printExampleFive(String[] arr)
    - printExampleSix(String[] arr)


* A Generic method that 'parse' the class name from the Object parameter (the object we want to use Builder pattern on):

        <T> String[] detectClass(T object)
  
  
* A Generic method that builds each Step in the pattern (code re-use):

    <T> void stepsBuilder(List<String> steps, int stepNumber,T object)  
  

* A CMD menu (code re-use), handles the user inputs + multiple validations.
  if validation fail, i used recursion for user re-type valid values:

    int cmdMenu(String[] options, String menuTitle)
 
 
* A validation method for user input (only numbers allowed):

    boolean isNumbersOnly(String input, boolean printError , boolean isDoubleNumbersSupported) 

* The main method (Generic one) that gets from the user developer the Object/Class he needs to use the Builder pattern, and from that parameter (the class)
  the method Generic logic makes all the examples and information spesificlly to the class the developr works on.
  meaning all examples will be the real code developr needs to write (the tamplte will be shown by method).

    <T> void builderDesignPatternToolTips(T object)
  
  
  # how to use:

1. Copy the java file into your project.
2. in the P.S.V.M method for example, you can reach the Static method: 'builderDesignPatternToolTips()'
   this method gets as parameter an Object (any), so you just need to pass your class that needs to use the builder pattern.
   for example if we need to create a Pizza store.. we have in our Project the Pizza class , so we pass as parameter to the 'builderDesignPatternToolTips()' the 
   Pizza object as folowing:

-  builderDesignPatternToolTips(new Pizza)

3. from this point you can run the project, and you will see General info about the desgn pattern.
3.1 you will see additional info why we need to use this pattern.
3.2 you will see a menu with each Step of the Pattern (that you as a developer needs to do).

* after each step presented, the developer will be asked if wants to see a Code example of that step.
  if Yes, the Code example (with real exact Class names) will be shown.
  if not, the Next step will be presented, and again the user can select to see the example code.

* All the code examples are Red colored for easy understanding of the structure.

* each user selection is validated, so if devloper types in-valid he will be prompet and asked agin to re-type valid values.
