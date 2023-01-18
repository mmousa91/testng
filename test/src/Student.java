public class Student {

    Student (){
      System.out.println("hello world");

    }

    int studentCode;
    String studentName;
    String studentAddress;

    String getStudent () {
        String strAll = String.valueOf(studentCode)+ " ; " + studentName ;
        return strAll;
    }

}
