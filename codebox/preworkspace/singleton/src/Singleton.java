
	public class Singleton{      
	    private Singleton(){      
	     System.out.println("hello");
	    }      
	    private static class SingletonContainer{      
	        private static Singleton instance = new Singleton();      
	    }      
	    public static Singleton getInstance(){      
	        return SingletonContainer.instance;      
	    }      
	}  

   

