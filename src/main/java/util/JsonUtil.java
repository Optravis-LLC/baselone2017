package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonUtil {

  public static <T> T read(String in, Class<T> type) {
    Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
    return gson.fromJson(in, type);
  }

  /**
   * An InputStream for a file in UTF-8
   *
   * @param type type of the object
   * @param <T> type of the object
   * @return object
   */
  public static <T> T read(final InputStream in, Class<T> type) {
    return read(new InputStreamReader(in, Charset.forName("UTF-8")), type);
  }

  public static <T> T read(Path path, Class<T> type) throws IOException {
    try (Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
      return read(reader, type);
    }
  }

  public static <T> T read(Reader in, Class<T> type) {
    Gson gson = new GsonBuilder().create();
    return gson.fromJson(in, type);
  }


}
