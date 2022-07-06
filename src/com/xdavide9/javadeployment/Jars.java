package com.xdavide9.javadeployment;

public class Jars {

    Jars() {
        System.out.println("if you see this, the jar works!");
        //jar are compressed archives (like zip) which are a very good way to deploy java code
        //together with relatives assets (images, audio files, data files, etc.)
        //(jars do not refer only to the code they are entire archives!)

        //some basic operations may be performed through ides or other tools
        //but as git teaches, command line is generally to be preferred because there are no limitations
        //basic operations with jars are:
        //creating a jar
        //viewing the content of a jar
        //extracting the content of a jar
        //updating a jar
        //running a jar
        //for information about commands https://docs.oracle.com/javase/tutorial/deployment/jar/basicsindex.html
        //is concise and clear (ignore applets and web stuff of course cause they are deprecated)

        //THE MANIFEST
        //the .mf file stores meta data about the files in the jar and gives a lot of flexibility
        //when you create a jar, a plain manifest is always created too and it just contains the line
        //Manifest-version: 1.0
        //additional metadata (data about other data) may be provided depending on the purpose you want to achieve

        //MAINCLASS PATH
        //a necessary addition is the Main-Class path within the jar
        //because the jar has to know where to find the main method
        //this can directly done via the command line or by adding the line
        //Main-class: MainClassPath
        //to the manifest
        //remember that the last line in a manifest should always have a line return
        //and that while specifying the MainClassPath the . for the packages notation must be used
        //in this case the line would be:
        //Main-class: com.xdavide9.Main

        //CLASSPATH
        //if you want to reference classes of other jars in your code add the line:
        //Class-Path: ClassPath.jar
        //to the manifest file

        //EXTRA METADATA ABOUT THE PACKAGE
        //some extra information you could put in the manifest example:
        /*
        Name: java/util/
        Specification-Title: Java Utility Classes
        Specification-Version: 1.2
        Specification-Vendor: Example Tech, Inc.
        Implementation-Title: java.util
        Implementation-Version: build57
        Implementation-Vendor: Example Tech, Inc.
         */

        //SEALING PACKAGES
        //another feature you can add to a manifest is sealing packages
        //a sealed package means that all of its files must be archived in the same jar file
        //this might be done to ensure consistency among the classes of your code

        //ENHANCING SECURITY
        //https://docs.oracle.com/javase/tutorial/deployment/jar/secman.html

        //DIGITAL SIGNING
        //it's just like signing a real document but in a digital way
        //the signer can put his sign via a private key on the jar
        //to verify that sign the corresponding public key is needed together with its
        //certificate (to make sure you are actually the one who can sign)
        /*
        The signer signs the JAR file using a private key.
        The corresponding public key is placed in the JAR file, together with its certificate, so that it is available for use by anyone who wants to verify the signature.
         */

        //the private key is referred to as an alias and this information is stored in the .keystore file (a keystore contains only one private key)
        //https://stackoverflow.com/questions/3997748/how-can-i-create-a-keystore
        //in this there is a good a guide on how to create a keystore:
        //run a long command:
        //C:\Windows\system32> keytool -genkey -v -keystore [your keystore file path]{C:/index.keystore}
        //                                   -alias [your_alias_name]{index} -keyalg RSA -keysize 2048 -validity 10000[in days]
        //in a cmd with admin privileges
        //keytool is the executable
        //-genkey indicates you want to create a key pair
        //-v is verbose
        //-keystore is for creating a keystore with its relative path
        //-alias is the alias for the key which will be used for signing with jarsigner executable
        //and -keyalg -keysize -validity are standard stuff to use like that

        //then enter your details

        //now that a keystore is created
        //it is possible to sign the jar with the jarsigner

        //with:
        //jarsigner JarPath KeyName
        //the -keystore option may be provided if they keystore is not in the same directory as the jar
        //via this process the jar is self-signed with the alias davi and everyone can verify that the jar was signed by me in this case
        //that everyone is going to be me again anyways

        //just run:
        //jarsigner -verify jar-file

        //now this sign makes actually no sense
        //because it does not come with a certificate (which must be purchased) to actually certify you
        //hence all the errors when verifying but the jar is actually signed

        //https://www.entrust.com/knowledgebase/ssl/how-do-i-sign-a-jar-file-using-an-entrust-certificate-with-the-jdk-jarsigner-tool
        //this has more info on how to sign with a certificate which you should own

        //LEARN ABOUT SECURITY WHICH IS ESSENTIAL WHEN WORKING WITH COMPUTERS

        //NOTE:
        //when using imports you are actually importing code from another .jar file located in specific packages in
        //the jdk lib directory






    }

}
