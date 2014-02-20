public class main{      

	public static void main(String[] args) {
		Singleton a=Singleton.getInstance();
		Singleton b=Singleton.getInstance();
		Singleton c=Singleton.getInstance();
	    System.out.println("Hello, World");
	}
}   