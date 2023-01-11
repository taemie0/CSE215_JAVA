
public interface SaveableToFile {
   public void appendToFile(String fileName);
   public int numberOfLinesInFile(String fileName);
   public Vehicle[] getAllVeciclesFromFile(String fileName);
}
