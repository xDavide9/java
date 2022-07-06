package com.xdavide9.javadeployment;

public class Main {

    public static void main(String[] args) {
	    //these notes describe how to deploy a java application
        //java applets and web stuff are skipped because nowadays html5 css3 and JavaScript are much better
        //for web applications
        //java does not belong in the browser
        /*
        Java Applet and WebStart functionality, including the Applet API, The Java plug-in, the Java Applet Viewer,
        JNLP and Java Web Start including the javaws tool are all deprecated in JDK 9
         */
        //conclusion: don't use java for web stuff use html5 css3 and JavaScript

        //only self-contained (or stand-alone) applications (which are really powerful
        //because they contain a version of the jre to be used to run the application itself)
        //and jars remain then among serious forms of deployment

        //NOTE (AN IMPORTANT ONE SHOULD COME TO THIS OFTEN)
        //XML, JSON, CVS AND YAML and more are file extensions which should be known in order to understand which file is better to use
        //MAVEN and GRADLE are necessary tools for a developer because they are used to manage your project build, dependency and documentation
        //there are also FRAMEWORKS (e.g Spring)
        //SQL is another name I can think of (something to work with databases), PHP but maybe I am moving too far away and too fast...
        //but there are many more names that will come with time and new stuff to learn

        //my take on computers is that there are so many technologies and stuff that can help you achieve what you are looking to achieve
        //so learn a lot (remember that the learning path is never-ending throughout life) and while learning create some projects
        //to put in practice what you learn
        //this is the way to go pro:
        //study, knowledge and put in practice
        //just search everything on google it is the best way to learn everything in the 21st century

        new Jars();
//        ctrl / (comment out line just like this)
//        alt ins (insert stuff like getters, setters, constructors in a class, extremely handy)
//        ctr O (select methods to override/implement, extremely handy)
//        ctr alt O (clean out imports)
//        ctr hover left click (on a class like String down below, it turns blue and goes to the doc)
//        read docs from the ide it is so good!!!!!
        String string = "hello";
//        ctrl j (insert live template)
//        ctrl alt t (surround with template)
//        ctrl alt i (auto-indent lines)



    }
}
