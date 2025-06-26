package org.batch;
import com.lambokProject.EmployeeLambok;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeLambok  e1= new EmployeeLambok();
        EmployeeLambok e2= new EmployeeLambok(1,"s",500);
        EmployeeLambok e3=new EmployeeLambok(1,"k",1000);
        System.out.println( e2.getEmpId()+" "+e2.getSalary());
        System.out.println(e2);
        System.out.println(e2.hashCode());
        System.out.println(e3.hashCode());
        System.out.println(e2==e3);
        System.out.println(e2.equals(e3));
    }
}
