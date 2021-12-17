import java.awt.*;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Project name(项目名称)：UDP
 * Package(包名): PACKAGE_NAME
 * Class(类名): UDPSender
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/17
 * Time(创建时间)： 20:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UDPSender
{
    public static void main(String[] args)
    {
        DatagramSocket datagramSocket = null;
        InetAddress inetAddress = null;
        DatagramPacket datagramPacket = null;
        String message = "你好 hello";
        try                                  //打开连接或者流
        {
            datagramSocket = new DatagramSocket();
            inetAddress = InetAddress.getLocalHost();
            byte[] buffer = message.getBytes();
            datagramPacket = new DatagramPacket(buffer, buffer.length, inetAddress, 9090);
            datagramSocket.send(datagramPacket);
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
        }
        catch (ConnectException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("连接异常！！！  " + e.toString());
            e.printStackTrace();
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try                              //关闭连接或者关闭流
            {
                if (datagramSocket != null)
                {
                    datagramSocket.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("连接或者流已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
        }
    }
}
