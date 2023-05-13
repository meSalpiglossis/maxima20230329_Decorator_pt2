import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ZipReaderDecorator implements IFileReader{
    private IFileReader reader;

    public ZipReaderDecorator(IFileReader reader){
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

        // TODO: Open file (in a default way)
        System.out.println("+ZipReaderDecorator open with parameter: " + filename);
        System.out.println("ZipReaderDecorator::open::Just trying to open zip file: " + filename);
        return isOk && isValidFileType() && !isPasswordNecessary();
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

        System.out.println("+ZipReaderDecorator read without parameters");

        // TODO: Read file (in a default way)
        System.out.println("ZipReaderDecorator::read::Just trying to read zip file");

        return unZip(readerStream);
    }

    private void logDependencyAdding(IFileReader reader, String methodToLog){
        String msg = "+ZipReaderDecorator " + methodToLog + " with parameter IFileReader: ";
        if (reader != null) {
            msg += reader.toString();
        }
        else {
            msg += "null";
        }
        System.out.println(msg);
    }

    private boolean isValidFileType(){
        // Note: Is this file type valid

        System.out.println("-ZipReaderDecorator isValidFileType");
        return true;
    }

    private boolean isPasswordNecessary(){
        // Note: Is this file need password

        System.out.println("-ZipReaderDecorator isPasswordNecessary");
        return false;
    }

    private ByteArrayOutputStream unZip(ByteArrayOutputStream stream){
        System.out.println("-ZipReaderDecorator unZip with parameter: " + stream.toString());

        return stream;
    }
}