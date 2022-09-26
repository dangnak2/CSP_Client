import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CourseServerIF extends Remote {
  ArrayList<Course> getAllCourseData() throws RemoteException;
}
