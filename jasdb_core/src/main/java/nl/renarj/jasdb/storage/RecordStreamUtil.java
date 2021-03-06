package nl.renarj.jasdb.storage;

import nl.renarj.jasdb.core.exceptions.JasDBStorageException;
import nl.renarj.jasdb.core.storage.RecordResult;
import nl.renarj.jasdb.core.streams.ClonableByteArrayInputStream;
import nl.renarj.jasdb.core.streams.ClonableDataStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author Renze de Vries
 */
public class RecordStreamUtil {
    private static final String UTF_8 = "UTF8";

    public static String toString(RecordResult result) throws JasDBStorageException {
        InputStream inputStream = result.getStream();

        return toString(inputStream);
    }

    public static String toString(InputStream inputStream) throws JasDBStorageException {
        StringBuilder stringBuilder = new StringBuilder();

        int read;
        byte[] buffer = new byte[4096];
        try {
            while((read = inputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, read, Charset.forName(UTF_8)));
            }
        } catch(IOException e) {
            throw new JasDBStorageException("Unable to convert inputstream", e);
        }

        return stringBuilder.toString();
    }

    public static ClonableDataStream toStream(String data) {
        return new ClonableByteArrayInputStream(data.getBytes(Charset.forName(UTF_8)));
    }

}
