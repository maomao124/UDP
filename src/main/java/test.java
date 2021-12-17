/**
 * Project name(项目名称)：UDP
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/17
 * Time(创建时间)： 20:27
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test implements Runnable
{
    @Override
    public void run()
    {
        UDPReceiver.main(null);
    }

    public static void main(String[] args)
    {
        test t = new test();
        Thread thread = new Thread(t);
        thread.start();
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        UDPSender.main(null);
    }
}
