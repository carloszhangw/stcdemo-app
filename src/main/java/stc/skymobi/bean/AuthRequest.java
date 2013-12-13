package stc.skymobi.bean;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import stc.skymobi.bean.AbstractCommonBean;
import stc.skymobi.bean.tlv.annotation.TLVAttribute;

/**
 * @author jason.zheng
 *
 */
public class AuthRequest extends AbstractCommonBean {
	@TLVAttribute(tag=10020002)
	private UaInfo uainfo;
	
	public UaInfo getUainfo() {
		return uainfo;
	}

	public void setUainfo(UaInfo uainfo) {
		this.uainfo = uainfo;
	}

	@TLVAttribute(tag=10010005)
	private Integer skyid;
	
	@TLVAttribute(tag=10010006)
	private String token;
	
	public String toString() {
        return  ToStringBuilder.reflectionToString(this, 
                            ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Integer getSkyid() {
		return skyid;
	}

	public void setSkyid(Integer skyid) {
		this.skyid = skyid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	} 
}
