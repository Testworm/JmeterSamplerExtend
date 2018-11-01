package com.hundsun.comparator;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jorphan.logging.LoggingManager;

import org.apache.log.Logger;
import com.hundsun.comparator.dataComparator;
// 传递参数和结果
public class ComparatorSampler extends AbstractSampler {

    private static final long serialVersionUID = 240L;
    private static final Logger log = LoggingManager.getLoggerForClass();


    // The name of the property used to hold our data; final 的变量不能被修改
    public static final String str1 = "str1.text";    // 字符串1
    public static final String str2 = "str2.text";        // 字符串2


    public String getExcpetRes(){
        return getPropertyAsString(str1);
    }

    public String getRealRes(){
        return getPropertyAsString(str2);
    }

    private String getTitle() {
        return this.getName();
    }

    public ComparatorSampler(){
        setName("db Sampler");
        classCount.incrementAndGet();
        trace("FirstPluginSampler()");
    }

    private static AtomicInteger classCount = new AtomicInteger(0); // keep track of classes created


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
        String str1 = getExcpetRes();  // Sampler  接收入参
        String str2 = getRealRes();      // 接收入参

        res.setSampleLabel(getTitle());
        /*
         * Perform the sampling
         */
        // 主方法
        String result = dataComparator.datasCompare(str1, str2);

        res.sampleStart(); // Start timing

        try {

            // Do something here ...
            if (result.equals("hello"))
            {
                response = Thread.currentThread().getName();

                /*
                 * Set up the sample result details
                 */
                res.setSamplerData(str1 + "\n" + str2);
                res.setResponseData(response+str1+str2, null);
                res.setDataType(SampleResult.TEXT);

                res.setResponseCodeOK();
                res.setResponseMessage(result);// $NON-NLS-1$
                isOK = true;
            }

        } catch (Exception ex) {
            log.debug("", ex);
            res.setResponseCode("500");// $NON-NLS-1$
            res.setResponseMessage(ex.toString());
        }
        res.sampleEnd(); // End timimg

        res.setSuccessful(isOK);

        return res;
    }


}
