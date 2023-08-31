public class Main {
 public static void main(String[] args) {
 Thread person1 = new CookThread("Person 1");
 Thread person2 = new CookThread("Person 2");
 person1.start();
 person2.start();
 }
 static class CookThread extends Thread {
 private final String name;
 public CookThread(String name) {
 this.name = name;
 }
 public void run() {
 System.out.println(name + " started cooking.");
 for (int i = 1; i <= 5; i++) {
 System.out.println(name + " - Preparing ingredient " + i);
 try {
 Thread.sleep(100);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 System.out.println(name + " finished cooking.");
 }
 }
}
