package peL3;

public class Worker {
    public int key ;
    public String name;
    
   public int age;
   
   
   public Worker(int key, String name, int age) {
	   this.key =key;
	   this.name = name;
	   this.age =age;
   }
   
   
   public String toString() {
	   return "(" + key + "," + name + "," + age + ")";
   }
}
