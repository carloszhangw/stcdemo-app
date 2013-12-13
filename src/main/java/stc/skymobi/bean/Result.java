/**
 * 
 */
package stc.skymobi.bean;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import stc.skymobi.bean.tlv.annotation.TLVAttribute;

/**
 * @author jason.zheng
 *
 */
@TLVAttribute(tag = 10020001)
public class Result {
	
	@TLVAttribute(tag=10010001)
	private	Integer	resultcode;
	
	@TLVAttribute(tag=10010002, charset="UTF-16BE")
	private	String	resultmsg;	
	
	public Result(int code, String msg){
		this.resultcode = code;
		this.resultmsg = msg;
	}
	
	public Result(){
	}
	
	public Integer getResultcode() {
		return resultcode;
	}

	public void setResultcode(Integer resultcode) {
		this.resultcode = resultcode;
	}

	public String getResultmsg() {
		return resultmsg;
	}

	public void setResultmsg(String resultmsg) {
		this.resultmsg = resultmsg;
	}

	public String toString() {
        return  ToStringBuilder.reflectionToString(this, 
                            ToStringStyle.SHORT_PREFIX_STYLE);
    }  
}
