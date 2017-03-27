package cn.cloudclass.Test;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
public class TraceLogger {  
    //此处的"tranceLog"为log4j中定义的对应的 logger的name  
    private static final Logger TRACE_LOGGER = LoggerFactory.getLogger("traceLog");  
  
    private TraceLogger() {  
          
    }  
    
    public static void info(String message){  
        TRACE_LOGGER.info(message);  
    }  
  
    public static void info(String format,Object... arguments){  
        TRACE_LOGGER.info(format, arguments);  
    }  
}  