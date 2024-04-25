import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // create url
            URL url = new URL("http://localhost:8000/user");

            // create connection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            // set method
            httpURLConnection.setRequestMethod("POST");

            // set content type
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            // we want to write to the stream, so we have to enable it
            httpURLConnection.setDoOutput(true);

            // the json we are going to send, if we wanted to we could make a map to json converter method
            String json = "{\"name\":\"bob\"}";

            // get the output stream
            OutputStream outputStream = httpURLConnection.getOutputStream();

            // write the json to the output stream
            outputStream.write(json.getBytes());

            // get the input stream
            InputStream inputStream = httpURLConnection.getInputStream();

            // create a buffer reader so we can read the bytes
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // print out the buffer reader
            System.out.println(bufferedReader.readLine());
        } catch (Exception e) {
            // just print the error for now
            e.printStackTrace();
        }
    }
}