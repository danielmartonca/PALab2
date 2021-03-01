# Laboratory 2

At the last laboratory i finished the tasks Bonus and Optional.

This repository is for the tasks given at laboratory 2. I managed to finish (so far. I will try to finish other tasks before the next laboratory): Compulsory

## Essential tools

You need to have Java RE or JDK >= 8 installed on your computer.

## How to run it?

1. Open project with IntelliJ IDEA

Clone this repository and open it with IntelliJ IDEA. Build this project
(shortcut Ctrl+F9) then go to Run->Run...(shortcut Alt+Shift+F10) and select
the file you want to run.

2. Compile and run the programs using CMD

Go to the folder where the file is located. Open a new terminal here.

If you want to compile the file the file Main.java you must type the command.

```bash
javac -d . Main.java
```

After you compiled it, if you want to start the program you can type the
following command

```bash
java packageName.Main
```

where to packageName is the name of the package which includes the file Main.java.


## Compulsory
The task consists of:<br />

- [x] Create an object-oriented model of the problem. You should have (at least) the following classes: Source, Destination, Problem.
  The sources and the destinations have names. The sources will also have the property type. The available types will be implemented as an enum . For example:<br />
  <br /> public enum SourceType {<br />
  WAREHOUSE, FACTORY;
  <br />}<br /><br />
  Assume S1 is a factory and S2, S3 are warehouses.
- [x] Each class should have appropriate constructors, getters and setters.
  Use the IDE features for code generation, such as generating getters and setters. <br />
- [x] The toString method form the Object class must be properly overridden for all the classes. <br />
- [x] Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
- [x]  Create and print on the screen the instance of the problem described in the example.<br />


Here is the output i recieved:<br />
```dif
        Destinatie1   Destinatie2   Destinatie3       Supply
Sursa1     2              3              1              10
Sursa2     5              4              8              35
Sursa3     5              6              8              25
Demand     20             25             25             
```
## Optional
The task consists of:<br />

- [x] Create an object-oriented model of the problem. You should have (at least) the following classes: Source, Destination, Problem.
  The sources and the destinations have names. The sources will also have the property type. The available types will be implemented as an enum . For example:<br />
  <br /> public enum SourceType {<br />
  WAREHOUSE, FACTORY;
  <br />}<br /><br />
  Assume S1 is a factory and S2, S3 are warehouses.
- [x] Each class should have appropriate constructors, getters and setters.
  Use the IDE features for code generation, such as generating getters and setters. <br />
- [x] The toString method form the Object class must be properly overridden for all the classes. <br />
- [x] Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
- [x]  Create and print on the screen the instance of the problem described in the example.<br />


Here is the output i recieved:<br />
```dif
     ====
```
## Bonus
Not yet worked on.