import java.awt.*;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Project name(项目名称)：UDP
 * Package(包名): PACKAGE_NAME
 * Class(类名): UDPReceiver
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/17
 * Time(创建时间)： 20:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UDPReceiver
{
    public static void main(String[] args)
    {
        DatagramSocket datagramSocket = null;
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = null;
        try                                  //打开连接或者流
        {
            datagramSocket = new DatagramSocket(9090);
            datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
            datagramSocket.receive(datagramPacket);
            String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(message);
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
