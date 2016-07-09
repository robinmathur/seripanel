package com.seri.web.utils.tags;

import com.seri.web.utils.PropertyUtil;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by puneet on 08/07/16.
 */
public class PropertyFetcherTag extends SimpleTagSupport {

    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    public void doTag() throws IOException {
        String keyValue = PropertyUtil.getProperty(key);
        JspWriter out = getJspContext().getOut();
        out.println(keyValue);
    }
}
