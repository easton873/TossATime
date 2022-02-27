package Handler;

import Response.Response;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.HttpURLConnection;

public abstract class Handler<Req, Resp extends Response> implements HttpHandler {
    private Gson gson = new Gson();
    protected abstract Resp handle(Req request);
    protected abstract Resp fail(Exception e);
    protected abstract Req emptyRequest();
    public Resp handleRequest(Req request){
        try {
            return handle(request);
        } catch(Exception e){
            return fail(e);
        }
    }

    private Req parse(String json){
        try {
            return (Req) gson.fromJson(json, emptyRequest().getClass());
        } catch (Exception e) {
            e.printStackTrace();
            return emptyRequest();
        }
    }

    private String jsonify(Resp response){
        return gson.toJson(response);
    }

    private String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }
    private void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Request Received");
        OutputStream responseBody = exchange.getResponseBody();
        String respone = jsonify(handleRequest(parse(readString(exchange.getRequestBody()))));
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        writeString(respone, responseBody);
        exchange.close();
        System.out.println(respone);
    }
}