package com.xdavide9.essentialjavaclasses;

public class ThePlatformEnvironment {

    ThePlatformEnvironment() {
        //An application runs on the platform environment, defined by the underlying os,
        //the jvm, the class libraries and other configurations

        //CONFIGURATION UTILITIES
        //configuration that help an application access its startup content

        //1) properties:
        //properties are configuration stored as key/value pairs where both the key and the value
        //are String objects
        //to manage properties, create instances of java.util.Properties
        //there is a Properties object in System which holds the current working environment
        //accessible via System.getProperties() which returns a read-only map
        //properties can be imported or exported thanks to the use of streams
        //and therefore an application can maintain its properties thanks to that
        //in system it's possible to change the current properties by passing a properties object to System.setProperties

        //2) command line arguments:
        //self explanatory

        //3) environment variables:
        //like properties, these are key/value pairs where both the key and the value are strings
        //environment variables can be accessed through System.getenv() which reads a read-only map

        //there are some other various configuration utilities

        //SYSTEM UTILITIES
        //this covers the System class basically:
        //1) I/O objects:
        //    standard streams and a console object good for entering passwords
        //2) env variables and a properties object:
        //    which is used to store the properties of the current working environment
        //    the properties can be accessed thanks to System.getProperties()
        //    there is also System.setProperties which allows to set a custom properties object
        //    when creating this custom object it's also possible to pass some existing properties
        //    like:
        //    Properties p = new Properties(System.getProperties());
        //    p.load([FileInputStream object]);
        //    System.setProperties(p);
        //    //this would add some other properties defined by the stream to the default ones for example
        //3) Security manager:
        //    usually not present in applications unless it is defined
        //    can block some actions because it will throw a SecurityException if that action is not allowed
        //    refer to: https://docs.oracle.com/javase/8/docs/technotes/guides/security/index.html
        //    for more on security if it is needed in the future of course

        //MISCELLANEOUS METHODS IN SYSTEM
        //there are some other methods in System
        //like:
        //arrayCopy()
        //currentTimeMillis()
        //nanoTime()
        //exit(int status) where status = 0 is the normal value and any other number is an error code

        //PATH AND CLASSPATH:

        //PATH
        //after installing the jdk, its directory will look like:
        //          jdk-version
        //      bin     lib      ...
        //where bin contains both the compiler and the launcher

        //in order to conveniently use the executables (javac.exe, java.exe, javadoc.exe...) from any directory
        //the PATH variable must be set (if the PATH is not set the full path must be specified each time)
        //for example C:\Java\jdk1.7.0\bin\javac MyClass.java
        //-----------
        //so the PATH variable should hold the value of the directory where the executables are located
        //e.g. C:\Java\jdk1.7.0\bin
        //then since in bin there is javac.exe it's just possible to run
        //javac MyClass.java
        //from any directory

        //CLASSPATH:
        //the classpath is the path that the JRE (java runtime system) searches
        //for classes and other resource files
        //the default value of the CLASSPATH is "."
        //meaning that only the current directory is searched
        //(. is the current directory and .. is the previous directory)
        //in order to override to change the CLASSPATH set the CLASSPATH variable in windows
        //or specify with the option -cp when running classes with java
        //like java -cp C:/MyClasses Main.java
        //where Main.java is in MyClasses

        //to set the classpath variable:
        //set CLASSPATH=[path]

        //--------------

        //to check the current CLASSPATH variable:
        //echo %CLASSPATH%

        //where %WORD% is the way windows refers to env variables

        //--------------

        //to reset it
        //set CLASSPATH=

        //https://docs.oracle.com/javase/8/docs/technotes/tools/windows/classpath.html

        //bin directory is usually where the executables of a program are located

    }
}
