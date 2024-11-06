package tutorials_baptista;

import javax.swing.*;
import java.io.*;

public class Tutorial1 {
    public static void main(String[] args) {
        //creating a file
//        File file = new File("example.txt");
//
//        try{
//            if(file.createNewFile()){
//                System.out.println("File is created: " + file.getName());
//            }else {
//                System.out.println("File already exists.");
//            }
//            System.out.println("File exists: " + file.exists());
//            System.out.println("File readable: " + file.canRead());
//            System.out.println("File writable: " + file.canWrite());
//            System.out.println("File size: " + file.length() + " bytes");
//        }catch (IOException ex){
//            System.out.println("The error message is: " + ex.getMessage());
//        }

        //Streams in File I/O
//        try(FileOutputStream fos = new FileOutputStream("example.txt");
//            FileInputStream fis = new FileInputStream("example.txt")){
//
//            fos.write("Hello, I am writing this Byte stream!".getBytes());
//
//            int data;
//
//            while((data = fis.read()) != -1){
//                System.out.println((char) data);
//            }
//
//        }catch (IOException ex){
//            System.out.println("Error message is: " + ex.getMessage());
//        }

        //Reading and writing to files using Reader and FileWriter in File I/O
        //Writing to a File
//        try(FileWriter fw = new FileWriter("output.txt")){
//            fw.write("Hello World!");
//        }catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }

        //reading from a file
//        try(FileReader fr = new FileReader("output.txt")){
//            int data;
//            while ((data = fr.read()) != -1){
//                System.out.println((char) data);
//            }
//        }catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }

//        Reading from a file using the BufferedReader.
//        try(BufferedReader br = new BufferedReader(new FileReader("output.txt"))){
//            String line;
//            while ((line = br.readLine()) != null){
//                System.out.println(line);
//            }
//        }catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }

//        Writing to a file using the BufferedWriter.
//        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){
//            bw.write("This line is written using Buffered I/O in Java");
//        }catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }

//        Data streams - DataOutputStream and DataInputStream
//        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"))){
//            dos.writeInt(123);
//            dos.writeBoolean(false);
//            dos.writeDouble(3.142);
//        }catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
//
//        try(DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"))){
//           int number =  dis.readInt();
//           boolean value = dis.readBoolean();
//           double dv = dis.readDouble();
//
//            System.out.println(number + " " + value + " " + dv);
//        }catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }

//        Writing and reading objects from a file.
//        Note that when reading and writing objects that object must implement the Serializable interface

//        Student student = new Student("Alice", 20);
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.txt"));
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.txt"))
//        ){
//            oos.writeObject(student);
//            Student std = (Student) ois.readObject();
//            System.out.println("Student name: " + std.name + "\nStudent age: " + std.age);
//
//        }catch (IOException | ClassNotFoundException ex){
//            System.out.println(ex.getMessage());
//        }



//     RandomAccessFile

//        try(RandomAccessFile raf = new RandomAccessFile("random.txt", "rw")){
//            raf.writeUTF("Hello, Random Access File");
//            raf.seek(1);
//
//            System.out.println(raf.readUTF());
//        }catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }

//        JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    /*Assignments:
    * 1. Write a simple program to create a file named "demo.txt" and check it's properties (existence, readability)
    * 2. Implement a program that reads a user input string and writes the user input to a file named input.txt
    *    then checks the file and reads the input back from the file
    * 3. Create a Vehicle class it will have 3 attributes the number of wheels, the number of doors and the vehicleMake.
    * and then serialize the object of this class and then deserialize it (simply write and read the object from a file)
    *
    *
    * */


}

//class Student implements Serializable{
//    String name;
//    int age;
//
//    Student(String name, int age){
//        this.name = name;
//        this.age = age;
//    }
//}




















