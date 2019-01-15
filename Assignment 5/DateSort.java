import java.io.File;
import java.util.Comparator;

class DateSort implements Comparator<File>
{
	public int compare(File a, File b)
	{
		return (int) (a.lastModified() - b.lastModified());
	}
}