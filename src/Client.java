import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client {
  public static void main(String[] args) throws MalformedURLException, NotBoundException, IOException {
    System.setProperty("java.rmi.server.hostname","218.38.137.27");

    StudentServerIF studentServer;
    CourseServerIF courseServer;

    BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    try {
      studentServer = (StudentServerIF) Naming.lookup("Server");
      courseServer = (CourseServerIF) Naming.lookup("Server");

      System.out.println("******************** MENU ********************");
      System.out.println("1. List Students");
      System.out.println("2. List Courses");

      String sChoice = objReader.readLine().trim();

      if (sChoice.equals("1")) {
        System.out.println("Server's answer" + studentServer.getAllStudentData());
      } else if (sChoice.equals("2")) {
        System.out.println("Server's answer" + courseServer.getAllCourseData());
      }

    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
