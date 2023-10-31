package org.blackberry020;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderFactory {

        private static final HashMap<String, Reader> readers =
                (HashMap<String, Reader>) Stream.of(new Object[][] {
                        { "txt", new TxtReader() },
                        { "xml", new XmlReader() },
                        { "json", new JsonReader() },
                }).collect(Collectors.toMap(data -> (String) data[0], data -> (Reader) data[1]));

        public static Reader getReader(String fileName){
            String extension = fileName.substring(fileName.indexOf('.') + 1);
            return readers.get(extension);
        }
}
