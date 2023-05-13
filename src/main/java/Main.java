import java.io.ByteArrayOutputStream;

public class Main {
    public static void main(String[] args){

        // TXT read
        try {
            IFileReader additionalReaderFeature = null;
            IFileReader simpleTXTReader = new FileReaderDecorator(additionalReaderFeature);
            simpleTXTReader.open("ToRead.txt");
            ByteArrayOutputStream readerStream = simpleTXTReader.read();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println();

        // Zip Arch Txt read
        try {
            IFileReader additionalReaderFeature = new ZipReaderDecorator(null);
            IFileReader unZipTxtReader = new FileReaderDecorator(additionalReaderFeature);
            unZipTxtReader.open("ZipToRead.txt");
            ByteArrayOutputStream readerStream = unZipTxtReader.read();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println();

        // MD5 Crypt Txt read
        try {
            IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(null);
            IFileReader md5CryptoTxtReader = new FileReaderDecorator(additionalReaderFeature);
            md5CryptoTxtReader.open("MD5ECryptToRead.txt");
            ByteArrayOutputStream readerStream = md5CryptoTxtReader.read();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println();

        //  MD5 Crypt Zip Arch Txt read
        try {
            IFileReader additionalReaderFeature = new ZipReaderDecorator(new MD5EncryptReaderDecorator(null));
            IFileReader md5CryptoZipTxtReader = new FileReaderDecorator(additionalReaderFeature);
            md5CryptoZipTxtReader.open("MD5ECryptZipToRead.txt");
            ByteArrayOutputStream readerStream = md5CryptoZipTxtReader.read();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println();

        //  MD5 Crypt Zip MD5 Crypt Arch Txt read
        try {
            IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(new ZipReaderDecorator(new MD5EncryptReaderDecorator(null)));
            IFileReader md5CryptoZipMD5TxtReader = new FileReaderDecorator(additionalReaderFeature);
            md5CryptoZipMD5TxtReader.open("MD5ECryptZipMD5ECryptToRead.txt");
            ByteArrayOutputStream readerStream = md5CryptoZipMD5TxtReader.read();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println();

        //  MD5 Crypt Zip-Zip-Zip-Zip-Zip Arch Txt read
        try {
            IFileReader additionalReaderFeature = new ZipReaderDecorator(new ZipReaderDecorator(new ZipReaderDecorator(new ZipReaderDecorator(new ZipReaderDecorator(null)))));
            IFileReader unZip5TimesTxtReader = new FileReaderDecorator(additionalReaderFeature);
            unZip5TimesTxtReader.open("ZipZipZipZipZipToRead.txt");
            ByteArrayOutputStream readerStream = unZip5TimesTxtReader.read();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println();

        // HomeWork:
        // 1) Read source code and read console logging
        // 2) Possibly debug source code
        // 3) Add new Decorator: Rar Arch support
        // 4) Add new Decorator: RSA Encrypt support
        // 5) Add Builder to configure Decorators
        // 6*) Extract abstract class for all decorators
        // 7*) Cover decorators with Unit Tests
    }
}

