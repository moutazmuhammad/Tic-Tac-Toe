import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

        ServerSocket external ;
        Socket internal ;
        DataInputStream input ;
        PrintStream output;
        JSONObject serverResponse = new JSONObject();
        String dbName = "ahmed";
    public server() throws IOException, JSONException
        {

            external = new ServerSocket(5007);
            while(true)
            {
                internal = external.accept();
                // System.out.println(internal);
                input  = new DataInputStream(internal.getInputStream());
                output = new PrintStream(internal.getOutputStream());
                String s =input.readLine();
                JSONObject json = new JSONObject(s);
                // System.out.println(s);
                //System.out.println(json);
                String type = json.get("type").toString();
                if(type.equals("LOGIN"))
                {
                    login(json);
                }
                else if (type.equals("SIGNUP") )
                {
                    signup(json);

                }
                //  external.close();
                internal.close();
                input.close();
                output.close();

            }
        }
        public void  login(JSONObject input) throws JSONException
        {
            String clientname =   input.get("username").toString();
            //  String pass =   input.get("pass").toString();
            if( clientname.equals(dbName))
            {
                serverResponse.put("Response", "login");
                output.println(serverResponse);

            }
            else
            {

                serverResponse.put("Response", "invalid login");
                output.println(serverResponse);

            }
        }
        public void signup(JSONObject input) throws JSONException
        {
            String clientname =   input.get("username").toString();
            if( clientname.equals(dbName))
            {
                serverResponse.put("Response", "signup");
                output.println(serverResponse);
            }
            else
            {
                serverResponse.put("Response", "invalid signup");
                output.println(serverResponse);
            }

        }



        public static void main(String[] args) throws IOException, JSONException {
        server s =  new server();

    }

    }