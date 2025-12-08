/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while(true)
        {
          System.out.println("1. Dodaj nowego studenta.   2.Wyświetl studentów.    0. Wyjscie z aplikacji");
          int wybor = scanner.nextInt();
          scanner.nextLine();
          System.out.println("");

          switch(wybor)
            {
            case 1:
                System.out.println("Podaj imie studenta");
                String name = scanner.nextLine();

                System.out.println("Podaj wiek studenta");
                int age = scanner.nextInt();

                s.addStudent(new Student(name,age));
            break;             

            case 2:
                System.out.println("Lista studentow");
                var students = s.getStudents();
                for(Student current : students) 
                {
                  System.out.println(current.ToString());
                }
            break;
                

            case 0:
                System.out.println("Koniec programu");
                scanner.close();
                System.exit(0);
            break;
            }
                
        }
      
      
      
      

      // var students = s.getStudents();
      // for(Student current : students) {
      //   System.out.println(current.ToString());
      // }
    } catch (IOException e) {

    }
  }
}