import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
import java.util.Scanner;
public class Service 
{
  Scanner scanner = new Scanner(System.in);

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

  public Collection<Student> deleteStudentByName(String name)
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
          reader.close();

          
          for(Student current : ret)
          {
              if(!current.GetName().equals(name)) 
              {
                  result.add(current);
              }
          }

          
          var writer = new BufferedWriter(new FileWriter("db.txt"));
          for(Student s : result)
          {
              writer.write(s.ToString());
              writer.newLine();
          }
          writer.close();

          return result;

      }
      catch (IOException e)
      {
          return new ArrayList<Student>();
      }
  }




  public Collection<Student> updateStudentByName(String name)
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
            reader.close();

          System.out.println("Podaj imie studenta");
          String name1 = scanner.nextLine();

          System.out.println("Podaj nazwisko studenta");
          String surname1 = scanner.nextLine();

          System.out.println("Podaj wiek studenta");
          int age1 = scanner.nextInt();

          System.out.println("Podaj date urodzenia studenta");
          String dateOfBirth = scanner.nextLine();
          dateOfBirth = scanner.nextLine();

          Student student = new Student(name1,surname1,age1,dateOfBirth);
          
            for(Student current : ret)
            {
                if(!current.GetName().equals(name)) 
                {
                    result.add(current);
                }
            }
            result.add(student);


            var writer = new BufferedWriter(new FileWriter("db.txt"));
            for(Student s : result)
            {
                writer.write(s.ToString());
                writer.newLine();
            }
            writer.close();

            return result;

        }
        catch (IOException e)
        {
            return new ArrayList<Student>();
        }
    }
  

}