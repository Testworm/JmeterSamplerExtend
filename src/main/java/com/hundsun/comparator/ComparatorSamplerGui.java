package com.hundsun.comparator;

import org.apache.jmeter.gui.util.HorizontalPanel;
import org.apache.jmeter.gui.util.JSyntaxTextArea;
import org.apache.jmeter.gui.util.JTextScrollPane;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.BooleanProperty;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.gui.JLabeledChoice;
import com.hundsun.comparator.ComparatorSampler;

import javax.swing.*;
import java.awt.*;

public class ComparatorSamplerGui extends AbstractSamplerGui {
    private static final long serialVersionUID = 240L;

    private JTextField str1;
    private JTextField str2;

    // 获取元素 的面板
    private JPanel getDomainPanel() {
        str1 = new JTextField(10);
        JLabel label = new JLabel("str1:"); // $NON-NLS-1$
        label.setLabelFor(str1);

        JPanel panel = new HorizontalPanel();
        panel.add(label, BorderLayout.WEST);
        panel.add(str1, BorderLayout.CENTER);
        return panel;
    }

    private JPanel getPortPanel() {
        str2 = new JTextField(10);

        JLabel label = new JLabel("str2"); // $NON-NLS-1$
        label.setLabelFor(str2);

        JPanel panel = new HorizontalPanel();
        panel.add(label, BorderLayout.WEST);
        panel.add(str2, BorderLayout.CENTER);

        return panel;
    }


    public ComparatorSamplerGui() {
        super();
        init();
    }

    private void init() { // WARNING: called from ctor so must not be overridden (i.e. must be private or
        // final)
        creatPanel();
    }

    public void creatPanel() {
        JPanel settingPanel = new VerticalPanel(5, 0);
        settingPanel.add(getDomainPanel());
        settingPanel.add(getPortPanel());
        JPanel dataPanel = new JPanel(new BorderLayout(5, 0));

        dataPanel.add(settingPanel, BorderLayout.NORTH);
        setLayout(new BorderLayout(0, 5));
        setBorder(makeBorder());
        add(makeTitlePanel(), BorderLayout.NORTH); // Add the standard title
        add(dataPanel, BorderLayout.CENTER);
    }

    /*
     * 创建一个新的Sampler，然后将界面中的数据设置到这个新的Sampler实例中
     * */
    @Override
    public TestElement createTestElement() {
        // TODO Auto-generated method stub
        ComparatorSampler sampler = new ComparatorSampler();
        modifyTestElement(sampler);
        return sampler;
    }

    @Override
    public String getLabelResource() {
        // TODO Auto-generated method stub
        throw new IllegalStateException("This shouldn't be called");
        // return "example_title";
        // 从messages_zh_CN.properties读取
    }
    // 命名组件名字
    @Override
    public String getStaticLabel() {
        return "Comparator Sampler";
    }
    /*
     * 把界面的数据移到Sampler中，与configure方法相反
     * */
    @Override
    public void modifyTestElement(TestElement arg0) {
        // TODO Auto-generated method stub
        arg0.clear();
        configureTestElement(arg0);
        arg0.setProperty(ComparatorSampler.str1, str1.getText());
        arg0.setProperty(ComparatorSampler.str2, str2.getText());
    }
    /*
     * reset新界面的时候调用，这里可以填入界面控件中需要显示的一些缺省的值
     * */
    @Override
    public void clearGui() {
        super.clearGui();
        str1.setText("");
        str2.setText("");
    }

    /*
     * 把Sampler中的数据加载到界面中
     * */
    @Override
    public void configure(TestElement element) {

        super.configure(element);
        // JMeter 运行后，保存参数，不然执行后，输入框会情况
        str1.setText(element.getPropertyAsString(ComparatorSampler.str1));
        str2.setText(element.getPropertyAsString(ComparatorSampler.str2));
    }

}
