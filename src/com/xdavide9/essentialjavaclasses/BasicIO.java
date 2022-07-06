package com.xdavide9.essentialjavaclasses;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class BasicIO {

    BasicIO() {
        //first section covers streams
        //what is a stream? it's basically a flow of data
        //we distinguish between input streams and output streams
        //an input stream reads data from a source
        //an output stream writes data to a destination

        //these streams are therefore really important when working with files

        //BYTE STREAMS
        //the most basic form of a stream is a ByteStream which should only
        //be used when working with the most primitive form of IO
        //byte streams' classes are all descendants of InputStream and OutputStream

        //all the other streams are built on Byte Streams.

        //CHARACTER STREAMS
        //are better than basic byte streams under some circumstances
        //(for example internationalization)
        //all character streams' classes are descendants of Reader and Writer

        /*
        Character streams are often "wrappers" for byte streams.
        The character stream uses the byte stream to perform the physical I/O,
        while the character stream handles translation between characters and bytes.
        FileReader, for example, uses FileInputStream, while FileWriter uses FileOutputStream.
         */

        //BUFFERED STREAMS
        //are a better version of streams that use buffers (both in input and output)
        //to make the program more efficient and prevent it from running expensive operation like disk access etc...
        //these streams are used to wrap unbuffered streams:

        /*
        BufferedReader inputStream = new BufferedReader(new FileReader("xanadu.txt"));
        BufferedWriter outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));
         */

        //in this example not only are we using character streams (FileReader and FileWriter) which
        //are better than byte stream but we are also wrapping them in the corresponding buffered version by
        //passing them in the suitable constructor

        //BufferedInputStream and BufferedOutputStream also exist which are for wrapping byte streams instead of character streams

        //IMPORTANT:
        //remember that all streams must be closed when finished working with them
        //this is usually done in a finally clause for good code

        //SCANNING AND FORMATTING

        //scanning:
        /*
        Objects of type Scanner are useful for breaking down formatted input into tokens and translating individual tokens according to their data type.
         */
        //this means that the white spaces are by default used a separation tokens when working with scanners

        //formatting:
        //Stream objects that implement formatting are instances of either PrintWriter,
        //a character stream class, or PrintStream, a byte stream class.

        //though the only PrintStream objects one's ever going to need in a program are System.out and System.err
        //we can call print methods and format method from them:
        //when using print methods like println whatever is passed as an argument has its toString method called implicitly
        //when using format you are doing that c thing

        //STANDARD STREAMS
        /*
        Standard Streams are a feature of many operating systems. By default, they read input from the keyboard and write output to the display.
        They also support I/O on files and between programs, but that feature is controlled by the command line interpreter, not the program.
         */
        //the java platform has three standard streams: Standard Input (System.in), Standard Output (System.out) and Standard Error (System.err)
        //they are defined as Byte Streams and indeed are PrintStream objects.
        //System.err is an output byte stream used to print errors.

        //CONSOLE
        /*
        A more advanced alternative to the Standard Streams is the Console.
        This is a single, predefined object of type Console that has most of the features provided by the Standard Streams, and others besides.
        The Console is particularly useful for secure password entry.
        The Console object also provides input and output streams that are true character streams, through its reader and writer methods.
         */
        /*
        Before a program can use the Console, it must attempt to retrieve the Console object by invoking System.console().
        If the Console object is available, this method returns it, If System.console returns NULL, then Console operations are not permitted,
        either because the OS doesn't support them or because the program was launched in a non-interactive environment.
         */

        //DATA STREAMS
        //Support I/O of basic data types
        /*
        Data streams support binary I/O of primitive data type values (boolean, char, byte, short, int, long, float, and double) as well as String values.
        All data streams implement either the DataInput interface or the DataOutput interface.
        This section focuses on the most widely-used implementations of these interfaces, DataInputStream and DataOutputStream.
         */

        /*
        A DataOutputStream can only be created as a wrapper for an existing byte stream object, DataStreams provides a buffered file output byte stream.
        Like DataOutputStream, DataInputStream must be constructed as a wrapper for a byte stream.
         */

        //These are generally bad because they use floating points which are bad to store precise values like fractions, for this see BigDecimal, which needs
        //objects stream tho cause it's an object

        //OBJECT STREAMS
        /*
        Just as data streams support I/O of primitive data types, object streams support I/O of objects.
        Most, but not all, standard classes support serialization of their objects.
        Those that do implement the marker interface Serializable.
        The object stream classes are ObjectInputStream and ObjectOutputStream.
        These classes implement ObjectInput and ObjectOutput, which are subinterfaces of DataInput and DataOutput.
        That means that all the primitive data I/O methods covered in Data Streams are also implemented in object streams.
         */

        //while data streams work with basic data type, object streams work with objects
        //everything you could do with data streams tho you can do with object streams because
        //all object streams implement ObjectInput or ObjectOutput which are children of DataInput and DataOutput

        //there are basically two simple methods to use: writeObject and readObject, which not only work with the single object
        //in question but also with all the references it has to other subobjects (take for example you are serializing an array, then
        //all its members are going to be serialized as well in the same way they were created)

        //streams can only contain one copy of an object but any number of references to a single object
        /*
        Object ob = new Object();
        out.writeObject(ob);
        out.writeObject(ob);
        //writing the same object twice (thus creating two references)

        //this has to be matched when reading:
        Object ob1 = in.readObject();
        Object ob2 = in.readObject();
        //where ob1 and ob2 are two references to the same Object ob
         */

        //-----------
        //FILE I/O
        //What is a path?
        //we know that most file systems today use a hierarchical or tree structure
        //where there is a root node (directory or folder) which can contain more directories or files and so on
        //a path tells you where the file in question is in this structure
        //the concept is the same but its application varies between different operating system
        //in windows for example you can have multiple root nodes (C:\, D: etc)
        //while in solaris you have only 1 and it's referred to as /
        //the delimiter in windows is \ while in solaris is /

        //Relative or Absolute
        //an absolute path goes from the root node to the file in question
        //like "/home/sally/statusReport"
        //a relative path is a path that needs to be combined with another path
        //in order to locate the file in question in the file system
        //like "joe/foo"

        //Symbolic links
        //are files that serve as reference to other files (well known as linkers in windows)
        //resolving a link means to substitute the actual location in the file system for the symbolic link.
        //a circular behavior could be created with these links but it's a well known issue

        //now back to java itself

        //PATH CLASS
        //covering the java.nio package (new I/O) vs the java.io package (I/O)
        //A Path is the programmatic representation of the operating system path
        //this means a path is not system independent, even if the two path from
        //different operating system point to the same object in the same tree structure

        //PATH OPERATIONS
        //path operations are sometimes called syntactic operation, because they operate on
        //the path itself and not the file in the system

        //---------------------
        //Creating a path:
        //A path can be easily created with one of the get methods from the Paths class:
        /*
            Path p1 = Paths.get("/tmp/foo");
            Path p2 = Paths.get(args[0]);
            Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
         */
        //this is shorthand for FileSystems.getDefault().getPath("/users/sally");

        //this Paths.get method is useful in combo with System.getenv() and System.getProperties()
        //to get paths for specific directories in the operating system
        //System.getProperties returns the Properties object (which looks like it works like a map) which is an object that stores
        //all the information about the local system, configuration and the user
        //System.getenv returns read-only map of all the environment variables of the system (which
        //means that trying to write to the map results in an Exception)
        //source: https://www.baeldung.com/java-system-get-property-vs-system-getenv
        //examples


        Path p1 = Paths.get(System.getenv("APPDATA"));
        Path p2 = Paths.get(System.getProperty("user.home"));
        System.out.println(p1);
        System.out.println(p2);

        //prints all the environment variables of the system
        //System.getenv().forEach((key, value) -> System.out.println(key + "  --->  " + value));

        //prints all the properties of the system
        //System.getProperties().forEach((key, value) -> System.out.println(key + "  --->  " + value));

        //-------------------
        //Retrieving information about a path:
        //directories in a tree can be thought as indexes where the root node is index 0
        //and the lowest node is index n-1 where n is the number of elements of the tree

        Path path = Paths.get("C:\\home\\joe\\foo");
        System.out.format("toString: %s%n", path.toString());   //toString() is implicitely called so it's useless to specify it
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        //----------------------
        //Removing redundancies from a path
        /*
        Many file systems use "." notation to denote the current directory and ".." to denote the parent directory.
        You might have a situation where a Path contains redundant directory information.
        Perhaps a server is configured to save its log files in the "/dir/logs/." directory, and you want to delete the trailing "/." notation from the path.

        The normalize method removes any redundant elements, which includes any "." or "directory/.." occurrences.
         */

        //-------------------------
        //Converting a path
        //there are 3 methods:

        //1)
        //toUri() to change a path into a string that can be opened from a browser
        Path path1 = Paths.get("/home/logfile");
        //Result is file:///home/logfile
        System.out.format("%s%n", path1.toUri());

        //2)
        //toAbsolutePath() changes a relative path into an absolute path
        //which generally means prepending the current working directory

        //3)
        //toRealPath() which returns a real path of an existing file and does multiple things:
        //If true is passed to this method and the file system supports symbolic links, this method resolves any symbolic links in the path.
        //If the Path is relative, it returns an absolute path.
        //If the Path contains any redundant elements, it returns a path with those elements removed.

        //--------------------------
        //Joining two paths
        //the resolve() methods appends a path to another path
        Path path2 = Paths.get("C:\\home\\joe\\foo");
        System.out.format("%s%n", path2.resolve("bar"));
        // Result is C:\home\joe\foo\bar

        //-----------------
        //Creating a path between two paths
        Path pa1 = Paths.get("home");
        Path pa3 = Paths.get("home/sally/bar");
        // Result is sally/bar
        Path pa1_to_pa3 = pa1.relativize(pa3);
        System.out.println(pa1_to_pa3);

        //get a path that is of a higher node than another call relativize to get a path that gets
        //from the higher node path to the lower node path

        //-----------------
        //Comparing two paths
        //it's possible to compare two path with multiple methods...
        //equals(), startsWith(), endsWith()

        //FILE OPERATIONS
        //the Paths class is a primary entrypoint of the java.nio.file package
        //Files is another one

        //before starting some key concepts:

        //Releasing System resources
        //this means if a class implements the Closeable interface the close() method
        //must be invoked to close the resource (could be something like a stream for example)
        //and this is usually done in a try with resources statement (try, catch and finally block)
        //where you call close in the finally clause cause that is code that is going to be called either way

        //---------------
        //Varargs
        //is a construct that allows to pass an arbitrary number of values to a method,
        //it is used when you don't know how many of arguments of the same type will be passed
        //to create one follow the type of the last parameter in method by an ellipsis (three dots, ...)
        //then a space and a parameter name
        //it's like a shortcut to creating an array and therefore in the method body it's exactly like an array
        //examples:
        //System.out.printf(String format, Object... args);
        //this is the printf method defined in System

        class VarargsEx {
            void DemoMethod(int a, Object... args) {    //cant put another parameter after a varargs

            }
            void DemoMethod1(Object[] args, int a) {

            }
            //these two are the same
        }

        //----------------
        //Atomic operations
        //An atomic operation is an operation that cannot be interrupted or partially performed.
        //Either the entire operation is performed or the operation fails.
        //This is important when you have multiple processes operating on the same area of the file system,
        //and you need to guarantee that each process access a complete file

        //--------------------
        //Method chaining:
        //call method after method without creating useless variables
        //idk why it's even listed

        //Glob
        //wtf is this?
        //glob syntax is used to specify pattern behavior
        //like in the command line
        //there are some rules which are very similar to the command line and it's pointless to learn them if not in practise
        //examples:
        /*
            *.html                       Matches all strings that end in .html
            ???                           Matches all strings with exactly three letters or digits
            *[0-9]*                     Matches all strings containing a numeric value
            *.{htm,html,pdf}       Matches any string ending with .htm, .html or .pdf
            a?*.java                    Matches any string beginning with a, followed by at least one letter or digit, and ending with .java
            {foo*,*[0-9]*}           Matches any string beginning with foo or any string containing a numeric value
        */

        //------------------
        //Link Awareness
        //The Files class is "link aware." Every Files method either detects what to do when a symbolic link is encountered,
        //or it provides an option enabling you to configure the behavior when a symbolic link is encountered.

        //--------FILES------------
        //Now move to practise:
        //While Paths methods work syntactically with path (which means they don't care about the file itself)
        //the Files class of course works with the files
        //Some self explanatory methods from Files class:
        System.out.println(Files.exists(path));
        System.out.println(Files.notExists(path));
        //if both of these return false then the status is unknown
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));
        try {
            System.out.println(Files.isSameFile(path, path2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //all of these are static

        //-----------
        //Deleting a file or directory
        //just use delete(path)
        //and depending on the Exception thrown it's possible to dermine why the deletion wasn't successful
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
        //The deleteIfExists(Path) method also deletes the file, but if the file does not exist, no exception is thrown.

        //------------------
        //Copying files:
        //just use Files.copy(source, target, [CopyOptions...])
        //about those CopyOptions there are multiple like REPLACE_EXISTING, to use when the target exists
        //and more

        //------------------
        //Moving a file or directory:
        //its like the same as copying
        //run Files.move(source, target, [CopyOptions...])

        //------------------
        //MANAGING METADATA
        /*
            The definition of metadata is "data about other data."
            With a file system, the data is contained in its files and directories,
            and the metadata tracks information about each of these objects: Is it a regular file, a directory, or a link?
            What is its size, creation date, last modified date, file owner, group owner, and access permissions?
         */

        /*
            A file system's metadata is typically referred to as its file attributes.
            The Files class includes methods that can be used to obtain a single attribute of a file, or to set an attribute.
            https://docs.oracle.com/javase/tutorial/essential/io/fileAttr.html
         */

        //Reading, Writing, and Creating Files
        //too many options to list
        //I kind of give up
        //just go to
        //https://docs.oracle.com/javase/tutorial/essential/io/file.html#openOptions
        //it's important to get a general understanding either way

        //NOTE:
        //what's interesting about Files and Paths class is that everything is basically static here

        //back to some simple stuff
        //Creating a directory
        //Files.createDirectory(path);
        //these are all options that were already available in the java.io package but implemented maybe
        //in a better way who can say that...

        //Summary
        /*
            The java.io package contains many classes that your programs can use to read and write data. Most of the classes implement sequential access streams. The sequential access streams can be divided into two groups: those that read and write bytes and those that read and write Unicode characters. Each sequential access stream has a speciality, such as reading from or writing to a file, filtering data as its read or written, or serializing an object.

            The java.nio.file package provides extensive support for file and file system I/O. This is a very comprehensive API, but the key entry points are as follows:

            The Path class has methods for manipulating a path.
            The Files class has methods for file operations, such as moving, copy, deleting, and also methods for retrieving and setting file attributes.
            The FileSystem class has a variety of methods for obtaining information about the file system.
            More information on NIO.2 can be found on the OpenJDK: NIO project website. This site includes resources for features provided by NIO.2 that are beyond the scope of this tutorial, such as multicasting, asynchronous I/O, and creating your own file system implementation.
         */








    }
}

