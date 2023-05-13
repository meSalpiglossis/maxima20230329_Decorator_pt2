import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MD5EncryptReaderDecorator implements IFileReader {
    private IFileReader reader;

    public MD5EncryptReaderDecorator(IFileReader reader){
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    public void setRider(IFileReader reader){
        logDependencyAdding(reader, "setRider");
        this.reader = reader;
    }

    public boolean open(String fileName) throws IOException {
        // TODO Possibly: with reader usage
        boolean isOk = true;
        if (reader != null){
            isOk = reader.open(fileName);
        }

        // TODO: Open file (in a default way)
        System.out.println("+MD5EncryptReaderDecorator open with parameter: " + fileName);
        System.out.println("MD5EncryptReaderDecorator::open::Just trying to open md5 file: " + fileName);
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

        System.out.println("+MD5EncryptReaderDecorator read without parameters");

        // TODO: Read file (in a default way)
        System.out.println("MD5EncryptReaderDecorator::read::Just trying to read md5 file");

        return encrypt(readerStream);
    }

    private void logDependencyAdding(IFileReader reader, String methodToLog){
        String msg = "+MD5EncryptReaderDecorator " + methodToLog + " with parameter IFileReader: ";
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

        System.out.println("-MD5EncryptReaderDecorator isValidFileType");
        return true;
    }

    private boolean isPasswordNecessary(){
        // Note: Is this file need password

        System.out.println("-MD5EncryptReaderDecorator isPasswordNecessary");
        return false;
    }

    private ByteArrayOutputStream encrypt(ByteArrayOutputStream stream){
        System.out.println("-MD5EncryptReaderDecorator encrypt with parameter: " + stream.toString());

        return stream;
    }

}
