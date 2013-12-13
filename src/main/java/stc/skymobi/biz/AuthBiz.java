/**
 * 
 */
package stc.skymobi.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import stc.skymobi.bean.*;
import stc.skymobi.fsm.FiniteStateMachine;
import stc.skymobi.fsm.tmpl.annotation.OnAccept;
import stc.skymobi.fsm.tmpl.annotation.OnEnter;
import stc.skymobi.fsm.tmpl.annotation.StateTemplate;
import stc.skymobi.netty.handler.codec.http.response.SendbackResponseHelper;
import stc.skymobi.netty.transport.TransportUtils;
import stc.skymobi.netty.transport.Sender;


/**
 * @author jason.zheng
 *
 */
public class AuthBiz {
	
    private static final Logger logger = 
    	LoggerFactory.getLogger(AuthBiz.class);
    
    private	SendbackResponseHelper	sendbackHelper;
    
	public void setSendbackHelper(SendbackResponseHelper sendbackHelper) {
		this.sendbackHelper = sendbackHelper;
	}	
    
	@StateTemplate(init = true)
	class RecvReq {
		@OnAccept
		Class<?> accept(FiniteStateMachine fsm, AuthCtx ctx, AuthRequest req) {

			logger.info("received request {}", req);
			AuthResponse resp = new AuthResponse();
			resp.setIdentification(req.getIdentification());
			resp.setResult(new Result(404));
			ctx.setRequest(req);
			ctx.setResponse(resp);
			return SendResp.class;
		}

	}
	
	@StateTemplate
	class SendResp {
				
		@OnEnter
		boolean enter(FiniteStateMachine fsm, AuthCtx ctx) {		
			
			  // send response
            Sender sender = TransportUtils.getSenderOf(ctx.getRequest());
            if (logger.isDebugEnabled()) {
                logger.debug("SendClientRespState={}", ctx.getResponse());
            }

            if (sender != null) {
            	ctx.getResponse().getResult().setErrorMessage("TCP response");
                sender.send(ctx.getResponse());
            } else {
            	ctx.getResponse().getResult().setErrorMessage("HTTP response");
            	sendbackHelper.makeAndSendback(ctx.getResponse(), ctx.getRequest());
                logger.error("getSender error!");
            }
                       
			return	false;
		}
	}
}

