package filesys;

public class ExceptionSystemeFichier extends Exception{

	public ExceptionSystemeFichier()
	{
		super("Erreur syst�me");
	}
	public ExceptionSystemeFichier(String message, Throwable cause)
	{
		super(message, cause);
	}
	public ExceptionSystemeFichier(String message)
	{
		super(message);
	}
	public ExceptionSystemeFichier(Throwable cause)
	{
		super("Erreur syst�me",cause);
	}
	
}
