import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Service 
{

  public void addStudent(Student student) throws IOException 
  {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException 
  {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if(line == null)
        break;
      ret.add(Student.Parse(line));
    }
    reader.close();
    return ret;
  }

  public Collection<Student> findStudentByName(String name) 
  {
    try
      {
      var ret = new ArrayList<Student>();
      var result = new ArrayList<Student>();
      var f = new FileReader("db.txt");
      var reader = new BufferedReader(f);
      String line = "";
      while (true) {
        line = reader.readLine();
        if(line == null)
          break;
        ret.add(Student.Parse(line));
      }
    

    for(Student current : ret)
      {
        if(current.GetName().equals(name))
        {
          result.add(current);
        }
      }
    reader.close();
    return result;
 
    }
  
  catch (IOException e)
  {
    return new ArrayList<Student>();
  }
  
  }
}