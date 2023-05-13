import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FileReaderDecorator implements IFileReader {
    private IFileReader reader;

    public FileReaderDecorator(IFileReader reader){
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    public void setRider(IFileReader reader){
        logDependencyAdding(reader, "setRider");
        this.reader = reader;
    }

    public boolean open(String filename) throws IOException {
        // TODO Possibly: with reader usage
        boolean isOk = true;
        if (reader != null){
            isOk = reader.open(filename);
        }

        System.out.println("+FileReaderDecorator open with parameter: " + filename);

        // TODO: Open file (in a default way)
        System.out.println("FileReaderDecorator::open::Just trying to open txt file: " + filename);

        return isOk;
    }

    public ByteArrayOutputStream read() throws IOException {
        // TODO: Implement additional behaviour using reader

        ByteArrayOutputStream readerStream = null;
        if (reader != null){
            readerStream = reader.read();
        }
        else {
            readerStream = new ByteArrayOutputStream();
        }

        System.out.println("+FileReaderDecorator read without parameters");

       // TODO: Read file (in a default way)
        System.out.println("FileReaderDecorator::read::Just trying to read txt file");

        return readerStream;
    }

    private void logDependencyAdding(IFileReader reader, String methodToLog){
        String msg = "+FileReaderDecorator " + methodToLog + " with parameter IFileReader: ";
        if (reader != null) {
            msg += reader.toString();
        }
        else {
            msg += "null";
        }
        System.out.println(msg);
    }
}
