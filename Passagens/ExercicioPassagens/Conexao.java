import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Conexao {

    public static String receber(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        byte infoBytes[] = new byte[10];
        int bytesLidos = in.read(infoBytes);

        if (bytesLidos > 0) {
            return new String(infoBytes);
        } else {
            return "";
        }
    }

    public static void enviar(Socket socket, String textoRequisicao) throws IOException {
        OutputStream out = socket.getOutputStream();
        out.write(textoRequisicao.getBytes());
        out.flush(); // limpando a saida de dados
    }
}
