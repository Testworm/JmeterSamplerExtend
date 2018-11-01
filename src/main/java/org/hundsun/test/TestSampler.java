package org.hundsun.test;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;
import org.codehaus.groovy.util.StringUtil;

// 接受界面配置参数的的类，处理业务逻辑，继承AbstractSampler   此类较为简单  接收入参，处理，输出结果
public class TestSampler extends AbstractSampler{
    private static final long serialVersionUID = 240L;

    private static final Logger log = LoggingManager.getLoggerForClass();

    // The name of the property used to hold our data; final 的变量不能被修改
    public static final String domain = "domain.text";    // 域名
    public static final String port = "port.text";        // 端口
    public static final String contentEncoding = "contentEncoding.text";  // 编码格式
    public static final String path = "path.text";   // 路径
    public static final String method = "method.text";   // 方法
    public static final String postBodyContent = "postBodyContent.text";   // 发送的内容
    public static final String useKeepAlive = "useKeepAlive.text";          // 是否KeepAlived

    private static AtomicInteger classCount = new AtomicInteger(0); // keep track of classes created


    private String getTitle() {
        return this.getName();
    }

    /**
     * @return the data for the sample
     */
    public String getdomain() {
        return getPropertyAsString(domain);
        //从gui获取domain输入的数据
    }

    public String getport() {
        return getPropertyAsString(port);
        //从gui获取port输入的数据
    }

    public String getcontentEncoding() {
        return getPropertyAsString(contentEncoding);
        //从gui获取content-Encoding输入的数据   以map格式存储数据
    }

    public String getpath() {
        return getPropertyAsString(path);
        // 获取路径

    }

    public String getmethod() {
        return getPropertyAsString(method);

    }

    public String getpostBodyContent() {
        return getPropertyAsString(postBodyContent);

    }

    public String getuseKeepAlive() {
        return getPropertyAsString(useKeepAlive);

    }

    // 构造函数
    public TestSampler() {
        //getTitle方法会调用getName方法，setName不写会默认调用getStaticLabel返回的name值
        setName("Test Sampler");
        classCount.incrementAndGet();
        trace("FirstPluginSampler()");
    }
    private void trace(String s) {
        String tl = getTitle();
        String tn = Thread.currentThread().getName();
        String th = this.toString();
        // 日志输出
        log.debug(tn + " (" + classCount.get() + ") " + tl + " " + s + " " + th);
    }

    // 存储结果数据的方法
    @Override
    public SampleResult sample(Entry arg0) {
        // TODO Auto-generated method stub
        trace("sample()");
        SampleResult res = new SampleResult();
        boolean isOK = false; // Did sample succeed?
        String response = null;
        String sdomain = getdomain(); // Sampler data
        String sport = getport();
        String scontentEncoding = getcontentEncoding();
        String spath = getpath();
        String smethod = getmethod();
        String spostBodyContent = getpostBodyContent();
        String suseKeepAlive = getuseKeepAlive();

        res.setSampleLabel(getTitle());
        /*
         * Perform the sampling
         */

        res.sampleStart(); // Start timing
//        try {

            // Do something here ...
            if ("sss".equals("ee")){
                response = Thread.currentThread().getName();

                /*
                 * Set up the sample result details
                 */
                res.setSamplerData("setSamplerData!!!");
                res.setResponseData(response+sdomain+sport+scontentEncoding+spath+smethod+spostBodyContent+suseKeepAlive, null);
                res.setDataType(SampleResult.TEXT);
                res.setSuccessful(true);
                res.setResponseCodeOK();
                res.setResponseMessage("OK");// $NON-NLS-1$

            }
            else{
                response = Thread.currentThread().getName();

                /*
                 * Set up the sample result details
                 */
                res.setSamplerData("setSamplerData!!!");
                res.setResponseData(response+sdomain+sport+scontentEncoding+spath+smethod+spostBodyContent+suseKeepAlive, null);
                res.setDataType(SampleResult.TEXT);
                res.setSuccessful(false);
                res.setResponseCodeOK();
                res.setResponseMessage("NOK");// $NON-NLS-1$
            }
            response = Thread.currentThread().getName();

            /*
             * Set up the sample result details
             */
            res.setSamplerData("setSamplerData!!!");
            res.setResponseData(response+sdomain+sport+scontentEncoding+spath+smethod+spostBodyContent+suseKeepAlive, null);
            res.setDataType(SampleResult.TEXT);
            res.setSuccessful(true);
            res.setResponseCodeOK();
            res.setResponseMessage("OK");// $NON-NLS-1$
//            isOK = true;
//        } catch (Exception ex) {
//            log.debug("", ex);
//            res.setResponseCode("500");// $NON-NLS-1$
//            res.setResponseMessage(ex.toString());
//        }
//        res.sampleEnd(); // End timimg
//
//        res.setSuccessful(isOK);

        return res;
    }

}