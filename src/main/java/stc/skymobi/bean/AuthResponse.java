package stc.skymobi.bean;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import stc.skymobi.bean.AbstractCommonBean;
import stc.skymobi.bean.tlv.annotation.TLVAttribute;

/**
 * @author jason.zheng
 *
 */
public class AuthResponse extends AbstractCommonBean {
	@TLVAttribute(tag=10020001)
	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	public String toString() {
        return  ToStringBuilder.reflectionToString(this, 
                            ToStringStyle.SHORT_PREFIX_STYLE);
    } 
}
