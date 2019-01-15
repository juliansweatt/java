import java.io.File;
import java.util.Comparator;

class SizeSort implements Comparator<File>
{
	public int compare(File a, File b)
	{
		return (int) (a.length() - b.length());
	}
}